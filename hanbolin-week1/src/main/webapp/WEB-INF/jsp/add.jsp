<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/index_work.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(function(){
		//实现下拉框回显
		$.post("getType.do",function(arr){
			for (var i = 0; i < arr.length; i++) {
				$("select").append("<option value='"+arr[i].tid+"'>"+arr[i].tname+"</option>");
			}
		},"json")
		
		//给h1添加样式
		$("h1").css({"text-align":"center","font-size":"30px"});
	})
</script>
</head>
<body>
	<h1>欢迎来到添加页面</h1>
	<hr>
	<form method="post" action="add.do">
		植物名称：<input type="text" name="zname"><br><br>
		植物描述：<input type="text" name="introduction"><br><br>
		植物类别：<select name="type.tid">
					<option>请选择</option>
				</select><br><br>
			<input type="submit" value="添加">
	</form>
</body>
</html>