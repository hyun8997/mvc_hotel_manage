<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hotelList.jsp</title>
<link rel="stylesheet" href="../css/hotel_list.css">
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	
	<br />
	<br />
	
	<div id="hotelCount">총 ${totalCount }개</div>
	
	
	<br />
	
	<c:forEach var="vo" items="${list }">	<!-- list란 이름으로 보낸거 받아서 쓰기 -->
 	<div id="listDiv">
		<div class="hotelImg">
			<c:choose>
				<c:when test="${ad_no==1 }"><img class="imgOfHotel" src="../img/sinlaMain.jpg" alt="신라" /></c:when>
				<c:otherwise><img class="imgOfHotel" src="../img/gladMain.jpg" alt="글레드" /></c:otherwise>
			</c:choose>
		</div>
		<div class="hotelDesc">
			<div id="hname"><p id="nameP"><a href="./hotel.do?cmd=hotelDetail&h_no=${vo.h_no }&ad_no=${ad_no}">${vo.h_name }</a>
				<c:choose>
					<c:when test="${ad_no==1 }"><img class="starOfHotel" src="../img/3star.jpg" alt="신라" /></c:when>
					<c:otherwise><img class="starOfHotel" src="../img/4star.jpg" alt="글레드" /></c:otherwise>
				</c:choose>
					<%-- <c:if test="${ad_no==2 }"><img class="starOfHotel" src="../img/4star.jpg" alt="글레드" /></c:if> --%>
				</p>
			</div>
			<div id="hloc"><p id="locP">${vo.loc }</p></div>
			<div id="hcomment"><p id="commentP">${vo.h_comment }</p></div>
		</div>
		
	
	</div> 
	</c:forEach>
	
	<div id="pages">
		<c:forEach var="i" begin="1" end="${totalPage }">
			<a href="./hotel.do?cmd=hotelList&cp=${i }&ad_no=${ad_no}"><span id="page">[${i }]</span></a>
		</c:forEach>
		<a href="./hotel.do?cmd=hotelInsertForm&ad_no=${ad_no}"><input type="button" value="호텔 추가" /></a>
	</div>
	
</body>
</html>