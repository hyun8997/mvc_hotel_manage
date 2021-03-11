<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="hotel">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
        content="width=device-width, initial-scale=1, user-scalable=no, maximum-scale=1, minimum-scale=1">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/header.css">
<title>header.jsp</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
 	$(function(){
		$('#resergo').click(Logingo)
		
		function Logingo(){
			alert("로그인을 해주세요!!");
			document.required_login.action = "./hotel.do?cmd=loginForm";
			document.required_login.method = "get"; 			// post 교체
			document.required_login.submit();
		}
	});
</script>
</head>
<body>
	<div class="body__container">
        <header class="section">
            <div class="inner clearfix">
                <div class="menu-group float--left">
                    <div class="logo">
                        <a href="hotelMain.jsp">여기어때</a>
                    </div>
                </div>
                <div class="sign-group float--right toggle">
                	<div class="btn-group">
                        <a class="btn sign-in" href="./hotel.do?cmd=loginForm">로그인</a>
                    </div>
                    <form id="search-form" method="post" action="">
                        <input id="search" class="input--text" type="text" placeholder="지역,숙소명">
                        <input type="submit">
                    </form>
                    <ul class="navi">
                        <li><a href="#">예약내역</a></li>
                        <li><a href="#">더보기</a>
                            <ul>
                                <li><a href="#">공지사항</a></li>
                                <li><a href="#">자주묻는질문</a></li>
                                <li><a href="#">1:1문의사항</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
	</div>
</body>
</html>