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
</head>
<body>
	<h1>欢迎来到列表页面</h1>
	<hr>
	<table>
		<tr>
			<td>截取的分数</td>
			<td>截取的时间</td>
		</tr>
		<c:forEach items="${news }" var="n">
			<tr>
				<td>${n.score }</td>
				<td>${n.created }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>