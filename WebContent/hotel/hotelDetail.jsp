<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hotelDetail.jsp</title>

<link rel="stylesheet" href="../css/hotel_detail.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#delConfirm").on('click', function(){
			
			var flag = confirm("정말 삭제하시겠습니까?");
			
			if(flag){
				//console.log("삭제 수행");
				//창 이동시키기 -> DeleteAction()이 수행되도록 처리
				location.href = "./hotel.do?cmd=hotelDelete&h_no=${vo.h_no}&ad_no=${vo.ad_no}";
			}
		});
	});

	// Open the Modal
	function openModal() {
	  document.getElementById("myModal").style.display = "block";
	}
	
	// Close the Modal
	function closeModal() {
	  document.getElementById("myModal").style.display = "none";
	}
	
	var slideIndex = 1;
	showSlides(slideIndex);
	
	// Next/previous controls
	function plusSlides(n) {
	  showSlides(slideIndex += n);
	}
	
	// Thumbnail image controls
	function currentSlide(n) {
	  showSlides(slideIndex = n);
	}
	
	function showSlides(n) {
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("demo");
	  var captionText = document.getElementById("caption");
	  if (n > slides.length) {slideIndex = 1}
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	    slides[i].style.display = "none";
	  }
	  for (i = 0; i < dots.length; i++) {
	    dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";
	  dots[slideIndex-1].className += " active";
	  captionText.innerHTML = dots[slideIndex-1].alt;
	}
	
	
</script>
</head>
<body>
	<jsp:include page="./header.jsp"></jsp:include>
	
	<br />
	<br />
	
	<div id="hNameCon">
		<p id="hName">${vo.h_name }</p> <br />
		<p id="loc">${vo.loc }</p> <br />
	</div>
	
	<!-- 호텔 이미지 라이트 박스용 사진, 고정임 -->
	<div id="imgCon">
	  <div id="hotelMaincon">
	    <img id="img1" src="../img/hotel1.jpg" onclick="openModal();currentSlide(1)" class="hover-shadow">
	  </div>
	  <div id="hotelConvCon">
		  <div class="subImg">
		    <img id="img2" src="../img/hotel2.jpg" onclick="openModal();currentSlide(2)" class="hover-shadow">
		  </div>
		  <div class="subImg">
		    <img id="img3"  src="../img/hotel3.jpg" onclick="openModal();currentSlide(3)" class="hover-shadow">
		  </div>
		  <div class="subImg">
		    <img id="img4"  src="../img/hotel4.jpg" onclick="openModal();currentSlide(4)" class="hover-shadow">
		  </div>
	  </div>
	</div>
	
	<!-- The Modal/Lightbox -->
	<div id="myModal" class="modal">
	  <span class="close cursor" onclick="closeModal()">&times;</span>
	  <div class="modal-content">
	
	    <div class="mySlides">
	      <div class="numbertext">1 / 4</div>
	      <img src="../img/hotel1.jpg" style="width:100%">
	    </div>
	
	    <div class="mySlides">
	      <div class="numbertext">2 / 4</div>
	      <img src="../img/hotel2.jpg" style="width:100%">
	    </div>
	
	    <div class="mySlides">
	      <div class="numbertext">3 / 4</div>
	      <img src="../img/hotel3.jpg" style="width:100%">
	    </div>
	
	    <div class="mySlides">
	      <div class="numbertext">4 / 4</div>
	      <img src="../img/hotel4.jpg" style="width:100%">
	    </div>
	
	    <!-- Next/previous controls -->
	    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	    <a class="next" onclick="plusSlides(1)">&#10095;</a>
	
	    <!-- Caption text -->
	    <div class="caption-container">
	      <p id="caption"></p>
	    </div>
	
	    <!-- Thumbnail image controls -->
	    <div id="windowDiv">
	      <img id="windowImg1" class="demo" src="../img/hotel1.jpg" onclick="currentSlide(1)" alt="호텔전망">
	    
	      <img id="windowImg2"  class="demo" src="../img/hotel2.jpg" onclick="currentSlide(2)" alt="호텔정문">
	    
	      <img id="windowImg3"  class="demo" src="../img/hotel3.jpg" onclick="currentSlide(3)" alt="카페">
	    
	      <img id="windowImg4"  class="demo" src="../img/hotel4.jpg" onclick="currentSlide(4)" alt="수영장">
	    </div>
	  </div>
	</div>
	
	
	
	<div id="hConvCon">
		<p id="hexp">세계적인 서비스로 슈퍼스타 대접을 받아보세요!</p> <br />
		<p id="hComment">${vo.h_comment }</p> <br /> <br />
		<p id="hConv">${vo.h_conv }</p>
	</div>
	
	
	<!-- 가짜 방 테이블 -->
	
	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					
					<div class="table-wrap">
						<table class="table">
						  <thead class="thead-primary">
						    <tr>
						    	
						    	<th>Image</th>
						    	<th>Room</th>
						    	<th>Price</th>
						    	<th>MaxPpl</th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr class="alert" role="alert">
						    	<td>
						    		<div class="img" style="background-image: url(../img/room1.jpg);"></div>
						    	</td>
						      	<td>
							      	<div class="email">
							      		<span>디럭스 킹룸 </span>
							      		<span>객실 크기 48 m²</span>
							      	</div>
						     	</td>
						      	<td>￦341,000</td>
						      	<td class="quantity">
					        		3
				          		</td>
							</tr>

						    <tr class="alert" role="alert">
						    	<td>
						    		<div class="img" style="background-image: url(../img/room2.jpg);"></div>
						    	</td>
						      	<td>
							      	<div class="email">
							      		<span>프리미엄 킹 룸 </span>
							      		<span>객실 크기 48 m²</span>
							      	</div>
						      	</td>
						      	<td>￦374,000</td>
						      	<td class="quantity">
						        	3
				          		</td>
				            </tr>
				            
							<tr class="alert" role="alert">
						    	<td>
						    		<div class="img" style="background-image: url(../img/room3.jpg);"></div>
						    	</td>
						        <td>
							      	<div class="email">
							      		<span>그랜드 킹 코너 스위트룸 </span>
							      		<span>객실 크기 96 m²</span>
							      	</div>
						        </td>
						        <td>￦720,500</td>
						        <td class="quantity">
						        	2
				          	    </td>
				            </tr>

						    <tr class="alert" role="alert">
						    	<td>
						    		<div class="img" style="background-image: url(../img/room4.jpg);"></div>
						    	</td>
						        <td>
							      	<div class="email">
							      		<span>이그제큐티브 킹룸 - 강 전망 </span>
							      		<span>객실 크기 48 m²</span>
							      	</div>
						        </td>
						        <td>￦577,500</td>
						        <td class="quantity">
						        	3
				          		</td>
				            </tr>

						    <tr class="alert" role="alert">
						    	<td class="border-bottom-0">
						    		<div class="img" style="background-image: url(../img/room5.jpg);"></div>
						    	</td>
						        <td class="border-bottom-0">
							      	<div class="email">
							      		<span>그랜드 킹 이그제큐티브 코너 스위트룸 </span>
							      		<span>객실 크기 96 m²</span>
							      	</div>
						        </td>
						        <td>￦835,000</td>
						        <td class="quantity">
						        	2
				          	    </td>
				            </tr>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<div id="btns">
	
		<a href="./hotel.do?cmd=hotelModify&h_no=${vo.h_no}&ad_no=${vo.ad_no}"><input type="button" value="수정" /></a>
		<input type="button" value="삭제" id="delConfirm"/>
		
	</div>
	
	
</body>
</html>