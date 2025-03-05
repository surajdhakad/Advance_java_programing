<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
String userID=request.getParameter("userId");
String userPass=request.getParameter("userPass");
String FirstName=request.getParameter("Fname");
String LastName=request.getParameter("Lname");
String City=request.getParameter("City");
String MailId=request.getParameter("MId");
Long PhnoneNo=Long.parseLong(request.getParameter("PhoneNo"));


out.println("=============User Details==========<br>");
out.println("user-ID:"+userID+"<br>");
out.println("user-Pass:"+userPass+"<br>");
out.println("FirstName:"+FirstName+"<br>");
out.println("LastName:"+LastName+"<br>");
out.println("City:"+City+"<br>");
out.println("MailId:"+MailId+"<br>");
out.println("PhnoneNo:"+PhnoneNo+"<br>");

%>

</body>
</html>