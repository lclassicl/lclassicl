<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		if ('${sessionScope.userinfo.user_id}' != '') {
			var html = '';
			html += '<section id="ol_after" class="ol">';
			html += '    <header id="ol_after_hd">';
			html += '        <h2>나의 회원정보</h2>';
			html += '        <strong>${sessionScope.userinfo.user_nick}</strong>님 안녕하세요 :)';
			html += '    </header>';
			html += '    <ul id="ol_private1" class="win_private">';
			html += '        <li>';
			html += '            <img src="<c:url value="/resources/images/nobody.png" />" width="64" height="64" />';
			html += '        </li>';
			html += '	<li>';
			html += '		<a class="win_level"><strong>Lv.<b>${sessionScope.userinfo.user_level}</b></strong></a>';
			html += '        </li>';
			html += '	<li>';
			html += '            <a target="_blank" class="win_point">';
			html += '		<img src="<c:url value="/resources/images/win_point.png" />" />';
			html += '                <strong></strong>';
			html += '            </a>';
			html += '        </li>';
			html += '    </ul>';
			html += '	<ul id="ol_private2" class="win_private">';
			html += '        <li>';
			html += '            <a target="_blank" class="win_memo">';
			html += '                <img src="<c:url value="/resources/images/win_message.png" />" />';
			html += '                <strong></strong>';
			html += '            </a>';
			html += '        </li>';
			html += '        <li>';
			html += '            <a href="/forum/main" target="_blank" class="win_scrap">기능구상중</a>';
			html += '        </li>';
			html += '    </ul>';
			html += '    <footer id="ol_after_ft">';
			html += '        <a href="/forum/user/update" id="ol_after_info">회원수정</a>';
			html += '        <a href="/forum/user/logout" id="ol_after_logout">로그아웃</a>';
			html += '    </footer>';
			html += '</section>';
			$('#before_login').html(html);
		}
	});
</script>
</head>
<body>
	<!-- 콘텐츠 시작 { -->
	<div id="wrapper">
		<div id="container">
			<!-- 사이드 -->
			<div id="idx">
				 <div id='topBanner'>
					<a href="/forum/main" target="_blank" ><img
						src="<c:url value="/resources/images/centerbanner.jpg" />" width="828"
						height="150" /></a>
				</div> 
				<br/>
				<!-- 최신글 뿌리기 시작 -->
				<div style='clear: both; float: left; margin: 15px 0'>
					<h2 class="sound_only">최신글</h2>
					<c:forEach var="vo" items="${boa_list}" varStatus="num">
						<c:if test="${num.index%2 == 0}">
							<div style="float: left;">
								<div class="lt " id="article_five">
									<strong class="lt_title"><a href="/forum/board/${vo.boa_url}">${vo.boa_name}</a></strong>
									<div class="lt_more">
										<a href="/forum/board/${vo.boa_url}">
											<span class="sound_only">${vo.boa_name}</span>
											더보기
										</a>
									</div>
									<ul>
										<c:forEach var="list_vo" items="${five_article}">
											<c:if test="${list_vo.key==vo.boa_no}">
												<c:forEach var="art_vo" items="${list_vo.value}">
													<li>
														<a href="/forum/board/${vo.boa_url}/${art_vo.art_no}">${art_vo.art_title}
														<span class="cnt_cmt">
														<c:if test="${art_vo.art_comcount>0}">
															+${art_vo.art_comcount}
														</c:if>
														</span>
														</a>
														<span style='float: right; color: #aaa; font-size: .9em'> ${art_vo.art_regdate} </span>
													</li>
												</c:forEach>
											</c:if>
										</c:forEach>
									</ul>
								</div>
							</div>
						</c:if>
						<c:if test="${num.index%2 != 0}">
							<div style="float: left; margin-left: 20px">
								<div class="lt " id="article_five">
									<strong class="lt_title"><a href="/forum/board/${vo.boa_url}">${vo.boa_name}</a></strong>
									<div class="lt_more">
										<a href="/forum/board/${vo.boa_url}">
											<span class="sound_only">${vo.boa_name}</span>
											더보기
										</a>
									</div>
									<ul>
										<c:forEach var="list_vo" items="${five_article}">
											<c:if test="${list_vo.key==vo.boa_no}">
												<c:forEach var="art_vo" items="${list_vo.value}">
													<li>
														<a href="/forum/board/${vo.boa_url}/${art_vo.art_no}">${art_vo.art_title}
														<span class="cnt_cmt">
														<c:if test="${art_vo.art_comcount>0}">
															+${art_vo.art_comcount}
														</c:if>
														</span>
														</a>
														<span style='float: right; color: #aaa; font-size: .9em'> ${art_vo.art_regdate} </span>
													</li>
												</c:forEach>
											</c:if>
										</c:forEach>
									</ul>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<!-- 최신글 뿌리기 끝 -->
			</div>

			<div id="idxMenu">

				<!-- 로그인 전 아웃로그인 시작 { -->
				<div id="before_login">
				<section id="ol_before" class="ol">
					<h2>회원로그인</h2>
					<form name="foutlogin" action="/forum/user/loginAction" method="post">
						<fieldset>
							<input type="text" id="ol_id" name="user_id" required
								class="required" maxlength="20" placeholder="회원아이디">
							<input type="password" name="user_pw" id="ol_pw" required
								class="required" maxlength="20" placeholder="비밀번호"> <input
								type="submit" id="ol_submit" value="로그인">
							<div id="ol_svc">
								<a href="/forum/user/register"><b>회원가입</b></a>
								<!-- <a href="/forum/result"
									id="ol_password_lost">정보찾기</a> -->
							</div>
						</fieldset>
					</form>
				</section>
				</div>
				<script>
					$omi = $('#ol_id');
					$omp = $('#ol_pw');
					$omp.css('display', 'inline-block').css('width', 133);
					$omi_label = $('#ol_idlabel');
					$omi_label.addClass('ol_idlabel');
					$omp_label = $('#ol_pwlabel');
					$omp_label.addClass('ol_pwlabel');

					$(function() {
						$omi.focus(function() {
							$omi_label.css('visibility', 'hidden');
						});
						$omp.focus(function() {
							$omp_label.css('visibility', 'hidden');
						});
						$omi.blur(function() {
							$this = $(this);
							if ($this.attr('id') == "ol_id"
									&& $this.attr('value') == "")
								$omi_label.css('visibility', 'visible');
						});
						$omp.blur(function() {
							$this = $(this);
							if ($this.attr('id') == "ol_pw"
									&& $this.attr('value') == "")
								$omp_label.css('visibility', 'visible');
						});

						$("#auto_login")
								.click(
										function() {
											if ($(this).is(":checked")) {
												if (!confirm("자동로그인을 사용하시면 다음부터 회원아이디와 비밀번호를 입력하실 필요가 없습니다.\n\n공공장소에서는 개인정보가 유출될 수 있으니 사용을 자제하여 주십시오.\n\n자동로그인을 사용하시겠습니까?"))
													return false;
											}
										});
					});

					function fhead_submit(f) {
						return true;
					}
				</script>
				<!-- } 로그인 전 아웃로그인 끝 -->
				<!-- 사이드 배너 시작 { -->
				<div id="sideBanner">
					<a href='/forum/main'
					target='_blank' > <img
					src='<c:url value="/resources/images/itbanner.jpg" />'
					width="210" height="100" /> </a>
				</div>
				<!-- } 사이드 배너 끝 -->
			</div>
		</div>
	</div>
	<!-- } 콘텐츠 끝 -->
	<%@include file="footer.jsp" %>
</body>
</html>