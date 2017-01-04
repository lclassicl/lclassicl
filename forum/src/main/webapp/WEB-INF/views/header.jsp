<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>핵 맛 !! - 내가 아는 가장 핵맛집은 어디?</title>
<link rel="stylesheet" href="<c:url value="/resources/lib/default.css" />">
<link rel="stylesheet" href="<c:url value="/resources/lib/style.css" />">
<link rel="stylesheet" href="<c:url value="/resources/lib/html_style.css" />">
<link rel="stylesheet" href="<c:url value="/resources/lib/lastest_basic_style.css" />">
<link rel="stylesheet" href="<c:url value="/resources/lib/outlogin_basic_style.css" />">
<link rel="stylesheet" href="<c:url value="/resources/lib/buttons.css" />" type="text/css" media="all" />
<link rel="stylesheet" href="<c:url value="/resources/lib/buttons2.css" />" type="text/css" media="all" />
<link rel="stylesheet" href="<c:url value="/resources/lib/jquery-ui.css" />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/lib/jquery.qtip.css" />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/lib/font-awesome.css" />" rel="stylesheet">



<!-- jquery script -->
<script src="<c:url value="/resources/js/jquery-1.12.3.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.numeric.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.hotkeys.js" />"></script>
<script src="<c:url value="/resources/js/jquery.qtip.js" />"></script>
<script src="<c:url value="/resources/js/jquery.scrollUp.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.touchslider.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.menu.js" />"></script>
<script src="<c:url value="/resources/js/common.js" />"></script>
<script src="<c:url value="/resources/js/wrest.js" />"></script>
<script src="<c:url value="/resources/js/jquery.easing.1.3.js" />"></script>
<script src="<c:url value="/resources/js/jquery.easy-ticker.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.raty.js" />"></script>
</head>
<body>
    
<!-- 상단 시작 { -->
	<div id="hd">
		<h1 id="hd_h1">핵 맛 !! - 내가 아는 가장 핵맛집은 어디?</h1>

		<div id="skip_to_container">
			<a href="#container">본문 바로가기</a>
		</div>
		<div id="hd_wrapper">

			<div id="logo">
				<a href="/forum/main"><img
					src="<c:url value="/resources/images/toplogo.jpg" />"
					title="ad1"></a>
			</div>
			
			<fieldset id="hd_sch">
				<legend>사이트 내 전체검색</legend>
				<form name="fsearchbox" method="get"
					action="https://search.naver.com/search.naver"  target="_blank">
					<input type="hidden" name="where" value="nexearch">
					<input type="hidden" name="sm" value="top_hty">
					<input type="hidden" name="fbm" value="0">
					<input type="hidden" name="ie" value="utf8">
					<label for="sch_stx" class="sound_only">검색어<strong class="sound_only">필수</strong></label>
					<input type="text" name="query" id="sch_stx"
						placeholder="검색어를 입력해 주세요" maxlength="20">
					<!-- <input type="submit" id="sch_submit" value="검색"> -->
					<input type="image" id="sch_submit"
						src="<c:url value="/resources/images/search2.png" />">
						
				</form>
				<script>
					function fsearchbox_submit(f) {
						if (f.stx.value.length < 2) {
							alert("검색어는 두글자 이상 입력하십시오.");
							f.stx.select();
							f.stx.focus();
							return false;
						}

						// 검색에 많은 부하가 걸리는 경우 이 주석을 제거하세요.
						var cnt = 0;
						for (var i = 0; i < f.stx.value.length; i++) {
							if (f.stx.value.charAt(i) == ' ')
								cnt++;
						}

						if (cnt > 1) {
							alert("빠른 검색을 위하여 검색어에 공백은 한개만 입력할 수 있습니다.");
							f.stx.select();
							f.stx.focus();
							return false;
						}

						return true;
					}
				</script>
				
			</fieldset>
			
		</div>
		
		<nav id="gnb">
			<h2>메인메뉴</h2>
			<ul id="gnb_1dul">
				<li class="gnb_1dli" style="z-index: 999"><a
					href="/forum/board/free" target="_self"
					class="gnb_1da"> 커뮤니티 </a>
					<ul class="gnb_2dul">
						<li class="gnb_2top"><img
							src="<c:url value="/resources/images/menutop.png" />" /></li>
						<li class="gnb_2dli"><a
							href="/forum/board/notice" target="_self"
							class="gnb_2da"> 공지사항 </a></li>
						<li class="gnb_2dli"><a
							href="/forum/board/free" target="_self"
							class="gnb_2da"> 자유게시판 </a></li>
						<li class="gnb_2dli"><a
							href="/forum/board/qa" target="_self"
							class="gnb_2da"> 질문게시판 </a></li>
						<li class="gnb_2dli"><a
							href="/forum/board/tip" target="_self"
							class="gnb_2da"> 팁앤가이드 </a></li>
					</ul></li>
				<li class="gnb_1dli" style="z-index: 998"><a
					href="/forum/board/photo" target="_self"
					class="gnb_1da"> 미디어 </a>
					<ul class="gnb_2dul">
						<li class="gnb_2top"><img
							src="<c:url value="/resources/images/menutop.png" />" /></li>
						<li class="gnb_2dli"><a
							href="/forum/board/photo" target="_self"
							class="gnb_2da"> 사진게시판 </a></li>
						<li class="gnb_2dli"><a
							href="/forum/board/media" target="_self"
							class="gnb_2da"> 영상게시판 </a></li>
					</ul></li>
				<li class="gnb_1dli" style="z-index: 997"><a
					href="/forum/board/roadshop" target="_self"
					class="gnb_1da"> 몸무게가 UP!! </a>
				<li class="gnb_1dli" style="z-index: 996"><a
					href="/forum/board/buy" target="_self"
					class="gnb_1da"> Market </a>
					<ul class="gnb_2dul">
						<li class="gnb_2top"><img
							src="<c:url value="/resources/images/menutop.png" />" /></li>
						<li class="gnb_2dli"><a
							href="/forum/board/buy" target="_self"
							class="gnb_2da"> 삽니다 </a></li>
						<li class="gnb_2dli"><a
							href="/forum/board/sell" target="_self"
							class="gnb_2da"> 팝니다 </a></li>
					</ul></li>
				<li class="gnb_1dli" style="z-index: 995"><a
					href="/forum/board/favorite" target="_self"
					class="gnb_1da"> 즐겨찾기 </a>
			</ul>
		</nav>
	</div>
	<!-- } 상단 끝 -->
	<hr>
	<script>
		$(document).ready(
				function() {
					$(window).scroll(
							function() {
								if ($(document).scrollTop() < 120) {
									if ($('#gnb').hasClass('fixed')) {
										$('#gnb').removeClass('fixed');
										$('#wrapper').css('padding-top', 0);
										$('#new_menu').fadeIn();
									}
									if ($('#topUp:visible'))
										$('#topUp').fadeOut();
								} else {
									if (!$('#gnb').hasClass('fixed')) {
										$('#gnb').addClass('fixed');
										$('#wrapper').css('padding-top',
												$('#gnb').outerHeight())
												+ 'px';
										$('#new_menu').fadeOut();
									}
									if ($('#topUp:hidden'))
										$('#topUp').fadeIn();
								}
							});
				});
	</script>
</body>
</html>