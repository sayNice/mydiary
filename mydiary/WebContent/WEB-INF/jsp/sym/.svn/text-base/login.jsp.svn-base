<!DOCTYPE html PUBLIC "-//W4C//DTD HTML 4.01 Transitional//EN" "http://www.w4.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html > <!--<![endif]-->
<head>

	<title>loginMyDiary</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="concept, responsive bootstrap, green, white, free html5 template, templatemo" />
	<meta name="description" content="写日记" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
	<meta name="baidu-site-verification" content="uYNgJChwyl" />
	
	<%@include file="../framework/footer.jsp"%>
	<%-- <link rel="stylesheet" href="<%=resource %>loginstyle/css/style.css">
	<script src="<c:url value='http://libs.baidu.com/jquery/1.10.2/jquery.min.js'/>"></script>
	<script src="<%=resource %>loginstyle/js/common.js"></script>
	<script src="<%=resource %>loginstyle/js/supersized.3.2.7.min.js"></script> --%>
	<%-- <script src="<%=resource %>loginstyle/js/supersized-int.js"></script> --%>
	<style type="text/css">
		
	</style>
</head>
  
<body >
<div class="container">
<p/>
<form name="login" id="login" method="post" action="loginUser">
		<div class = "row">
			<div class="col-md-3">
				<input type="text" name="username" id="username" class="form-control" placeholder="username" />
			</div>
		</div>
		<p/>
		<div class = "row">
			<div class="col-md-3">
				<input type="password" name="password" id="password" class="form-control" placeholder="password" />
			</div> 
		</div>
		<p/>
		<div>
			<button onclick="loginCheck()"  class="btn btn-red">login</button>
			<button type="button" class="btn btn-red" data-toggle="modal" data-target="#myModal">register</button> 
		</div>
	</form>
</div>

<!--注册Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" <%-- style="background-image : url(<%=resource %>/images/mainImages/${bgs.addBg});background-size:100%; " --%>>
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">注册</h4>
      </div>
      <form action="registUser" id="registf" method="post">
      <div class="modal-body">
        <!-- <div class="row">
        	<label class="col-sm-2 control-label" for="">标题：</label>
        	<div class="col-md-5">
        		<input class="form-control input-sm" id="tilte" name="title" placeholder="标题"/>
        		<br/>
        	</div>
        </div> -->
        	<div class="form-group">
				<input type="text" id="username1" name="username" class="form-control" placeholder="username"/><br/>
				<input type="password" id="password1" name="password" class="form-control" placeholder="password"/><br/>
        		<input type="text" id="niceName1" name="niceName" class="form-control" placeholder="niceName"/><br/>
        		
			</div>
      </div>
      <div class="modal-footer">
        <input type="button" id="goEdit" name="goEdit" onclick="checkRegist()" class="btn btn-info" value="提交"/>
      </div>
      </form>
    </div>
  </div>
</div>


	<script type="text/javascript">
	var msg = "${msg}";
	if(msg != '' && msg != null){
		alertModal(msg,"info");
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
			$.ajax({  
			    type: "POST",  
			    url:"registUser",  
			    data:$("#registf").serialize(),  
			    async: true,
			    success: function(data) {
			    	$("#myModal").modal('hide');
					alertModal(data,"info");
			    },
				error: function(request) {  
			        alertModal("Connection error","info");
			    }
			//$("#registf").submit();
		});
		}
	}
	 /* jQuery(function($){

	    $.supersized({

	        // 功能
	        slide_interval     : 4000,    // 转换之间的长度
	        transition         : 1,    // 0 - 无，1 - 淡入淡出，2 - 滑动顶，3 - 滑动向右，4 - 滑底，5 - 滑块向左，6 - 旋转木马右键，7 - 左旋转木马
	        transition_speed   : 1000,    // 转型速度
	        performance        : 1,    // 0 - 正常，1 - 混合速度/质量，2 - 更优的图像质量，三优的转换速度//（仅适用于火狐/ IE浏览器，而不是Webkit的）

	        // 大小和位置
	        min_width          : 0,    // 最小允许宽度（以像素为单位）
	        min_height         : 0,    // 最小允许高度（以像素为单位）
	        vertical_center    : 1,    // 垂直居中背景
	        horizontal_center  : 1,    // 水平中心的背景
	        fit_always         : 0,    // 图像绝不会超过浏览器的宽度或高度（忽略分钟。尺寸）
	        fit_portrait       : 1,    // 纵向图像将不超过浏览器高度
	        fit_landscape      : 0,    // 景观的图像将不超过宽度的浏览器

	        // 组件
	        slide_links        : 'blank',    // 个别环节为每张幻灯片（选项：假的，'民'，'名'，'空'）
	        slides             : [    // 幻灯片影像
	                                 {image : "<c:url value='/resources/loginstyle/images/1.jpg'/>"},
	                                 {image : "<c:url value='/resources/loginstyle/images/2.jpg'/>"}, 
	                                 {image : "<c:url value='/resources/loginstyle/images/3.jpg'/>"}
	                       ]

	    });

	});  */
	</script>
</body>
</html>
