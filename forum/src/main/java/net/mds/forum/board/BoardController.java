package net.mds.forum.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.mds.forum.user.UserVO;

@Controller
@RequestMapping(value="board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	private PageNation pageNation;
	
	@Autowired
	private PageNationSearch pageNationSearch;
	
	@RequestMapping(value={"","/"})
	public String defaultboard(HttpServletRequest request){
		request.setAttribute("url", "/forum/board/free");
		return "redirect";
	}
	
	@RequestMapping(value="{boa_url}")
	public String board(@PathVariable String boa_url, HttpSession session, HttpServletRequest request){
		logger.info("board 실행중 url : "+boa_url);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		if(userinfo==null){
			request.setAttribute("url", "/forum/nosession");
			return "redirect";
		}
		List<BoardVO> boardList = null;
		BoardVO boa = new BoardVO();
		int boa_no = 0;
		int pg = 1;
		try {
			boardList = boardService.getboardList(boa_url);
			if(boardList.isEmpty()){
				request.setAttribute("url", "javascript:history.back();");
				request.setAttribute("msg", "잘못된 접근입니다.");
				return "result";
			}else{
				for(BoardVO boardVO : boardList){
					if(boardVO.getBoa_url().equals(boa_url)){
						boa_no = boardVO.getBoa_no();
						boa.setBoa_no(boa_no);
						boa.setBoa_level(boardVO.getBoa_level());
						boa.setBoa_name(boardVO.getBoa_name());
						boa.setBoa_type(boardVO.getBoa_type());
						boa.setBoa_url(boardVO.getBoa_url());
						break;
					}
				}
				if(userinfo.getUser_level()<boa.getBoa_level()){
					request.setAttribute("url", "/forum/permit");
					return "redirect";
				}
				if(request.getParameter("pg")!=null){
					pg = Integer.parseInt(request.getParameter("pg"));
				}
				pageNation.process(boa_no, pg, boa_url);
				request.setAttribute("pageNation", pageNation);
				request.setAttribute("boardList", boardList);
				request.setAttribute("boa", boa);
			}
		} catch (Exception e) {
			request.setAttribute("url", "javascript:history.back();");
			request.setAttribute("msg", "에러입니다. : "+e.toString());
			return "result";
		}
		
		return "board/board";
		
	}
	
	
	@RequestMapping(value="{boa_url}/search")
	public String boardSearch(@PathVariable String boa_url, HttpSession session, HttpServletRequest request, @RequestParam String searchCondition, @RequestParam String searchKeyword, @RequestParam long pg) {
		logger.info("boardsearch 실행중 url : "+boa_url);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		if(userinfo==null){
			request.setAttribute("url", "/forum/nosession");
			return "redirect";
		}
//		String searchCondition = request.getParameter("searchCondition");
//		String searchKeyword = request.getParameter("searchKeyword");
		List<BoardVO> boardList = null;
		BoardVO boa = new BoardVO();
		int boa_no = 0;
//		int pg = 1;
		try {
			boardList = boardService.getboardList(boa_url);
			if(boardList.isEmpty()){
				request.setAttribute("url", "javascript:history.back();");
				request.setAttribute("msg", "잘못된 접근입니다.");
				return "result";
			}else{
				for(BoardVO boardVO : boardList){
					if(boardVO.getBoa_url().equals(boa_url)){
						boa_no = boardVO.getBoa_no();
						boa.setBoa_no(boa_no);
						boa.setBoa_level(boardVO.getBoa_level());
						boa.setBoa_name(boardVO.getBoa_name());
						boa.setBoa_type(boardVO.getBoa_type());
						boa.setBoa_url(boardVO.getBoa_url());
						break;
					}
				}
				if(userinfo.getUser_level()<boa.getBoa_level()){
					request.setAttribute("url", "/forum/permit");
					return "redirect";
				}
				if(request.getParameter("pg")!=null){
					pg = Integer.parseInt(request.getParameter("pg"));
				}
				pageNationSearch.process(boa_no, pg, boa_url, searchCondition, searchKeyword);
				request.setAttribute("pageNation", pageNationSearch);
				request.setAttribute("boardList", boardList);
				request.setAttribute("boa", boa);
			}
		} catch (Exception e) {
			request.setAttribute("url", "javascript:history.back();");
			request.setAttribute("msg", "에러입니다. : "+e.toString());
			return "result";
		}
		
		return "board/boardSearch";
	}
	
	@RequestMapping(value="{boa_url}/{art_no}")
	public String articleDetail(@PathVariable String boa_url,@PathVariable int art_no, HttpServletRequest request, HttpSession session){
		List<BoardVO> boardList = null;
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		if(userinfo==null){
			request.setAttribute("url", "/forum/nosession");
			return "redirect";
		}
		BoardVO boa = new BoardVO();
		ArticleVO articleVO = new ArticleVO();
		articleVO.setArt_no(art_no);
		try {
			boardList = boardService.getboardList(boa_url);
			if(boardList.isEmpty()){
				request.setAttribute("url", "javascript:history.back();");
				request.setAttribute("msg", "잘못된 접근입니다.");
				return "result";
			}else{
				for(BoardVO boardVO : boardList){
					if(boardVO.getBoa_url().equals(boa_url)){
						boa.setBoa_no(boardVO.getBoa_no());
						boa.setBoa_level(boardVO.getBoa_level());
						boa.setBoa_name(boardVO.getBoa_name());
						boa.setBoa_type(boardVO.getBoa_type());
						boa.setBoa_url(boardVO.getBoa_url());
						break;
					}
				}
				boardService.plusReadCount(art_no);
				articleVO = boardService.getArticleDetail(articleVO);
				if(articleVO==null){
					request.setAttribute("url", "javascript:history.back();");
					request.setAttribute("msg", "잘못된 접근입니다.");
					return "result";
				}
				request.setAttribute("articleVO", articleVO);
				request.setAttribute("boardList", boardList);
				request.setAttribute("boa", boa);
				return "article/detail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("url", "/forum/main");
			request.setAttribute("msg", "오류 : "+e.toString());
			return "result";
		}
	}
	
	@RequestMapping(value="{boa_url}/insert")
	public String insertArticleGet(@PathVariable String boa_url, HttpServletRequest request, HttpSession session){
		logger.info("insert get 실행중");
		List<BoardVO> boardList = null;
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		if(userinfo==null){
			request.setAttribute("url", "/forum/nosession");
			return "redirect";
		}
		BoardVO boa = new BoardVO();
		try {
			boardList = boardService.getboardList(boa_url);
			if(boardList.isEmpty()){
				request.setAttribute("url", "javascript:history.back();");
				request.setAttribute("msg", "잘못된 접근입니다.");
				return "result";
			}else{
				for(BoardVO boardVO : boardList){
					if(boardVO.getBoa_url().equals(boa_url)){
						boa.setBoa_no(boardVO.getBoa_no());
						boa.setBoa_level(boardVO.getBoa_level());
						boa.setBoa_name(boardVO.getBoa_name());
						boa.setBoa_type(boardVO.getBoa_type());
						boa.setBoa_url(boardVO.getBoa_url());
						break;
					}
				}
				request.setAttribute("boardList", boardList);
				request.setAttribute("boa", boa);
			}
		} catch (Exception e) {
			request.setAttribute("url", "javascript:history.back();");
			request.setAttribute("msg", "에러입니다. : "+e.toString());
			return "result";
		}
		return "article/insert";
	}
	
	@RequestMapping(value="{boa_url}/insert",method=RequestMethod.POST)
	public String insertArticlePost(@PathVariable String boa_url, @ModelAttribute ArticleVO articleVO, HttpSession session, HttpServletRequest request){
		articleVO.setUser_no(((UserVO)session.getAttribute("userinfo")).getUser_no());
		try {
			boardService.insertArticle(articleVO);
			request.setAttribute("url", "/forum/board/"+boa_url);
			return "redirect";
		} catch (Exception e) {
			request.setAttribute("url", "javascript:history.back();");
			request.setAttribute("msg", "에러입니다. : "+e.toString());
			return "result";
		}
	}
	
	@RequestMapping(value="{boa_url}/{art_no}/update", method=RequestMethod.GET)
	public String updateArticleGet(@PathVariable String boa_url,@PathVariable int art_no, HttpServletRequest request, HttpSession session){
		logger.info("update get 실행중 ");
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		if(userinfo==null){
			request.setAttribute("url", "/forum/nosession");
			return "redirect";
		}
		List<BoardVO> boardList = null;
		BoardVO boa = new BoardVO();
		ArticleVO articleVO = new ArticleVO();
		articleVO.setArt_no(art_no);
		try {
			boardList = boardService.getboardList(boa_url);
			if(boardList.isEmpty()){
				request.setAttribute("url", "javascript:history.back();");
				request.setAttribute("msg", "잘못된 접근입니다.");
				return "result";
			}else{
				for(BoardVO boardVO : boardList){
					if(boardVO.getBoa_url().equals(boa_url)){
						boa.setBoa_no(boardVO.getBoa_no());
						boa.setBoa_level(boardVO.getBoa_level());
						boa.setBoa_name(boardVO.getBoa_name());
						boa.setBoa_type(boardVO.getBoa_type());
						boa.setBoa_url(boardVO.getBoa_url());
						break;
					}
				}
				articleVO = boardService.getArticleDetail(articleVO);
				if(articleVO==null || userinfo.getUser_no()!=articleVO.getUser_no()){
					request.setAttribute("url", "javascript:history.back();");
					request.setAttribute("msg", "잘못된 접근입니다.");
					return "result";
				}
				request.setAttribute("articleVO", articleVO);
				request.setAttribute("boardList", boardList);
				request.setAttribute("boa", boa);
				logger.info(articleVO.toString());
				return "article/update";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("url", "/forum/main");
			request.setAttribute("msg", "오류 : "+e.toString());
			return "result";
		}
	}
	
	@RequestMapping(value="{boa_url}/{art_no}/update", method=RequestMethod.POST)
	public String updateArticlePost(@PathVariable String boa_url, @PathVariable int art_no, @ModelAttribute ArticleVO articleVO, HttpServletRequest request, HttpSession session){
		logger.info("update post 실행중 ");
		logger.info(articleVO.toString());
		
		try {
			boardService.updateArticle(articleVO);
			request.setAttribute("url", "/forum/board/"+boa_url);
			return "redirect";
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("url", "javascript:history.back();");
			request.setAttribute("msg", "오류 : " + e.toString());
			return "result";
		}			
	}
	
	@RequestMapping(value="{boa_url}/{art_no}/delete")
	public String delete(@PathVariable String boa_url,@PathVariable int art_no, HttpSession session, HttpServletRequest request){
		logger.info(art_no + " ");
		ArticleVO articleVO = new ArticleVO();
		articleVO.setArt_no(art_no);
		UserVO userinfo = (UserVO) session.getAttribute("userinfo");
		try {
			articleVO = boardService.getArticleDetail(articleVO);
			if(articleVO==null || userinfo.getUser_no()!=articleVO.getUser_no()){
				request.setAttribute("url", "javascript:history.back();");
				request.setAttribute("msg", "잘못된 접근입니다.");
				return "result";
			}
			boardService.deleteArticle(art_no);
			request.setAttribute("url", "/forum/board/"+boa_url);
			request.setAttribute("msg", "삭제되었습니다.");
			return "result";
		} catch (Exception e) {
			request.setAttribute("url", "javascript:history.back();");
			request.setAttribute("msg", "오류 : "+e.toString());
			return "result";
		}
	}
}
