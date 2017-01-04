<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   String user_id = "";
%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>네이년</title>
<script type="text/javascript"
   src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
   charset="utf-8"></script>
<script type="text/javascript"
   src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body align="center">
   <form method="post" action="login_action.jsp" />
      <label for="user_id"> 아이디 : </label>
      <input type="text" name="user_id" id="user_id" value="<%=user_id%>" />
      <br />
      <label for="user_pw"> 암 &nbsp; 호 : </label>
      <input type="password" name="user_pw" id="user_pw" />
      <br />
      <input type="checkbox" name="save_id" 
         <%=user_id.equals("") ? "" : " checked "%> /> 아이디 저장
      <br />
      <input type="submit" value="로그인" />
      <input type="button" value="회원등록" onclick="location.href='regist.jsp';" />
   </form>
   <br/>
   
    네이버 아이디로 로그인 : 


   <!-- 네이버아이디로로그인 버튼 노출 영역 -->
   <div id="naver_id_login"></div>
   <!-- //네이버아이디로로그인 버튼 노출 영역 -->
   <script type="text/javascript">
      var naver_id_login = new naver_id_login("SgSyk2W3pZT0Kc7F8jCT",
            "http://192.168.0.110/forum/");
      var state = naver_id_login.getUniqState();
      naver_id_login.setButton("white", 2, 40);
      naver_id_login.setDomain("192.168.10.138/forum/");
      naver_id_login.setState(state);
      //naver_id_login.setPopup();
      naver_id_login.init_naver_id_login();
   </script>


   <script type="text/javascript">
      var naver_id_login = new naver_id_login("SgSyk2W3pZT0Kc7F8jCT",
            "http://192.168.10.138/forum/");
      // 접근 토큰 값 출력
      alert(naver_id_login.oauthParams.access_token);
      // 네이버 사용자 프로필 조회
      naver_id_login.get_naver_userprofile("naverSignInCallback()");
      // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
      function naverSignInCallback() {
         alert(naver_id_login.getProfileData('email'));
         alert(naver_id_login.getProfileData('nickname'));
         alert(naver_id_login.getProfileData('age'));
      }
   </script>
   
   <div id="naverSignInCallback"></div>
</html>