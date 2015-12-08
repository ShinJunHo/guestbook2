<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanains.guestbook.dao.GuestBookDao" %>
<%@ page import="com.hanains.guestbook.vo.GuestBookVo" %>

<%
	//object to down casting
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>

	<!-- 방명록 리스트 -->
	<%-- list에서 하나씩 빼서 테이블를 채운다--%>

	<form action="/guestbook2/gb?a=add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<%
		int countTotal=list.size();
		int i=0;
		for(GuestBookVo vo : list){
	%>
	<br>
	<table width=510 border=1>
		<tr>
			<td><%=countTotal-(i++)%></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getReg_date() %></td>
			<td><a href="/guestbook2/gb?a=deleteform&id=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getMessage().replaceAll("\n", "<br/>") %></td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>