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
    <link rel="stylesheet" href="<%=resource %>css/bootstrap.css">
	<link rel="stylesheet" href="<%=resource %>tool/bootStrapDate/css/bootstrap-datetimepicker.min.css">
	 <link rel="stylesheet" href="<%=resource %>loginstyle/css/style2.css"> 
	<link rel="stylesheet" href="<%=resource %>alertModel/bootstrap-dialog.min.css">
	
	<%-- <link rel="stylesheet" href="<%=resource %>tool/table/bootstrap-table.css"> --%>
	
	 <link rel="stylesheet" href="<%=resource %>css/viewdiv.css"> 
    
    <script src="<%=resource %>js/jquery.min.js"></script>
    <script src="<%=resource %>js/bootstrap.js"></script>
    <script src="<%=resource %>alertModel/bootstrap-dialog.min.js"></script>
    <script src="<%=resource %>tool/bootStrapDate/js/bootstrap-datetimepicker.js"></script>
    <script src="<%=resource %>tool/bootStrapDate/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="<%=resource %>loginstyle/js/supersized.3.2.7.min.js"></script> 
  
    <%-- <script src="<%=resource %>tool/table/locale/bootstrap-table-zh-CN.js"></script>
    <script src="<%=resource %>tool/table/bootstrap-table.js"></script> --%>
  
</head>
  
  <body>
    <!-- MODAL 开始 -->

<div class="modal fade"  tabindex="-1" role="dialog" id="alertModal" aria-labelledby="myModalLabel" data-backdrop="static" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               提醒
            </h4>
         </div>
         <div class="modal-body">
            <label id="spand"></label>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-red" data-dismiss="modal">
               确定
            </button>
            <!-- <button type="button" class="btn btn-red"  data-dismiss="modal">
               取消
            </button> -->
         </div>
    </div>
  </div>
</div>


<script type="text/javascript">

// msg 要提示的信息
function alertModal(msg, level) {
	var s = level + ":" + msg;
	
	$("#spand").html(s);
	//弹出层
	$("#alertModal").modal('toggle');

}
</script>
  </body>
</html>
