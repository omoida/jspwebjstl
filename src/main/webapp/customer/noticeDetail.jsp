<%@page import="notice.dao.NoticeDao"%>
<%@page import="notice.vo.Notice"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetail.jsp</title>
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
<h3>noticeDetail.jsp</h3>

<table class="twidth">
	<colgroup>
		<col width=15% />
		<col width=35% />
		<col width=15% />
		<col width=35% />
	</colgroup>
	<caption>Detail</caption>
	<tbody>
		<tr>
			<th class="left">글번호</th>
			<td>${n.seq }</td>
			<th class="left">조회수</th>
			<td>${n.hit } %></td>
		</tr>
		
		<tr>
			<th class="left">작성자</th>
			<td>${n.writer }</td>
			<th class="left">작성시간</th>
			<td>${n.regdate }</td>
		</tr>
		
		<tr>
			<th class="left">제목</th>
			<td colspan="3" id="title">
			${n.title }
			</td>		
		</tr>
		
		<tr>
			<th class="left">내용</th>
			<td colspan="3" id="content">
			${n.content }
			</td>		
		</tr>
		
		<tr>
			<th class="left">첨부</th>
			<td colspan="3" id="addfile">
				첨부
			</td>		
		</tr>
		
	</tbody>

</table>
<div>
	<a href="noticeEdit.do?c=${n.seq }">수정</a>
	<a href="noticeDelProc.do?c=${n.seq }">삭제</a>
	<a href="notice.jsp">목록</a>
</div>

</body>
</html>