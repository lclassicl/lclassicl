<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="//apis.daum.net/maps/maps3.js?apikey=2968cad816005016ae122a41912f6927&libraries=services"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<script type="text/javascript">
	var check_id = 'false';
	var check_pw = 'false';
	var check_nick = 'false';
	$(function(){
		$('#reg_mb_id').focusout(function(){
			checkid();
		});
		
		$('#reg_mb_password_re').keyup(function(){
			checkpw();
		});
		
		$('#reg_mb_password').keyup(function(){
			checkpw();
		});
		
		$('#reg_mb_nick').focusout(function(){
			checknick();
		});
	});
	
	function checkid(){
		if($('#reg_mb_id').val().length>=3){
			$.ajax({
				method:'POST',
				url:'./checkid',
				data:{
					user_id:$('#reg_mb_id').val()
				}
			}).done(function(data){
				var checkid='';
				if(data=='success'){
					console.log('성공');
					checkid += '사용가능한 아이디입니다.';
					$('#msg_mb_id').css('color','green');
					check_id='true';
					check_register();
				}else if(data=='fail'){
					console.log('실패');
					checkid += '이미 존재하는 아이디입니다.';
					$('#msg_mb_id').css('color','red');
					check_id='false';
					check_register();
				}else{
					console.log('error');
				}
				$('#msg_mb_id').html(checkid);
			});
		}else{
			$('#msg_mb_id').html('3자이상 입력해주세요.');
			$('#msg_mb_id').css('color','red');
			check_id='false';
			check_register();
		}
	};
	
	function checkpw(){
		if($('#reg_mb_password').val().length>0 || $('#reg_mb_password_re').val().length>0){
			if($('#reg_mb_password').val().length == $('#reg_mb_password_re').val().length){
				if($('#reg_mb_password').val()==$('#reg_mb_password_re').val()){
					$('#msg_mb_password').html('비밀번호가 일치합니다.');
					$('#msg_mb_password').css('color','green');
					check_pw='true';
					check_register();
				}else{
					$('#msg_mb_password').html('비밀번호가 틀립니다.');
					$('#msg_mb_password').css('color','red');
					check_pw='false';
					check_register();
				}
			}else{
				$('#msg_mb_password').html('');
				check_pw='false';
				check_register();
			}
		}
	};
	
	function checknick(){
		if($('#reg_mb_nick').val().length>=3){
			$.ajax({
				method:'POST',
				url:'./checknick',
				data:{
					user_nick:$('#reg_mb_nick').val()
				}
			}).done(function(data){
				var checkid='';
				if(data=='success'){
					console.log('성공');
					checkid += '사용가능한 닉네임입니다.';
					$('#msg_mb_nick').css('color','green');
					check_nick='true';
					check_register();
				}else if(data=='fail'){
					console.log('실패');
					checkid += '이미 존재하는 닉네임입니다.';
					$('#msg_mb_nick').css('color','red');
					check_nick='false';
					check_register();
				}else{
					console.log('error');
				}
				$('#msg_mb_nick').html(checkid);
			});
		}else{
			$('#msg_mb_nick').html('3자이상 입력해주세요.');
			$('#msg_mb_nick').css('color','red');
			check_nick='false';
			check_register();
		}
	};
	
	function check_register(){
		if((check_id=='true')&&(check_pw=='true')&&(check_nick=='true')){
			document.getElementById('btn_submit').disabled=false;
		}else{
			document.getElementById('btn_submit').disabled=true;
		}
	};
</script>

<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('reg_mb_zipcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('reg_mb_address').value = fullRoadAddr;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('msg_mb_address').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('msg_mb_address').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('msg_mb_address').innerHTML = '';
                }
            }
        }).open();
    }
</script>

</head>
<body>
<!-- 콘텐츠 시작 { -->
	<div id="wrapper">
		<div id="container">
			<div id="container_title">회원 가입</div>
			<!-- 회원정보 입력/수정 시작 { -->
			<div class="mbskin">
				<form id="fregisterform" name="fregisterform"
					action="" method="post" >
					<div class="tbl_frm01 tbl_wrap">
						<table>
							<caption>사이트 이용정보 입력</caption>
							<tbody>
								<tr>
									<th scope="row">
										<label for="reg_mb_id">아이디<strong class="sound_only">필수</strong></label>
									</th>
									<td>
										<span class="frm_info">영문자, 숫자, _ 만 입력 가능. 최소 3자이상 입력하세요.</span>
										<input type="text" name="user_id" value=""
											id="reg_mb_id" required class="frm_input required "
											minlength="3" maxlength="20">
										<input type="button" value="중복확인" class="btn_submit" onclick="checkid();"/>
										<span id="msg_mb_id"></span>
									</td>
								</tr>
								<tr>
									<th scope="row">
										<label for="reg_mb_password">비밀번호<strong class="sound_only">필수</strong></label>
									</th>
									<td>
										<input type="password" name="user_pw"
											id="reg_mb_password" required class="frm_input required"
											minlength="3" maxlength="20">
										<span id="msg_mb_password"></span>
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="reg_mb_password_re">비밀번호
											확인<strong class="sound_only">필수</strong>
									</label></th>
									<td><input type="password" name="user_pw_check"
										id="reg_mb_password_re" required class="frm_input required"
										minlength="3" maxlength="20"></td>
								</tr>
								<tr>
									<th scope="row"><label for="reg_mb_nick">닉네임<strong
											class="sound_only">필수</strong></label>
									</th>
									<td>
									<input type="text" name="user_nick" value="" id="reg_mb_nick"
										required class="frm_input required nospace" size="20"
										maxlength="20">
									<input type="button" value="중복확인" class="btn_submit" onclick="checknick();"/>
									<span id="msg_mb_nick"></span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="tbl_frm01 tbl_wrap">
						<table>
							<caption>개인정보 입력</caption>
							<tbody>
								<tr>
									<th scope="row"><label for="reg_mb_name">이름<strong
											class="sound_only">필수</strong></label></th>
									<td>
									<input type="text" id="reg_mb_name" name="user_name"
										value="" required class="frm_input required " size="10">
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="reg_mb_phone">휴대폰<strong
											class="sound_only">필수</strong></label>
									</th>
									<td>
									<input type="text" name="user_phone" value="" id="reg_mb_phone"
										required class="frm_input required nospace">
									<span id="msg_mb_phone"></span>
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="reg_mb_zipcode">우편번호<strong
											class="sound_only">필수</strong></label>
									</th>
									<td>
									<input type="text" name="user_zipcode" value="" id="reg_mb_zipcode" readonly="readonly"
										required class="frm_input required nospace">
									<input type="button" value="우편번호찾기" onclick="execDaumPostcode();" class="btn_submit"/>
									<span id="msg_mb_zipcode"></span>
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="reg_mb_address">주소<strong
											class="sound_only">필수</strong></label>
									</th>
									<td>
									<input type="text" name="user_address" value="" id="reg_mb_address" readonly="readonly"
										required class="frm_input required" size="50" >
									<span id="msg_mb_address"></span>
									</td>
								</tr>
								<tr>
									<th scope="row"><label for="reg_mb_email">Email<strong
											class="sound_only">필수</strong></label>
									</th>
									<td>
									<input type="text" name="user_email" value="" id="reg_mb_email"
										required class="frm_input required nospace" size="50" maxlength="100">
									<span id="msg_mb_email"></span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="tbl_frm01 tbl_wrap">
						<table>
							<caption>기타</caption>
							<tbody>
								<tr>
									<th scope="row">자동등록방지</th>
									<td>
									<div id="recaptcha" >
									<div class="g-recaptcha" data-sitekey="6LeEiQ8UAAAAAMwlRaSEIYOESzhnboAedXhv7Yf-"></div>
									</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="btn_confirm">
						<input type="submit" value="확인" id="btn_submit" class="btn_submit"
							disabled>
						<a href="/forum/main"
							class="btn_cancel">취소</a>
					</div>
				</form>
			</div>
			<!-- } 회원정보 입력/수정 끝 -->
		</div>
	</div>
<%@ include file="../footer.jsp" %>
</body>
</html>