<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page = import="User.UserDAO"%>
<%@ page = import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" calss="user.User" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
UserDAO userDAO = new UserDAO();
int result = userDAO.login(User.getUserID(), user.getUserPassword());
if (result ==1 ){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	
}
%>
</body>
</html>