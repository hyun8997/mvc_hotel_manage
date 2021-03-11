<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hotelModify.jsp</title>
<link rel="stylesheet" href="../css/hotel_insert.css">
<script type="text/javascript">
	$(document).ready(function(){
		$("#sendMsg").on('click', function(){
			document.frm.submit();
		});
		
		$('textarea').autoResize();
	});
</script>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	
	<br />
	<br />
	
	<form action="#" name="frm">
		<input type="hidden" name="cmd" value="hotelModifyOk" />
		<input type="hidden" name="h_no" value="${vo.h_no }" />
		<input type="hidden" name="ad_no" value="${vo.ad_no }" />
		<div id="insertContainer">
			<div>
				<p>수정할 호텔 정보 입력</p>
			</div>
			<div id="h_name">
				<p>
					<span>${vo.h_name }</span>
					
				</p>
			</div>
			<div id="loc"> 
				<p>
					<span>${vo.loc }</span>
					
				</p>
			</div>
			<div id="h_conv">
				<p>
					<textarea class="hotelTextarea" name="conv" id="conv" cols="100" placeholder="편의시설">${vo.h_conv }</textarea>
				</p>
			</div>
			<div id="h_comment">
				<p>
					<textarea class="hotelTextarea" name="comment" id="comment" cols="800" placeholder="호텔 설명">${vo.h_comment }</textarea>
				</p>
			</div>
			
			<div id="button">
				<p>
					<a href="./hotel.do?cmd=hotelList&ad_no=${vo.ad_no}"><input class="hbtn" type="button" value="목록보기"></a>
					<input class="hbtn" type="submit" value="작성하기" id="sendMsg">
					<input class="hbtn" type="reset" value="다시쓰기">
				</p>
			</div>
			
			
		</div>
	
	</form>
	
</body>
</html>