package net.mds.forum.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/loginAction")
	public String login(@ModelAttribute UserVO userVO,HttpSession session,HttpServletRequest request) {
		logger.info("로그인 페이지 수행중");
		UserVO userinfo = null;
		logger.info(userVO.toString());
		try {
			userinfo = userService.getUser(userVO);
			logger.info("로그인성공 : "+userinfo.toString());
			session.setAttribute("userinfo", userinfo);
			session.setMaxInactiveInterval(60*60);
			request.setAttribute("url", "../main");
		} catch (Exception e) {
			logger.info("로그인 실패 : "+e.toString());
			request.setAttribute("url", "../main");
		}
		return "redirect";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session,HttpServletRequest request) {
		logger.info("로그아웃");
		session.invalidate();
		request.setAttribute("url", "../main");
		return "redirect";
	}
	
	@RequestMapping("/userinfo")
	public ModelAndView userinfo() {
		logger.info("회원정보 수행중");
		return null;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateGet(HttpSession session) {
		logger.info("update get 수행중");
		logger.info(session.getAttribute("userinfo")+"");
		return "user/update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePost(@ModelAttribute UserVO userVO, @RequestParam String user_pw_old, HttpServletRequest request) {
		logger.info("update post 수행중");
		logger.info("update post userVO : "+userVO.toString());
		logger.info("user_pw_old : " + user_pw_old);
		UserVO checkuserVO = new UserVO();
		checkuserVO.setUser_id(userVO.getUser_id());
		checkuserVO.setUser_pw(user_pw_old);
		String result = "";
		try {
			result = userService.checkoldpw(checkuserVO);
			if(result.equals("success")){
				//cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e
				//위에값은 sha512의 null값
				if(!userVO.getUser_pw().equals("cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e")){
					userService.userUpdate(userVO);
				}else{
					userVO.setUser_pw(user_pw_old);
					userService.userUpdate(userVO);
				}
				request.setAttribute("msg", "업데이트에 성공하셨습니다.");
				request.setAttribute("url", "/forum/user/logout");
			}else{
				request.setAttribute("msg", "이전비밀번호를 확인하세요.");
				request.setAttribute("url", "javascript:history.back();");
			}
		} catch (Exception e) {
			request.setAttribute("msg", "error : "+e.toString());
			request.setAttribute("url", "javascript:history.back();");
		}
		return "result";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerGet() {
		return "user/register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPost(HttpServletRequest request,@ModelAttribute UserVO userVO) {
		String response = request.getParameter("g-recaptcha-response");
		String secretKey="6LeEiQ8UAAAAAPSDhRxmYICYvVuUdoDr1nZXt0tB";
		String url = "https://www.google.com/recaptcha/api/siteverify";
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("secret", secretKey);
		map.add("response", response);
		
		RestTemplate restTemplate = new RestTemplate();
		JsonResult jr = restTemplate.postForObject(url, map, JsonResult.class);
		
		logger.info(userVO.toString());
		
		if(jr.getSuccess()){
			try {
				userService.userRegister(userVO);
				logger.info("register success");
				request.setAttribute("msg", "가입에 성공하셧습니다.");
				request.setAttribute("url", "../main");
				return "result";
			} catch (Exception e) {
				//request.setAttribute("userVO", userVO);
				logger.info("database fail : "+e.toString());
				request.setAttribute("msg",	"등록에 실패하였습니다. : "+e.toString());
				request.setAttribute("url",	"javascript:history.back();");
				return "result";
			}
		}else{
			//request.setAttribute("userVO", userVO);
			logger.info("register fail");
			request.setAttribute("msg",	"자동등록방지를 해주세요.");
			request.setAttribute("url",	"javascript:history.back();");
			return "result";
		}
	}
	
	@RequestMapping("/checkid")
	@ResponseBody
	public String checkid(@RequestParam String user_id) {
		logger.info("checkid 수행중");
		String result = "";
		try {
			result = userService.checkid(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/checknick")
	@ResponseBody
	public String checknick(@RequestParam String user_nick) {
		logger.info("checknick 수행중");
		String result = "";
		try {
			result = userService.checknick(user_nick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
