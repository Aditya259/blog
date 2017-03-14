<%-- 
    Document   : post
    Created on : Feb 20, 2017, 4:03:32 PM
    Author     : Aditya
--%>

<%@page import="web.Post"%>
<%@page import="web.DbManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<% DbManager db = new DbManager();
    Post post;
//if (request.getParameter("id") != null) {
    int postID = Integer.parseInt(request.getParameter("id").toString());
    post = db.GetPost(postID);
    //} else {
    //  response.sendError(404, "This Article Not Found... :D");
    //  }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
         <%@ include file="nav.jsp" %>
        <div class="post">
        <div class="inerpost">
                        <h2><a href="#"><%= post.PostTitle%></a></h2>
                        <%= post.PostContent%>
                      <%=post.PostCategory%>

                        <br>
                        
                    </div>
        </div>
                      
                      
    </body>
</html>
