<!DOCTYPE html PUBLIC "-//W4C//DTD HTML 4.01 Transitional//EN" "http://www.w4.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String resource = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"resources"+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>photo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=resource %>css/bootstrap.css">
	<link rel="stylesheet" href="<%=resource %>alertModel/bootstrap-dialog.min.css">
    
    <script src="<%=resource %>js/jquery.min.js"></script>
    <script src="<%=resource %>js/bootstrap.js"></script>
    <script src="<%=resource %>tool/ajaxfileupload.js"></script>
    <script src="<%=resource %>alertModel/bootstrap-dialog.min.js"></script>
	<style>
	/* 	img{width:100px ; height:100px;} */
	</style> 
  </head>
  
  <body>
    <div class="container" >
    <br/>
    	<div class="row">
    		
    		<div class="pull-right">
    			<a href="toDiaryPage" class="btn btn-info">返回</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<button id="ADJUST_IMP" type="button" class="btn btn-success">上传</button>
    		</div>
    	</div>
    		<div style=" display:none">
	   	  		<input type="file"  accept="image/*"  id="file" name="file" onchange="handlFiles(this.value, ['.jpg'])">
	   	  	</div>
         <br/>
         <form action="photo" method="get" id = "form">
          	<input type="hidden" name="offset" id="pageIndex" value="1" />
         </form>
    	<div class="row">
    	<c:forEach var="photoList" items="${photoList}">
    		<div class="col-xs-3 thumbnail" >
    			<div style="width:150px ; height:150px;">
    			<a href="javascript:getBigPhoto('${photoList.url}')">
    				<img alt="" class="img-responsive center-block img-rounded" style="width:150px ; height:120px;"  src="${photoList.url}">
    			</a>
    			<br>
    			<a href="javascript:getphotoInfo(${photoList.id})">
    				<label>${photoList.photoTitle}</label>
    			</a>
    			</div>
    		</div>
    	</c:forEach>
    	</div>  
    	<div class="row">
    		<div >共${totals}张    每页${pageSize}张     ${currentPage}/${totalPage }页
				     <c:if test="${currentPage!=1}">
				     <a href="javascript:searchByPage(1)">首页</a>
				     </c:if>
				      <c:if test="${currentPage-1>0}">
				      	<a href="javascript:searchByPage(${currentPage-1})">上一页</a>
				      </c:if>
				      <c:if test="${currentPage+1<=totalPage}">
				     	 <a href="javascript:searchByPage(${currentPage+1})">下一页</a>
				      </c:if>
				      <c:if test="${currentPage!=totalPage}">
				      <a href="javascript:searchByPage(${totalPage})">末页</a>
				      </c:if>
				     <a href="javascript:searchByPage2()">跳转到</a>
				     <input name="skip" id="skip" type="text"  style="width:24px; height:20px; line-height:20px; margin-left:8px;"/>
		       </div>
    	</div>  
    </div>
    
    <!-- 查看Modal -->
<div style="display: none"> 
	<button type="button" id="lookPhoto" class="btn btn-info" data-toggle="modal" data-target="#myModallook">查看</button>
 </div> 
<div class="modal fade" id="myModallook" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">查看</h4>
      </div>
      <form action="editDiarys" method="post" id="editdiarys">
      <div class="modal-body">
        <div class="row">
        <div class="thumbnail">
        	<img id="BigPhoto" alt="" class="img-rounded" src="">
        </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
      </form>
    </div>
  </div>
</div>
    <!-- 修改Modal -->
 <div style="display: none"> 
	<button type="button" id="editButton" class="btn btn-info" data-toggle="modal" data-target="#myModaledit">修改</button>
 </div> 
<div class="modal fade" id="myModaledit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">view</h4>
      </div>
      <div class="modal-body">
      		<input type="hidden" name="rowId" id="rowidedit"/>
        <div class="row">
        	<label class="col-sm-2 control-label" for="">标题：</label>
        	<div class="col-md-5">
        		<input class="form-control input-sm" id="tilteedit" name="title" placeholder="标题"/>
        	</div>
        </div>
        	<div class="form-group">
			<label for="name">描述：</label>
				<textarea class="form-control" rows="5" id="contextedit" name="content"></textarea>
			</div>
      </div>
      <div class="modal-footer">
      	<div class="pull-left" id="createDatee">
      		
      	</div>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" onclick="editsave()" class="btn btn-primary">保存</button>
      </div>
    </div>
  </div>
</div>
    <script type="text/javascript">
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
    	function getBigPhoto(url){
    		console.log(url);
    		$("#BigPhoto").attr("src",url);
    		$("#lookPhoto").click();
    	}
    	function getphotoInfo(id){
    		$.ajax({
    			type:"POST",
    			url:"<c:url value='getPhotoInfo'/>" +"?id="+id,
    			success:function(data,status){
    				var datas = JSON.parse(data);
    				$("#rowidedit").val(datas.id);
					$("#tilteedit").val(datas.photoTitle);
					$("#contextedit").val(datas.photoInfo);
					$("#createDatee").html(datas.creatDate);
					$("#editButton").click();
    			}
    		});
    	};
    	
    	function editsave(){
    		var id = $("#rowidedit").val();
    		var photoTitle = $("#tilteedit").val();
    		var photoInfo = $("#contextedit").val();
    		if(photoTitle == null || photoTitle == '' || photoInfo == null || photoInfo == ''){
    			alert("不能有空的。");
    		}else{
    			$.ajax({
        			type:"POST",
        			url:"<c:url value='updatePhotoInfo'/>",
        			data:{id:id,
        				photoTitle:photoTitle,
        				photoInfo:photoInfo,
        				},
        			success:function(data,status){
        				$("#myModaledit").modal('hide');
        				$("#pageIndex").val(curr);
        				$("#form").submit();
        				
        			}
        		});
    		}
    	}
    	
    	$("#ADJUST_IMP").click(function(){
    		$("#file").click();
    	});
    	function refesh(){
    		
    	}
    	//上传文件
    	function handlFiles(filePath, lastSuffix) {
    		// 上传文件判断 只接受 .xls 
    		var filePath = $("#file").val();
    		if (filePath == "") {
    			alert("请选择上传文件");
    			return false;
    		}
    		
    	   /*  var suffix = filePath.substring(filePath.lastIndexOf("."),filePath.length);  //此处文件后缀名也可用数组方式获得str.split(".")
    	    
    	    if (suffix == "" || suffix != ".xls") {
    	    	window.parent._closeModalManager();
    		  	window.parent.alertModal("请选择正确的文件格式","提示");
    			return false;
    	    } */
    	    console.log(filePath);
    	    console.log(lastSuffix);
    	    $.ajaxFileUpload({
    	    	type: "POST",
    	        url: "<c:url value='ImportImg'/>",
    	        secureuri:false,
    	        fileElementId:'file',
    	        dataType: 'json',
    	        success: function (data, status) {
    	        	$("#pageIndex").val(lastPage);
    				$("#form").submit();
    	        }
    	      });
    	}
    </script>
    
  </body>
</html>
