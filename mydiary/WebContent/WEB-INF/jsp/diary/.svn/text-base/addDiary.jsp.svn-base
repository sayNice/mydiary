<!DOCTYPE html PUBLIC "-//W4C//DTD HTML 4.01 Transitional//EN" "http://www.w4.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String resource = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"resources"+"/";
%>

<html > <!--<![endif]-->
<head>
	<title>Write Remember</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="concept, responsive bootstrap, green, white, free html5 template, templatemo" />
	<meta name="description" content="Concept is free responsive template using bootstrap framework. Gallery is integrated with responsive lightbox." />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    
    <link rel="stylesheet" href="<%=resource %>css/bootstrap.css">
    
    <script src="<%=resource %>js/jquery.min.js"></script>
    <script src="<%=resource %>js/bootstrap.js"></script>
    
</head>
 <style>
	body{background:#FF8000;}
 .snowbg{clear:both;margin:0 auto;position:relative;overflow:hidden;}
.snow{position:absolute;top:0;color:#fff;} 
</style> 
  </head>
  
  <body>
  
  	<div class="container snowbg">
  		<div class="row">
        	<div class="col-md-5">
        		<lable class="control-label" for="">标题：</lable>
        		<input class="form-control input-sm" id="tilte" name="title" placeholder="标题"/>
        		<br/>
        	</div>
        </div>
        <p/>
        <p/>
        	<div class="form-group">
			<label for="name">内容：</label>
				<textarea class="form-control" rows="15" id="context" name="content"></textarea>
			</div>
		<a href="toDiaryPage" id="diaryList" >跳转到日志页面</a>
		<div style='float:right;'>
       	 	<button type="button" onclick="checkAdd()" class="btn btn-success">保存</button>
        	<button type="button" onclick="tempAdd()" class="btn btn-primary">保存至草稿箱</button>
        </div>
        
  	</div>
  	<script type="text/javascript">
  	 $(function(){
    	  var d="<div class='snow'>❅<div>";
    				setInterval(function(){
    					var f=$(document).width();
    					var e=Math.random()*f-100;
    					var o=0.3+Math.random();
    					var fon=10+Math.random()*30;
    					var l = e - 100 + 200 * Math.random();
    					var k=2000 + 5000 * Math.random();
    					$(d).clone().appendTo(".snowbg").css({
    						left:e+"px",
    						opacity:o,
    						"font-size":fon,
    					}).animate({
    					  top:"500px",
    						left:l+"px",
    						opacity:0.1,
    					},k,"linear",function(){$(this).remove()})
    				},100);
    	}); 
  	
  	function checkAdd(){
		var context = $("#context").val();
		if(context ==''){
			alert("请输入内容后提交。");
		}else{
			var title = $("#tilte").val();
			var context = $("#context").val();
			console.log(title);
			console.log(context);
			$.ajax({
				type:"POST",
				url:"<c:url value='addDiary'/>",
				data:{
					title:title,
					context:context
				},
				success: function (data, status) {
					console.log(data);
					if(data = "true"){
						alert("添加成功");
					}
				}
			});
		}
	}
  	
  	function tempAdd(){
		var title = $("#tilte").val();
		var content = $("#context").val();
		$.ajax({
			type:"post",
			url:"<c:url value='tempAdd'/>",
			data:{title:title,
				content:content},
			success:function(data,status){
				console.log("data===="+data)
				if(data == 1){
					alert("添加草稿成功。");
				}else if(data == 2){
					alert("草稿箱有数据啦，先处理那个。");
				}
			}
		});
	}
  	
  	</script>
  </body>
</html>
