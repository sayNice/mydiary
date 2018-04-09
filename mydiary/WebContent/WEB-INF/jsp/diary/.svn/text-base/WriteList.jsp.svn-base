<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html > <!--<![endif]-->
<head>
	<title>My Diary</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="concept, responsive bootstrap, green, white, free html5 template, templatemo" />
	<meta name="description" content="Concept is free responsive template using bootstrap framework. Gallery is integrated with responsive lightbox." />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <%@include file="../framework/footer.jsp"%>
    <%-- <script type="text/javascript" src="<c:url value='/resources/tool/weather/jquery.leoweather.min.js'/>"></script> --%>
   <!--  <style>
		.snowbg{clear:both;margin:0 auto;position:relative;overflow:hidden;}
		.snow{position:absolute;top:0;color:#fff;}
</style> -->
<style type="text/css">
	.border
	{	
		border:1px ;
		border-radius:2px;
		border-style: solid;
		border-color: #F00
	}
</style>
</head>

  <%--style="background-image : url(<%=resource %>/images/bg3.jpg);background-size:100%;" --%>
  <body>
    <div class="container">
    <div style="height: 10px;" >
   		<a style="float: right; color:#EE82EE;" role="button" data-toggle="collapse" href="#collapseSearch" aria-expanded="ture" aria-controls="collapseSearch">
     	s/h
  		</a>
   	</div>
    <br />
    <c:if test="${username.id=='41' || username.id=='42'}">
		<div class="pull-left">
		<a href="javascript:jump()"> 
			<img src="<%=resource %>/images/head1.jpg" style="width:40px ; height:40px;" alt="头像" class="img-responsive img-circle">
		</a>
		</div>
	</c:if>
		<div id="collapseSearch" class="collapse" > 
		<div class="pull-right">
			Hi! ${username.niceName}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-red"  role="button" href="outloginUser">登出</a>
			<a class="btn btn-red"  role="button" onclick="eidtModal()">设置</a>&nbsp;
			<!-- <a href="photo" class="btn btn-red">相片</a> -->
			<%-- <c:if test="${username.id=='41' || username.id=='42'}">
				<button type="button" id="Export" class="btn btn-red">导出</button>
			</c:if> --%>
		</div>
		<hr style='filter:alpha(opacity=0,finishopacity=100,style=1)' width='100%' class="btn-red" size='5'>
		<div class = "row">
		<form action="toDiaryPage" method="POST" id = "form">
			<div class="col-md-3">
			<label class="control-label" style="float:left;">标题:</label>
    		<input type="text" name="title" id="searchTitle" class="form-control" value="${title}" placeholder="支持模糊查询"/>
  			</div>

				<div class = "col-md-3">
                <label for="dtp_input1" class="control-label">开始:</label>
                <div class="input-group date form_datetime" id="date1"  >
                    <input class="form-control" size="16" type="text" name="createDate1" id="createDate1" value="${createDate1}" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
  				</div>
  				</div>
  				<div class = "col-md-3">
                <label for="dtp_input1" class="control-label">结束:</label>
                <div class="input-group date form_datetime" id="date2"  >
                    <input class="form-control" size="16" type="text" name="createDate2" id="createDate2" value="${createDate2}" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
                </div>
                <input type="hidden" name="offset" id="pageIndex" value="1" />
             </form>
            </div>
            <div class="pull-right">
            	<br>
            	<button type="button" id="Search" class="btn btn-red">查询</button>
            </div>
            <hr style='filter:alpha(opacity=0,finishopacity=100,style=1)' width='100%' class="btn-red" size='5'>
            <div class="row">
  			<audio controls="controls" id="nicemusic" loop="false">
  				<source src="<%=basePath %>music/Uptown Funk.mp3" type="audio/mpeg" />
  				Your browser does not support the audio element.
			</audio>
			<br/>
			
			<!--<a href="javascript:void(0);" style="color:red;" onclick = "nextSong()" id = "nextSong">下一首</a>-->
  		</div>
  		<div class="pull-right">
            	<button type="button" class="btn btn-red" data-toggle="modal" data-target="#myMusicModal">歌单</button>
            </div>
            <hr style='filter:alpha(opacity=0,finishopacity=100,style=1)' width='100%' class="btn-red" size='5'>		
		</div>
		
		<!-- 警告提示框 --><%-- style="background-image : url(<%=resource %>/images/wan1.jpg);background-size:100%; " --%>
		<div class="alert alert-success alert-dismissable fade in" id = "alertMsg" hidden>
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
				&times;
			</button>
			<div id="almsg">
				
			</div>
		</div>
		
		<!-- 节日提示框 -->
		<div class="alert  alert-success alert-dismissable fade in" style="background-image : url(<%=resource %>/images/xuejing.jpg);background-size:100%; " id="dayTip" hidden>
			  今立冬，好冷好冷~多穿点衣服。
		</div> 
		<!-- 天气提示框 -->
		<!-- <div class="alert" style="background:#d5080f;" id="wearthTip" >
			 <span id="weather"></span>
		</div> --> 
		
		<div class='pull-right'>
  			<button type="button" class="btn btn-red" data-toggle="modal" data-target="#myModal">新建</button> 
  			<!-- <a  class="btn btn-success" href = "newAddDiary" >新建</a> -->
  			<button type="button" class="btn btn-red" onclick="checkTempDiay()">草稿箱</button>
  			<!-- <button type="button" class="btn btn-red" onclick="Analysis()">分析</button> -->
  			<!-- <button type="button" class="btn btn-warning" onclick="CanDel()">删除</button> -->
  		</div>
  		<div class = 'row'>
  		</div>
	<!-- <table id ="table" ></table> -->
	<div class="row">
 <div class="panel-group" id="accordion">
 <c:forEach var="writeList" items="${writeList}"> 
	
		<div class = "col-md-4" >
		<br>
		<div class="border">
			<div class = "panel">
				<div style="color:#F00;">
					<div style="float:left;width:35px;text-align:center;">
						<span style="font-size:23px;font-weight:bold;">${writeList.day}</span><br>
						<span>${writeList.month}</span>
					</div>
					<div class = "pull-right">
						<a href="javascript:CanDel(${writeList.rowId})" data-toggle="remove">x</a>
					</div>
					<div style="padding:10px">
						<span style="font-size:10px;font-weight:bold;">${writeList.creatDateS}</span><br/>
						<a style="font-size:13px;color:#F00;" data-toggle="collapse" data-parent="#accordion" href="#${writeList.rowId}">
				   ${writeList.simpleContent}
				   </a>
					</div>
	
				</div>
					
				<div id="${writeList.rowId}" class="panel-collapse collapse">
				<div class = "panel-body">
					<p>
						${writeList.content}
					</p>
				</div>
				</div>
			</div>
			</div>
	</div>
	 </c:forEach> 
</div> 
	 <%-- <c:forEach var="writeList" items="${writeList}">
	
		<div class = "col-md-4" id = "${writeList.rowId}">
			<div class = "panel panel-color panel-red">
				<div class = "panel-heading">
					<h3 class = "panel-title">${writeList.title}</h3>
					<div class = "panel-options">
						<a href="javascript:CanDel(${writeList.rowId})" data-toggle="remove">x</a>
					</div>
				</div>
				<div class = "panel-body" onclick="lookDiary(${writeList.rowId})">
					<p>
						${writeList.content}
					</p>
				</div>
			</div>
	</div>
	</c:forEach>  --%>
	
	</div>
	<div class="pull-left">
    	<div >
    		 <span style="color:#EE82EE;">${currentPage}/${totalPage }页
		     <c:if test="${currentPage!=1}">
		     <a style="color:#EE82EE;" href="javascript:searchByPage(1)">首页</a>
		     </c:if>
		      <c:if test="${currentPage-1>0}">
		      	<a style="color:#EE82EE;" href="javascript:searchByPage(${currentPage-1})">上一页</a>
		      </c:if>
		      <c:if test="${currentPage+1<=totalPage}">
		     	 <a style="color:#EE82EE;" href="javascript:searchByPage(${currentPage+1})">下一页</a>
		      </c:if>
		      <c:if test="${currentPage!=totalPage}">
		      <a style="color:#EE82EE;" href="javascript:searchByPage(${totalPage})">末页</a>
		      </c:if>
		      </span>
		</div>
		<br>
    </div> 
    <div class="pull-right">
			<span style="color:#EE82EE;">${username.lastLoginTime}</span>
	</div>
</div>

<!--mp3 Modal -->
<div class="modal fade" id="myMusicModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="background-image : url(<%=resource %>/images/mainImages/${bgs.addBg});background-size:100%; ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">歌单</h4>
      </div>
      <div class="modal-body">
	      <ul class="list-unstyled">
	      	<li><a href="javascript:nextSong('Uptown Funk.mp3')">Uptown Funk</a></li>
	      	<li><a href="javascript:nextSong('Everybody.mp3')">everyBody</a></li>
	      	
	      	<li><a href="javascript:nextSong('bugai.mp3')">不该</a></li>
	      	<li><a href="javascript:nextSong('yintiankuaile.mp3')">阴天快乐</a></li>
	      	
	      	<li><a href="javascript:nextSong('loveyouagain.mp3')">再次爱上你</a></li>
	      	<li><a href="javascript:nextSong('CreepinUpOnYou.mp3')">Creepin Up On You</a></li>
	      	
	      	<li><a href="javascript:nextSong('tonghuazhen.mp3')">童话镇</a></li>
	      	<li><a href="javascript:nextSong('WhatAreWords.mp3')">What Are Words</a></li>
	      	<li><a href="javascript:nextSong('qimiao.mp3')">奇妙能力歌</a></li>
	      	<li><a href="javascript:nextSong('whylie.mp3')">你为什么说谎</a>
	      </ul>
      </div>
    </div>
  </div>
</div>

<!--新增 Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="background-image : url(<%=resource %>/images/mainImages/${bgs.addBg});background-size:100%; ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">新增</h4>
      </div>
      <form action="addDiary" method="post" id="adddiary">
      <div class="modal-body">
      		
        <div class="row">
        
        	<label class="col-sm-2 control-label" for="">标题：</label>
        	<div class="col-md-5">
        		<input class="form-control input-sm" id="tilte" name="title" placeholder="标题"/>
        		<br/>
        	</div>
        </div>
        	<div class="form-group">
			<label for="name">内容：</label>
				<textarea class="form-control"  rows="8" id="context" name="content"></textarea>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-red" data-dismiss="modal">关闭</button>
        <button type="button" onclick="checkAdd()" class="btn btn-red">保存</button>
        <button type="button" onclick="tempAdd()" class="btn btn-red">保存至草稿箱</button>
      </div>
      </form>
    </div>
  </div>
</div>

<!-- 修改Modal -->
<!-- <div style="display: none"> 
	<button type="button" id="editButton" class="btn btn-info" data-toggle="modal" data-target="#myModaledit">修改</button>
 </div> 
<div class="modal fade" id="myModaledit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">修改</h4>
      </div>
      <form action="editDiarys" method="post" id="editdiarys">
      <div class="modal-body">
      		<input type="hidden" name="rowId" id="rowidedit"/>
      		<input type="hidden" name="creatDate" id="creatDateedit" />
        <div class="row">
        
        	<lable class="col-sm-2 control-label" for="">标题：</lable>
        	<div class="col-md-5">
        		<input class="form-control input-sm" id="tilteedit" name="title" placeholder="标题"/>
        		<br/>
        	</div>
        </div>
        	<div class="form-group">
			<label for="name">内容：</label>
				<textarea class="form-control" rows="10" id="contextedit" name="content"></textarea>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" onclick="editsave()" class="btn btn-primary">保存</button>
      </div>
      </form>
    </div>
  </div>
</div> -->

<!-- 修改密码Modal -->
<div style="display: none"> 
	<button type="button" id="editUserButton" class="btn btn-info" data-toggle="modal" data-target="#myModaleditUser">修改密码</button>
 </div> 
<div class="modal fade" id="myModaleditUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">修改</h4>
      </div>
      <form action="editUser" method="post" id="editUser">
      <div class="modal-body">

        <div class="row">
        	<!-- <label class="col-sm-2 control-label" for="">新密码：</label> -->
        	<div class="col-md-5">
        		<input class="form-control input-sm" id="passwordEdit" name="password" placeholder="新密码"/>
        		<br/>
        	</div>
        </div>
        <div class="row">
        	<!-- <label class="col-sm-2 control-label" for="">新昵称：</label> -->
        	<div class="col-md-5">
        		<input class="form-control input-sm" id="niceNameEdit" name="niceName" placeholder="新昵称"/>
        		<br/>
        	</div>
        </div>
        	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" onclick="editUserSave()" class="btn btn-primary">保存</button>
      </div>
      </form>
    </div>
  </div>
</div> 

<!-- 查看Modal -->
<div style="display: none"> 
	<button type="button" id="lookButton" class="btn btn-info" data-toggle="modal" data-target="#myModallook">查看</button>
 </div> 
<div class="modal fade" id="myModallook" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="background-image : url(<%=resource %>/images/mainImages/${bgs.viewBg});background-size:100%; ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <label style="color:#d5080f;" id="createDatee"></label>
        
      </div>
      <form action="editDiarys" method="post" id="editdiarys">
      <div class="modal-body">
        <div class="row">
        
        	<label class="col-sm-2 control-label" for="">标题：</label>
        	<div class="col-md-5">
        		<input class="form-control input-sm" id="tiltelook" name="title" readonly="readonly" placeholder="标题"/>
        		<br/>
        	</div>
        </div>
        	<div class="form-group">
			<label for="name">内容：</label>
				<textarea class="form-control" rows="12" id="contextlook" name="content" readonly="readonly"></textarea>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-red" data-dismiss="modal">关闭</button>
      </div>
      </form>
    </div>
  </div>
</div>

<!-- 草稿箱Modal -->
<div style="display: none"> 
	<button type="button" id="editButton" class="btn btn-info" data-toggle="modal" data-target="#myModaledit">修改</button>
 </div> 
<div class="modal fade" id="myModaledit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="background-image : url(<%=resource %>/images/mainImages/${bgs.addBg});background-size:100%; ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">草稿箱</h4>
      </div>
      <form action="editDiarys" method="post" id="editdiarys">
      <div class="modal-body">
        <div class="row">
        	<label class="col-sm-2 control-label" for="">标题：</label>
        	<div class="col-md-5">
        		<input class="form-control input-sm" id="tilteedit" name="title" placeholder="标题"/>
        		<br/>
        	</div>
        </div>
        	<div class="form-group">
			<label for="name">内容：</label>
				<textarea class="form-control" rows="5" id="contextedit" name="content"></textarea>
			</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-red" data-dismiss="modal">关闭</button>
        <button type="button" onclick="clearTemp()" class="btn btn-red">清空</button>
        <button type="button" onclick="addTemp()" class="btn btn-red">保存</button>
      </div>
      </form>
    </div>
  </div>
</div>


<script type="text/javascript">



/* $("#table").bootstrapTable({
	  method: 'get',
  	url: "<c:url value='diarySearch'/>",
	cache: false,
	
	striped: false,
	pagination: true,
	sidePagination: 'server',
	pageSize: 7,
	pageList: [7,10, 20,],
	search: false,
	showColumns: false,
	showRefresh: false,
	minimumCountColumns: 2,
	clickToSelect: true,
	cardView:true,
	showToggle:true, 
  columns: [ {
    field: 'rowId1',
    radio: true,
  }, 
  {
	 field: 'rowId',
	 title: '主键',
	 align: 'center',
	 valign: 'middle',
	 visible: false
	}
  , {
    field: 'title',
    title: '标题',
    align: 'center',
    valign: 'middle',
    sortable: false
  }, {
    field: 'content',
    title: '内容',
    align: 'center',
    valign: 'middle',
    sortable: false
  }, {
	field: 'creatDateS',
	title: '创建时间',
	align: 'center',
	valign: 'middle',
	sortable: false
	}]
  }).on("click-row.bs.table",function(e,row, $element){
	  var rowId = row.rowId;
	  $.ajax({
			type:"POST",
			url:"<c:url value='editDiary'/>" +"?rowId=" + rowId,
			success: function (data, status) {
				var datas = JSON.parse(data);
				console.log(datas);	
				console.log(datas.rowId);
					$("#tiltelook").val(datas.title);
					$("#contextlook").val(datas.content);
					$("#lookButton").click();
			      }
		});
	  
  }); */
/* 	var bg1 = ${bgs.bg1};
  var bg2 = ${bgs.bg2};
  var bg3 = ${bgs.bg3}; */
  
  /* $('#weather').leoweather({format:'<font color="#bbb">{时段}好~{城市}  {天气} <B>{夜间气温}℃</B> ~ {白天气温}℃  </font>'}); */
  var curr =  ${currentPage};
  var lastPage = ${totalPage};
  function searchByPage(currentPage) {
  	var pageIndex = document.getElementById("pageIndex");
  	pageIndex.value = currentPage;
  	document.getElementById("form").submit();
  }
  //跳转到指定页码
  function searchByPage2() {
  	var skipgo = document.getElementById("skip").value;
  	document.getElementById("pageIndex").value = skipgo;
  	document.getElementById("form").submit();
  }
  
  
 /*  $("#Search").click(function (){
	  var title = $("#searchTitle").val();
	  var createDate1 = $("#createDate1").val();
	  var createDate2 = $("#createDate2").val();
	  var url="<c:url value='diarySearch'/>"+"?tilte="+title+"&createDate1="+createDate1+"&createDate2="+createDate2;
	  $('#table').bootstrapTable('refresh', {url :url});
  }); */
  $("#Search").click(function (){
	  $("#pageIndex").val("1");
	  $("#form").submit();
  });
	
  $("#Export").click(function(){
	  window.location.href="<c:url value='ExportText'/>";
  });
	function checkAdd(){
		
		var context = $("#context").val();
		if(context ==''){
			alert("输入内容后提交。");
		}else{
			var title = $("#tilte").val();
			var context = $("#context").val();
			$.ajax({
				type:"POST",
				url:"<c:url value='addDiary'/>",
				data:{
					title:title,
					context:context,
				},
				success: function (data, status) {
					if(data = "true"){
						$("#myModal").modal('hide');
						alertModal("添加成功","提示");
						$("#tilte").val("");
						$("#context").val("");
						$("#pageIndex").val("1");
        				$("#form").submit();
					};
				}
			});
		}
		
	}
	function editDiary(rowId){
		$.ajax({
			type:"POST",
			url:"<c:url value='editDiary'/>" +"?rowId=" + rowId,
			success: function (data, status) {
				var datas = JSON.parse(data);
					$("#rowidedit").val(datas.rowId);
					$("#creatDateedit").val(datas.creatDate);
					$("#tilteedit").val(datas.title);
					$("#contextedit").val(datas.content);
					$("#editButton").click();
			      }
		});
	};
	function lookDiary(rowId){
		$.ajax({
			type:"POST",
			url:"<c:url value='editDiary'/>" +"?rowId=" + rowId,
			success: function (data, status) {
				var datas = JSON.parse(data);
					$("#tiltelook").val(datas.title);
					$("#contextlook").val(datas.content);
					$("#createDatee").html(datas.creatDateS);
					$("#lookButton").click();
			      }
		});
	}
	function editsave(){
		$("#editdiarys").submit();
	}
	
	function CanDel(rowId){
			BootstrapDialog.show({ title : '提醒', message : "确认删除？", 
	            buttons : [ { label : '确定', action : function(dialog) {
	 					$.ajax({
	 						type:"POST",
	 						url:"<c:url value='deldiary'/>" +"?rowId="+rowId,
	 						success:function(data,status){
	 							$("#"+rowId).hide();
	 							$("#form").submit();
	 						}
	 					});
	              dialog.close();
	            } }, { label : '取消', action : function(dialog) {
	             		
	              dialog.close();
	            } } ] });
		
		
	}
	function eidtModal(){
		$("#editUserButton").click();
	}
	function editUserSave(){
		var pa = $("#passwordEdit").val();
		var us = $("#niceNameEdit").val();
		if(pa == ''){
			alertModal("请输入新密码！","提示");
		}else if(us == ''){
			alertModal("请输入昵称！","提示");
		}else{
			$("#editUser").submit();
		}
		
	}
	function Refresh(){
		$("#Search").click();
	}
	function tempAdd(){
		var title = $("#tilte").val();
		var content = $("#context").val();
		if(content != ''){
		$.ajax({
			type:"post",
			url:"<c:url value='tempAdd'/>",
			data:{title:title,
				content:content},
			success:function(data,status){
				if(data == 1){
					alertModal("已添加至草稿箱。","提示");
					$("#myModal").modal('hide');
					$("#tilte").val("");
					$("#context").val("");
				}else if(data == 2){
					alert("草稿箱有数据啦，先处理那个。");
				};
			}
		});
		}else{
			alert("输入内容后提交。");
		}
	}
	function checkTempDiay(){
		$.ajax({
			type:"post",
			url:"<c:url value='checkTempDiay'/>",
			data:{},
			success:function(data,status){
				if(data == 1){
					alertModal("草稿箱是空嘞。","提示");
				}else{
					var datas = JSON.parse(data);
						$("#tilteedit").val(datas.title);
						$("#contextedit").val(datas.content);
						$("#editButton").click();
				}
			}
		});
	}
	
	function Analysis(){
		$.ajax({
			type:"post",
			url:"<c:url value='getAllDiary'/>",
			data:{},
			success:function(data,status){
				alertModal(data,"提示");
				
			}
		});
	}
	
	function addTemp(){
		var tilteedit = $("#tilteedit").val();
		var contextedit = $("#contextedit").val();
		$.ajax({
			type:"post",
			url:"<c:url value='addTemp'/>",
			data:{title:tilteedit,
				content:contextedit},
			success:function(data,status){
				if(data == 1){
					alertModal("操作成功。","提示");
					$("#myModaledit").modal('hide');
					$("#tilteedit").val("");
					$("#contextedit").val("");
					$("#pageIndex").val("1");
    				$("#form").submit();
				}else{
					alertModal("操作失败。","提示");
				}
			}
		});
	}
	function alertMsg(msg){
		$("#almsg").html(msg);
		$("#alertMsg").attr("hidden",false);
	}
	function clearTemp(){
		$.ajax({
			type:"post",
			url:"<c:url value='clearTemp'/>",
			data:{},
			success:function(data,status){
				alertModal("操作成功。","提示");
				$("#myModaledit").modal('hide');
				$("#tilteedit").val("");
				$("#contextedit").val("");
			}
		});
	}
		
	$("#date1").datetimepicker({
        language : 'zh-CN',
		format : 'yyyy-mm-dd',
		minView : "month",
		autoclose : true,
	    pickerPosition: "bottom-left"
    });
   $("#date2").datetimepicker({
	      language : 'zh-CN',
	      format : 'yyyy-mm-dd',
	      minView : "month",
	      autoclose : true,
	      pickerPosition: "bottom-left"
	    });
	
	 jQuery(function($){

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
	                                 /* {image : "<c:url value='/resources/images/mainImages/bg3.jpg'/>"},  */  
	                                 {image : "<c:url value='/resources/images/mainImages/${bgs.bg1}'/>"}, 
	                                 {image : "<c:url value='/resources/images/mainImages/${bgs.bg2}'/>"}, 
	                                 {image : "<c:url value='/resources/images/mainImages/${bgs.bg3}'/>"}, 
	                       ]

	    });

	}); 
	
	$(function(){
		var myDate = new Date();
		var year = myDate.getFullYear();
		var month = myDate.getMonth()+1;
		var date = myDate.getDate();
		var hours = myDate.getHours();
		if(hours >= 23 || hours <=2){
			alertMsg("半夜啦，注意休息！");
		};
		var now = year+"/"+month+"/"+date;
		$("#tilte").val(now);
		
		console.log("立冬了气温渐冷，注意保暖。");
		console.log("");
		 /* if(month==11 && date == 7){
			console.log(date);
			$("#dayTip").attr("hidden",false);
		} */
	});
	function jump(){
		window.location.href="<c:url value='lxj'/>";
	}
	function nextSong(songName){
		//方式1
		var audio = document.getElementById("nicemusic");
		audio.src = "<c:url value='/music/'/>" + songName; 
		audio.play();
	};
	
</script>
  </body>
</html>
