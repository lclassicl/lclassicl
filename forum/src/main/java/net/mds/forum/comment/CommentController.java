package net.mds.forum.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mds.forum.board.BoardService;

@Controller
@RequestMapping(value="board/{boa_url}/{art_no}/comment")
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list",method=RequestMethod.POST,
			headers="Accept=application/json;charset=UTF-8",
			produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public List<CommentVO> getCommentList(HttpServletRequest request){
		int art_no = Integer.parseInt(request.getParameter("art_no"));
		logger.info("comment list 수행중 art_no : "+art_no);
		List<CommentVO> com_list = null;
		try {
			com_list = commentService.getCommentList(art_no);
			logger.info("com_list : "+com_list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return com_list;
	}
	
	@RequestMapping(value="{com_no}",method=RequestMethod.POST,
			headers="Accept=application/json;charset=UTF-8",
			produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public CommentVO getComment(@PathVariable int com_no){
		logger.info("comment list 수행중 art_no : "+com_no);
		CommentVO commentVO = new CommentVO();
		try {
			commentVO = commentService.getComment(com_no);
			logger.info("comment list 수행중 commentVO : "+commentVO.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentVO;
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	@ResponseBody
	public int insertComment(HttpServletRequest request) {
		int count = 0;
		CommentVO commentVO = new CommentVO();
		commentVO.setArt_no(Integer.parseInt(request.getParameter("art_no")));
		commentVO.setCom_content(request.getParameter("com_content"));
		commentVO.setUser_no(Integer.parseInt(request.getParameter("user_no")));
		logger.info("comment insert 수행중");
		logger.info("commentVO : "+commentVO.toString());
		try {
			commentService.insertComment(commentVO);
			boardService.plusCommentCount(commentVO.getArt_no());
			count = boardService.getCommentCount(commentVO.getArt_no());
		} catch (Exception e) {
			logger.info("에러 : "+e.toString());
		}
		return count;
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public int deleteComment(HttpServletRequest request,@PathVariable int art_no) {
		int count = 0;
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		logger.info("comment delete 수행중");
		logger.info("commentVO : "+request.getParameter("com_no"));
		try {
			commentService.deleteComment(com_no);
			boardService.minusCommentCount(art_no);
			count = boardService.getCommentCount(art_no);
		} catch (Exception e) {
			logger.info("에러 : "+e.toString());
		}
		return count;
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public String deleteComment(HttpServletRequest request) {
		CommentVO commentVO = new CommentVO();
		commentVO.setCom_no(Integer.parseInt(request.getParameter("com_no")));
		commentVO.setCom_content(request.getParameter("com_content"));
		logger.info("comment update 수행중");
		logger.info("commentVO : "+commentVO.toString());
		try {
			commentService.updateComment(commentVO);
			return "success";
		} catch (Exception e) {
			logger.info("에러 : "+e.toString());
			return "failure";
		}
	}
}
