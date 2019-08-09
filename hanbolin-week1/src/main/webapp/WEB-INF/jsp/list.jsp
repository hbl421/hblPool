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
		//实现全选功能
		$("input[name='check']").click(function(){
			if($(this).is(":checked")){
				$("input[name='zid']").attr({"checked":true});
			}else{
				$("input[name='zid']").attr({"checked":false});
			}
		});
		
		//给h1添加样式
		$("h1").css({"text-align":"center","font-size":"30px"});
	})
	
	//实现添加功能
	function tj(){
		location = "getAdd.do";
	}
	
	//实现删除功能
	function sc(zid){
		var z = $("input[name='zid']:checked");
		if(confirm("确定删除嘛?")){
			$.post("dele.do",{zid:zid},function(flag){
				if(flag){					
					alert("删除成功!");
					location = "listZhi.do";
				}else{
					alert("删除失败!");
				}
			},"json");
		}
	}
	
	//实现批量删除功能
	function ps(){
		var z = $("input[name='zid']:checked");
		
		if(z.length > 0){
			if(confirm("确定删除嘛?")){
				var str = "";
				for (var i = 0; i < z.length; i++) {
					str += ","+z[i].value;
				}
				
				var zid = str.substring(1);
				$.post("dele.do",{zid:zid},function(flag){
					if(flag){
						alert("删除成功!");
						location = "listZhi.do";
					}else{
						alert("删除失败!");
					}
				},"json");
			}
		}else{
			alert("你必须选择一条数据!");	
		}
	}
	
	//实现修改功能
	function xg(zid){
		location = "getUpdate.do?zid="+zid;
	}
	
	//实现查看功能
	function chakan(zid){
		location = "chakan.do?zid="+zid;
	}
</script>
</head>
<body>
	<h1>欢迎来到列表页面</h1>
	
	<form action="queryByDname.do" method="post">
		查询内容：<input type="text" name="zname" value="${zv.zname }">
		
			<input type="submit" value="查询">
	</form>
	
	<hr>
	<table>
		<tr>
			<td>
				<input type="button" value="添加" onclick="tj()">
				<input type="checkbox" name="check">全选
			</td>
			<td>序号</td>
			<td>植物名称</td>
			<td>描述</td>
			<td>类别</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${zhiwu }" var="z">
			<tr>
				<td>
					<input type="checkbox" name="zid" value="${z.zid }">
				</td>
				<td>${z.zid }</td>
				<td>${z.zname }</td>
				<td>${z.introduction }</td>
				<td>${z.type.tname }</td>
				<td>
					<input type="button" value="查看" onclick="chakan('${z.zid}')">
					<input type="button" value="修改" onclick="xg('${z.zid}')">
					<input type="button" value="删除" onclick="sc('${z.zid}')">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<input type="button" value="批量删除" onclick="ps()">
			</td>
			<td colspan="5">
				${pinfo }
			</td>
		</tr>
	</table>
</body>
</html>