package net.mds.forum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.mds.forum.board.ArticleVO;
import net.mds.forum.board.BoardService;
import net.mds.forum.board.BoardVO;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "main")
	public String Main(HttpServletRequest request) {
		List<BoardVO> boa_list = null;
		try {
			boa_list = boardService.getBoardListAll();
			Map<Integer, List<ArticleVO>> five_article = new HashMap<Integer, List<ArticleVO>>();
			for(BoardVO vo : boa_list){
				int key = vo.getBoa_no();
				List<ArticleVO> value = boardService.getArticleListFive(key);
				five_article.put(key, value);
			}
			logger.info("main five_article : "+five_article.toString());
			request.setAttribute("five_article", five_article);
			request.setAttribute("boa_list", boa_list);
		} catch (Exception e) {
			request.setAttribute("url", "http://naver.com");
			request.setAttribute("msg", "에러 : "+e.toString());
			return "result";
		}
		return "main";
	}
	
	@RequestMapping(value = "result")
	public String result(HttpServletRequest request) {
		String url="javascript:history.back();";
		String msg="잘못된 접근입니다.";
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		
		return "result";
	}
	
	@RequestMapping(value = "permit")
	public String permit(HttpServletRequest request) {
		String url="javascript:history.back();";
		String msg="권한이 없습니다. 등업해주세요.";
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		
		return "result";
	}
	
	@RequestMapping(value = "nosession")
	public String nosession(HttpServletRequest request) {
		String url="javascript:history.back();";
		String msg="로그인이 필요한 기능입니다. 로그인해주세요.";
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		
		return "result";
	}
	
	@RequestMapping(value = "/error404")
	public String error(HttpServletRequest request,HttpServletResponse res) {
		res.setStatus(HttpServletResponse.SC_OK);
		String url="/forum/main";
		String msg="잘못된 url입니다.";
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		
		return "result";
	}
}
