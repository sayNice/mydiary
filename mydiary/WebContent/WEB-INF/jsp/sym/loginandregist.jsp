<!DOCTYPE html PUBLIC "-//W4C//DTD HTML 4.01 Transitional//EN" "http://www.w4.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String resource = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"resources"+"/";
%>

<html > <!--<![endif]-->
<head>

	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="concept, responsive bootstrap, green, white, free html5 template, templatemo" />
	<meta name="description" content="Concept is free responsive template using bootstrap framework. Gallery is integrated with responsive lightbox." />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">

    <link href='<%=resource %>css/gooleapis.css' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="<%=resource %>css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=resource %>css/animate.css">
    <link rel="stylesheet" href="<%=resource %>css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=resource %>css/templatemo_misc.css">


	<link rel="stylesheet" href="<%=resource %>css/templatemo_style.css">

    <link rel="shortcut icon" href="<%=resource %>images/ico/favicon.ico">
    
    <link rel="stylesheet" type="text/css" href="<%=resource %>css/modal/demo.css">
	<link rel="stylesheet" type="text/css" href="<%=resource %>css/modal/iziModal.css">
	
	<link href="<c:url value='/resources/css/bootstrap.min.css'/>"  rel="stylesheet">
	
	<script src="<%=resource %>js/jquery.min.js"></script>
    <script src="<%=resource %>js/modernizr.js"></script>
	<script src="<%=resource %>js/bootstrap.js"></script>
	<script src="<%=resource %>js/tabs.js"></script>
	<script src="<%=resource %>js/templatemo_custom.js"></script>
	<script src="<%=resource %>js/modal/iziModal.min.js" type="text/javascript"></script>
</head>
  
<body >


<div class="menu-container">
<div class="container">
<div id="msg">${msg}</div>
<input  type="hidden" id="but1" class="trigger-default" />
<form name="login" id="login" method="post" action="loginUser">
	<div class="row">
		<div class="col-md-3">
    		<input type="text" name="username"  id ="username" class="form-control" placeholder="username">
    		<br/>
  		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
    		<input type="password" name="password" id="password" class="form-control" placeholder="password">
    		<br/>
  		</div>
	</div>
	<div class="btn_div">
		<button type="button" onclick="loginCheck()" class="btn btn-success">登录</button>
		<!-- <button type="button" class="btn btn-success" id="regist" onclick="toRegist()">注册</button> -->
	</div>
	</form>
</div>
</div>

<div id="modal-default" class="iziModal">
		<form action="registUser" id="registf" method="post">
		<input type="text" id="username1" name="username" placeholder="username"/><br/><br/>
		<input type="password" id="password1" name="password" placeholder="password"/><br/><br/><br/>
        <input type="text" id="niceName1" name="niceName" placeholder="niceName"/><br/><br/>
        <input type="button" id="goEdit" name="goEdit" onclick="checkRegist()" class="btn btn-info" value="提交"/>
        </form>
</div>
	<script type="text/javascript">
	$("#modal-default").iziModal({
    	title: "Hi!",
    	subtitle: "注册",
    	iconClass: 'icon-announcement',
    	width: 700,
    	padding: 20
	});
	function alertModal(title){
		$("#modal-default").iziModal({
        	title: "Hi!",
        	subtitle: title,
        	iconClass: 'icon-announcement',
        	width: 700,
        	padding: 20
    	});
	}; 
	function toRegist(){
		$("#but1").click();
	}
	
	$(document).on('click', '.trigger-default', function (event) {
        event.preventDefault();
        $('#modal-default').iziModal('open');
    });
	
	function checkRegist(){
		var username=$("#username1").val();
		var password=$("#password1").val();
		var nicename=$("#niceName1").val();
		if(username == ''){
			alert("请输入用户名！");
			return false;
		}else if(password ==''){
			alert("请输入密码！");
			return false;
		}else if(nicename == ''){
			alert("请输入昵称！");
			return false;
		}else{
			$("#registf").submit();
		}
	}
	function loginCheck(){
		var username=$("#username").val();
		var password=$("#password").val();
		if(username == ''){
			alert("请输入用户名！");
			return false;
		}else if(password ==''){
			alert("请输入密码！");
			return false;
		}else{
			$("#login").submit();
		}
	}
	</script>
</body>
</html>
