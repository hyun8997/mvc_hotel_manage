<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="hotel">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
        content="width=device-width, initial-scale=1, user-scalable=no, maximum-scale=1, minimum-scale=1">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/ListForm.css">
<title>loginMain.jsp</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#loginBtn").click(function(){
			document.frm.action = "./hotel.do?cmd=loginOk";
			document.frm.submit();
		});
		
		
	});
	
</script>
<style type="text/css">
	#loginDiv{text-align: center;}
</style>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	
	<br />
	<div id="loginDiv">
	<form action="#" name="frm">
		<input type="hidden" name="cmd" value="loginOk"/>
		<h3>ID</h3>
		<input type="text" name="id" id="" size="30"/> <br /><br />
		<h3>PW</h3>
		<input type="text" name="pw" id="" size="30" /> <br /><br />
		<input type="button" value="로그인" id="loginBtn"/>
		
	</form>
	</div>
	
	
	
</body>
</html>