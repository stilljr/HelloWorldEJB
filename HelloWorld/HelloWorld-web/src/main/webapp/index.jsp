<%@ page import="com.hello.*" language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<jsp:useBean id="HelloSessionBean" scope="session" class="com.hello.HelloSessionBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello from JSP</title>
    </head>
    <body>
     
    <% out.print("<h1>Hello EJB from JSP</h1>"); %>
    <hr> 
    Welcome to Hello World EJB Testing<br>
    Current Time is : <%=new java.util.Date()%>
    <hr>

    <%
    out.println(HelloSessionBean.helloSessionBeanMethod());
    %>
 
    </body>
</html>