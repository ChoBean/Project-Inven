<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="/webresources/css/style.css"/>" rel="stylesheet" type="text/css">
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<meta name="viewport" content="width=device-width, initial-scale=1">
   	<script src="<c:url value="/webresources/js/sockjs.min.js"/>"></script>
   	<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   	<script src="<c:url value="/webresources/js/bootstrap.js"/>"></script>
   	<link rel="stylesheet" href="<c:url value="/webresources/css/bootstrap.css"/>"/>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
   	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
	<script src="/webresources/ckeditor/ckeditor.js"></script>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/css/swiper.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/js/swiper.min.js"></script>
 
   <style>
   		body{
   			
   			background: url("<c:url value="/webresources/images/mainImage.jpg"/>") no-repeat center center fixed;
   			height: 100%;
   		}
   		.swiper-container {
			width: 100%;
		    margin-bottom:5%;
		    margin-top:2%;
	    }
    	.swiper-slide {
      		text-align: center;
      		font-size: 18px;
      		background: #fff;
		    /* Center slide text vertically */
		    display: -webkit-box;
		    display: -ms-flexbox;
		    display: -webkit-flex;
		    display: flex;
		    -webkit-box-pack: center;
		    -ms-flex-pack: center;
		    -webkit-justify-content: center;
		    justify-content: center;
		    -webkit-box-align: center;
		    -ms-flex-align: center;
		    -webkit-align-items: center;
		    align-items: center;
    	}
   		
		div.left{
	        width:18%;
	        float:left;
	        box-sizing:border-box;
	        background:#a3d1f0;   
	        border:1px solid #000;
	        margin-bottom: 5%;   
	     }
	     ul{
	        list-style:none;
	        padding-left:0;
	        text-align:center;
	     }
	     div.right{
	        margin-left: 2%;
	        float:left;
	        box-sizing:border-box; 
	        background-color:white;  
	     }
	     li.mainLi{
	        margin-bottom:4%;
	        background:#f3c304;
	        color:white;
	        font-size:17px;
	        font-family:bolder;
	        line-height:50px;
	     }
	     li.memberLi{   
	        line-height:50px;
	     }
	     label.boardLabel{
	        font-size:15px;
	        font-family:"본고딕";   
	        font-weight:bold;
	     }
	     ul{
	        line-height:35px;
	     }
	     li.underLi{
	        border-bottom:1px solid #a8a3a3; width:96%; margin-left: 2%;
	     }
	     a.boardLink{
	        text-decoration:none; color:#212121; 
	     
	     }
	     a.linkA{
	        text-decoration:none; color:white;
	     }
	     label.categoryLabel{
	        font-size:17px;
	        font-family:bolder;
	        color:white;
	     }
	     li.categoryLi{
	        background-color:#26d3b1;
	        line-height:50px;
	        list-style-position:inside;
	        text-align:center;
	     }
	     
	     label.linkLabel{
	        font-size:17px;
	        font-family:"본고딕";
	     }
	     
	     li.linkLi{
	        border-radius:10px;
	        line-height:50px;
	        list-style-position:inside;
	        text-align:center;
	        margin-top:4%;
	     }
	           
	     @media (min-width: 1420px){
	        div.right{
	        width:70%;
	        }
	     }
	  
	     @media screen and (max-width: 768px) {
	         .left{
	            display : none;
	         }
	         div.right{
	            width : 100%; 
	         }
	     }
	     @media screen and (max-width: 1420px) {
	         .bottom{
	            display : none;
	         }
	         #top{
	            display : none;
	         }
	         .right{
	            width : 75%;
	         } 
	     }
	     div.bottom{
	        width: 10%;
	        float: left; 
	        margin-left: 5%;
	        margin-top: 3%;
	     }
	 
	     @media (min-width: 1420px){
	     	div.right{
	        width:70%;
	        }
	        .map{
	        margin-left: 15%;
	        }
	
	     }
	  
	     @media screen and (max-width: 768px) {
	      	.left{
	      		display : none;
	      	}
	      	div.right{
	      		width : 100%; 
	      	}
	      	.menubutton{
	      		display :none;
	      	}
	      	.map{
	      		margin-left: 1%;
	      	}
	      	.footer{
	      		margin-top: 15%;
	      	}
	     }
	     
	     @media all and (min-width: 768px) {
		.navbar{
			display : none;
			position: fixed;  			
		}
	     }
	
	     @media screen and (max-width: 1420px) {
	      	.bottom{
	      		display : none;
	      	}
	      	#top{
	      		display : none;
	      	}
	      	.right{
	      		width : 75%;
	      	}
	
	     }
	     
	     .map{
	     	border : 1px solid;
	     	margin-bottom :2%;
	     	margin-top :2%;
	     	text-align:center;
	     	width: 60%;
	     	height: 100%;
	     }
   </style>
   
   <title>Kartrider Inven</title>
   
</head>
	<body>
		<div class="navbar">
		<nav class="navbar navbar-expand-sm bg-light navbar-light" style="width: 100%;">
			<!-- Brand -->
			<a class="navbar-brand" href="/"><b>INVEN</b></a>
			<!-- Links -->
			<ul class="navbar-nav">
				 <c:catch>
                      <c:choose>
                          <c:when test="${empty authInfo }">
								<li class="nav-item">
			    					<a class="nav-link" href="/login">Login</a>
			  					</li>
			  					<li class="nav-item">
			    					<a class="nav-link" href="/register/step1">Join</a>
			  					</li>
                          </c:when>
                          <c:otherwise>
                              <c:choose>
                                  <c:when test="${authInfo.grade > '0' }">
                                      <li class="nav-item dropdown">
									      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">내정보</a>
									      <div class="dropdown-menu">
									        <a class="dropdown-item" href="/userInfo">마이페이지</a>
									        <a class="dropdown-item" href="/logout">로그아웃</a>
									      </div>
									    </li>
                                  </c:when>
                              </c:choose>
                          </c:otherwise>
                      </c:choose>
                  </c:catch>
			  <!-- Dropdown -->
			    <li class="nav-item dropdown">
			      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			        INFO
			      </a>
			      <div class="dropdown-menu">
			        <a class="dropdown-item" href="/list/playtip/1">공략 게시판</a>
			        <a class="dropdown-item" href="/list/Q&A/1">질문과 답변</a>
			        <a class="dropdown-item" href="/characterListAll/1">캐릭터 정보</a>
			        <a class="dropdown-item" href="/kartInfo/1">카트바디 정보</a>
			        <a class="dropdown-item" href="/mapInfo/1">맵 정보</a>
			        <a class="dropdown-item" href="/trackview">트랙 뷰</a>
			        <a class="dropdown-item" href="/broadcastInfo/broadcast">방송/영상</a>
			      </div>
			    </li>
			    <li class="nav-item dropdown">
			      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			        COMM
			      </a>
			      <div class="dropdown-menu">
			        <a class="dropdown-item" href="/list/free/1">자유 게시판</a>
			        <a class="dropdown-item" href="/list/ucc/1">UCC 게시판</a>
			        <a class="dropdown-item" href="/list/incident/1">사건사고 게시판</a>
			        <a class="dropdown-item" href="/list/meeting/1">모임 게시판</a>
			      </div>
			    </li>
			    <li class="nav-item dropdown">
			      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
			        NEWS
			      </a>
			      <div class="dropdown-menu">
			        <a class="dropdown-item" href="">공지사항</a>
			        <a class="dropdown-item" href="#">리포트 뉴스</a>
			        <a class="dropdown-item" href="#">패치노트</a>
			      </div>
			    </li>
			  </ul>
			</nav>
	</div>
	<div class="container" style="margin-left: 10%;">
       <header>
  
         <div style="margin-top: 5%; margin-bottom: 2%;" class="menubutton">
            <a class="btn btn-secondary btn-lg" href="/" style="margin-right: 2%;">홈</a>
            <a class="btn btn-secondary btn-lg" href="/characterListAll/1" style="margin-right: 2%;">캐릭 정보</a>
            <a class="btn btn-secondary btn-lg" href="/kartInfo/1" style="margin-right: 2%;">카트바디 정보</a>
            <a href="/"><img src="<c:url value="/webresources/images/logo.png"/>" style="margin-right: 2%; margin-left:2%;"></a>
            <a class="btn btn-secondary btn-lg" href="/mapInfo/1" style="margin-right: 2%;">맵 정보</a>
            <a class="btn btn-secondary btn-lg" href="/list/playtip/1" style="margin-right: 2%;">공략 정보</a>
            <a class="btn btn-secondary btn-lg" href="/broadcastInfo/broadcast" style="margin-right: 2%;">방송/영상</a>
         </div>
      </header>
   
      <div class="left">
            <ul>
               <li>
                  <c:catch>
                      <c:choose>
                          <c:when test="${empty authInfo }">
                             <li class="mainLi"><b>KartRider INVEN</b></li>
                             <li class="memberLi">   
                             <a class="btn btn-success btn-block" href="/login" style="margin-bottom:4%">로그인</a>
                                 <a class="btn btn-primary btn-block" href="/register/step1" style="margin-bottom:4%">회원가입</a>
                                 </li>             
                          </c:when>
                          <c:otherwise>
                              <c:choose>
                                  <c:when test="${authInfo.grade eq '10' }">
                                     <li class="mainLi"><b>KartRider INVEN</b></li>
                                     <li class="memberLi">
                                            <p><b>관리자 ${authInfo.name }님, 환영합니다.</b></p>
                                            <a class="btn btn-success btn-block" style="margin-bottom:4%" href="/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                                      </li>
                                  </c:when>
                                  <c:otherwise>
                                     <li class="mainLi"><b>KartRider INVEN</b></li>
                                        <p><b>${authInfo.name }님, 반갑습니다!</b></p>
                                     <li class="memberLi">
                                          <a href="/userInfo" class="btn btn-success btn-block" style="margin-bottom:4%"><i class="fa fa-sign-out"></i> 마이페이지</a>
                                            <a class="btn btn-primary btn-block" href="/logout" style="margin-bottom:4%"><i class="fa fa-sign-out"></i> 로그아웃</a>
                                         </li>
                                  </c:otherwise>
                              </c:choose>
                          </c:otherwise>
                      </c:choose>
                  </c:catch>
               </li>
               <li class="categoryLi">
                  <label class="categoryLabel"><b>INFOMATION</b></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a class="boardLink" href="/listAll/1">통합 검색</a></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a class="boardLink" href="/list/playtip/1">공략 게시판</a></label>
               </li>
               
               <li class="underLi">
                  <label class="boardLabel"><a class="boardLink" href="/list/Q&A/1">질문과 답변</a></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a class="boardLink" href="/characterListAll/1">캐릭터 정보</a></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a class="boardLink" href="/kartInfo/1">카트바디 정보</a></label>
               </li>
               <li>
                  <label class="boardLabel"><a class="boardLink" href="/mapInfo/1">맵 정보</a></label>
               </li>
               <li class="categoryLi">
                  <label class="categoryLabel"><b>COMMUNICATION</b></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a class="boardLink" href="/list/free/1">자유 게시판</a></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a class="boardLink" href="/list/incident/1">사건사고 게시판</a></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a class="boardLink" href="/list/meeting/1">모임 게시판</a></label>
               </li>
               <li>
                  <label class="boardLabel"><a class="boardLink" href="/list/ucc/1">UCC 게시판</a></label>
               </li>
               <li class="categoryLi">
                  <label class="categoryLabel"><b>NEWS</b></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a target="blank" class="boardLink" href="http://kart.nexon.com/Kart/News/Notice/List.aspx">공지사항</a></label>
               </li>
               <li class="underLi">
                  <label class="boardLabel"><a target="blank" class="boardLink" href="http://kart.nexon.com/Kart/News/Media/List.aspx">리포트 뉴스</a></label>
               </li>
               <li>
                  <label class="boardLabel"><a target="blank" class="boardLink" href="http://kart.nexon.com/Kart/News/Patch/List.aspx">패치 노트</a></label>
               </li>
               <li class="linkLi" style="background-color:#3498db;">
                  <label class="linkLabel"><a class="linkA" href="/trackview"><b>트랙 뷰</b></a></label>
               </li>
               <li class="linkLi" style="background-color:#27ae60;">
                  <label class="linkLabel"><a target="blank" class="linkA" href="http://kart.nexon.com/main/index.aspx"><b>공식홈페이지</b></a></label>
               </li>
               <li class="linkLi" style="background-color:#f3c304;">
                  <label class="linkLabel"><a class="linkA" href="/broadcastInfo/broadcast"><b>실시간 방송 보기</b></a></label>
               </li>
            </ul>
      </div>
   