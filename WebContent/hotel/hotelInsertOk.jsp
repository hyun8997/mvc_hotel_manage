<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	window.onload=function(){
		setTimeout(function(){
			
			location.href = "./hotel.do?cmd=hotelList&ad_no=${ad_no}";
			
		}, 1000);
	}
</script>