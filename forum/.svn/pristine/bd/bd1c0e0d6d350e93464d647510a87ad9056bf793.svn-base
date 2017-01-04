<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<script type="text/javascript">
 function check() {
	 if(document.fsearch.searchKeyword.value == "") {
		 alert("검색어를 입력하세요.");
		 document.fsearch.searchKeyword.focus();
		 return;
	 }
	 document.fsearch.submit();
 }
	
</script>
</head>
<body>
	<!-- 콘텐츠 시작 { -->
	<div id="wrapper">
		<div id="container">

			<!-- 사이드 -->

			<div id="sidePannel">
				<div id="sideMenu">
					<ul>
						<li class="sideTitle"><strong>${boa.boa_type}</strong></li>
						<c:forEach var="vo" items="${boardList}">
							<c:if test="${vo.boa_url==boa.boa_url}">
								<li class='pickup'><a href="/forum/board/${vo.boa_url}">${vo.boa_name}</a></li>
							</c:if>
							<c:if test="${vo.boa_url!=boa.boa_url}">
								<li><a href="/forum/board/${vo.boa_url}">${vo.boa_name}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>

			<div id="mainContent">

				<h2 id="container_title">
					<span style='vertical-align: middle'>${boa.boa_name}</span> <span
						class="sound_only"> 목록</span> <a href="/forum/board/${boa.boa_url}?pg=${pageNation.pg}"
						target="_blank"> <img src='<c:url value="/resources/images/rss.png" />'
						width='12' />
					</a>
				</h2>

				<!-- 게시판 목록 시작 { -->
				<div id="bo_list" style="width: 100%">


					<!-- 게시판 페이지 정보 및 버튼 시작 { -->
					<div class="bo_fx">
						<div id="bo_list_total">
							<span>전체 : ${pageNation.totalCount}건 ${pageNation.pg}페이지</span>
						</div>
						<ul class="btn_bo_user">
							<li><a href="/forum/board/${boa.boa_url}/insert" class="btn_b02">글쓰기</a></li>
						</ul>
					</div>


					<!-- } 게시판 페이지 정보 및 버튼 끝 -->

					<form name="fboardlist" id="fboardlist"
						action="./board_list_update.php"
						onsubmit="return fboardlist_submit(this);" method="post">

						<div class="tbl_head01 tbl_wrap">
							<table>
								<caption>자유게시판 목록</caption>

								<thead>
									<tr>
										<th scope="col" width=70px>번호</th>
										<th scope="col" style='text-align: center; padding-left: 8px'>제목</th>
										<th scope="col" style='text-align: right; padding-left: 8px'>글쓴이</th>
										<th scope="col">날짜</th>
										<th scope="col">조회</th>
										<th scope="col">추천</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="vo" items="${pageNation.list}">
										<tr class="">
											<td class="" style='text-align: center'>${vo.art_no}</td>
											<td>
												<div>
													<a href="/forum/board/${boa.boa_url}/${vo.art_no}">${vo.art_title}
													<span class="cnt_cmt">
													<c:if test="${vo.art_comcount>0}">
														+${vo.art_comcount}
													</c:if>
													</span>
													</a>
												</div>
											</td>

											<td class="td_name sv_use">${vo.user_nick}</td>
											<td class="td_date">${vo.art_regdate}</td>
											<td class="td_num">${vo.art_readcount}</td>
											<td class="td_num">${vo.art_good}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</form>
				</div>

				${pageNation.display}

				<!-- 게시판 검색 시작 { -->
				<fieldset id="bo_sch">
					<legend>게시물 검색</legend>

					<form name="fsearch" method="get" action="/forum/board/${boa.boa_url}/search">
						<input type="hidden" name="pg" value="1">
						<select name="searchCondition" id="sfl" class="frm_input" size="1">
							<option value="art_title" <c:if test="${'art_title' == pageNation.pageSearchVO.searchCondition }">selected</c:if>>제목</option>
							<option value="art_content" <c:if test="${'art_content' == pageNation.pageSearchVO.searchCondition }">selected</c:if>>내용</option>
							<option value="user_nick" <c:if test="${'user_nick' == pageNation.pageSearchVO.searchCondition }">selected</c:if>>글쓴이</option>
						</select> 
						<label for="stx" class="sound_only">검색어 
							<strong class="sound_only"> 필수</strong>
						</label> 
						<input type="text" name="searchKeyword" value="${pageNation.pageSearchVO.searchKeyword}" required id="stx" class="frm_input required" size="15" maxlength="20"> 
						<input type="button" value="검색" class="btn_submit" onClick="check()">
						<!-- <input type="hidden" name="page" value="1"> -->
					</form>
				</fieldset>
				<!-- } 게시판 검색 끝 -->
				<!-- } 게시판 목록 끝 -->
			</div>
		</div>
	</div>
	<!-- } 콘텐츠 끝 -->
</body>
</html>

<!-- 사용스킨 : basic -->
