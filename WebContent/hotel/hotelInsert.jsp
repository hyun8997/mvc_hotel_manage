<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hotelInsert.jsp</title>
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
		<input type="hidden" name="cmd" value="hotelInsert" />
		<input type="hidden" name="ad_no" value="${ad_no }" />
		<div id="insertContainer">
			<div>
				<p>추가할 호텔 정보 입력</p>
			</div>
			<div id="h_name">
				<p>
					<span>호텔명 : </span>
					<input type="text" name="hn" id="hn">
				</p>
			</div>
			<div id="loc"> 
				<p>
					<span>위치 : </span>
					<input type="text" name="loc" id="loc">
				</p>
			</div>
			<div id="h_conv">
				<p>
					<textarea class="hotelTextarea" name="conv" id="conv" cols="100" placeholder="편의시설"></textarea>
				</p>
			</div>
			<div id="h_comment">
				<p>
					<textarea class="hotelTextarea" name="comment" id="comment" cols="800" placeholder="호텔 설명"></textarea>
				</p>
			</div>
			
			<div id="button">
				<p>
					<a href="./hotel.do?cmd=hotelList&ad_no=${ad_no}"><input class="hbtn" type="button" value="목록보기"></a>
					<input class="hbtn" type="submit" value="수정하기" id="sendMsg">
					<input class="hbtn" type="reset" value="다시쓰기">
				</p>
			</div>
			
			
		</div>
	
	</form>
	
	
</body>
</html>