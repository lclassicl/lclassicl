<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/tinymce/tinymce.min.js" />"></script>
<script src="<c:url value="/resources/js/tinymce/tinymce.dev.js" />"></script>
<script src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/lib/bootstrap.css" />" />
<script>
tinymce.init({ 
    selector:'textarea'
    ,width: 800
    ,height: 200
    ,menubar: true	
    ,plugins: [
      'advlist autolink lists link image charmap print preview anchor',
      'searchreplace visualblocks code fullscreen',
      'insertdatetime media table contextmenu paste code '
    ]
   ,toolbar: 'undo redo | insert | styleselect | bold italic fontsizeselect | ' +
             'alignleft aligncenter alignright alignjustify | '  +
             'bullist numlist outdent indent | link image code custom_image '
   

	,language:'ko'
   
  	,image_title: true, 
  	relative_urls: false,
  	images_upload_base_path:'/forum/file/download',
  	  // enable automatic uploads of images represented by blob or data URIs
  	  automatic_uploads: true,
  	  // URL of our upload handler (for more details check: https://www.tinymce.com/docs/configure/file-image-upload/#images_upload_url)
  	  images_upload_url: '/forum/file/upload',
  	  // here we add custom filepicker only to Image dialog
  	  file_picker_types: 'image', 
  	  // and here's our custom image picker
  	  file_picker_callback: function(cb, value, meta) {
  	    var input = document.createElement('input');
  	    input.setAttribute('type', 'file');
  	    input.setAttribute('accept', 'image/*');
  	    
  	    // Note: In modern browsers input[type="file"] is functional without 
  	    // even adding it to the DOM, but that might not be the case in some older
  	    // or quirky browsers like IE, so you might want to add it to the DOM
  	    // just in case, and visually hide it. And do not forget do remove it
  	    // once you do not need it anymore.

  	    input.onchange = function() {
  	      var file = this.files[0];
  	      console.log(file);
  	      // Note: Now we need to register the blob in TinyMCEs image blob
  	      // registry. In the next release this part hopefully won't be
  	      // necessary, as we are looking to handle it internally.
  	      var id = 'blobid' + (new Date()).getTime();
  	      var blobCache = tinymce.activeEditor.editorUpload.blobCache;
  	      var blobInfo = blobCache.create(id, file);
  	      blobCache.add(blobInfo);
  	      
  	      // call the callback and populate the Title field with the file name
  	      cb(blobInfo.blobUri(), { title: file.name });
  	      
  	      console.log(cb);
  	    };
  	    
  	    input.click();
  	  }
   
   
});

$(document).ready(function() {
	$('#btn_submit').submit(function () {
		tinymce.triggerSave();
	});
});
</script>
</head>
<body>
<div id="wrapper">
<div id="container">
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
	<br/>
		<section id="bo_w">
    		<h2 id="container_title">${boa.boa_name} 글쓰기</h2>
		<form action="" method="post" autocomplete="off" style="width:100%">
			<input type="hidden" value="${boa.boa_no}" id="boa_no" name="boa_no" />
			<input type="hidden" value="html1" name="html" /> 
				<div class="tbl_frm01 tbl_wrap">
					<table>	
						<tbody>
							<tr>
				            	<th scope="row">
				            		<label for="wr_subject">제목<strong class="sound_only">필수</strong></label>
				           		</th>
				            	<td>
				               		<div id="autosave_wrapper">
					                    <input type="text" name="art_title" value="" id="wr_subject" required class="frm_input required" size="100" maxlength="255">					
				                    </div>
				            	</td>
				        	</tr>
							<tr>
								<td class="wr_content" colspan="2">
									<textarea name="art_content">
										
									</textarea>
								</td>
							</tr>				
						</tbody>
					</table>
				</div>
			<div>
	    		<div class="btn_confirm">
					<input type="submit" value="작성완료" id="btn_submit" class="btn_submit">
					<a href="javascript:history.back();" class="btn_cancel">취소</a>
				</div>
			</div>			
		</form>
		</section>
	</div>
</div>
</div>

<!-- Modal -->
	<div class="modal fade" id="imageUpload" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h4 class="modal-title">사진 첨부하기</h4>
				</div>
				<div class="modal-body">
					<form action="<c:url value="/file/upload" />" id="myform"
						method="post" enctype="multipart/form-data">
						<input type="file" id="upfile" name="upfile"
							accept="image/*,video/*[, MIME_TYPES]">
					</form>
					<br />
					<p>
						10MB이하의 이미지 파일만 등록할 수 있습니다.<br /> (JPG, GIF, PNG, BMP)
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="btnImageUpload">업로드</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
			</div>
<!-- Modal content END-->
		</div>
	</div>
</body>
</html>