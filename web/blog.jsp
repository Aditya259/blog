<%-- 
    Document   : blog
    Created on : Feb 19, 2017, 6:12:09 PM
    Author     : Aditya
--%>

<%@page import="web.Post"%>
<%@page import="web.DbManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
        <link href="css/style.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </head>
    <body>
        <%@ include file="nav.jsp" %>
   
                   <% DbManager db = new DbManager();

                        List<Post> posts = db.GetAllPosts();

                    %>
                    <% for (Iterator<Post> i = posts.iterator(); i.hasNext();) {
                            Post post = i.next();
                    %>
                    <div class="post">
                    <div class="inerpost">
                        <h2><a href="#"><%= post.PostTitle%></a></h2>
                        <p><%= post.PostCategory%></p>
                        <br>
                        <a href="./post.jsp?id=<%= post.ID%>" class="btn">Read More...</a>
                    </div>
                    </div>
                    <hr />
                    <%}%>
        

          
       
    </body>
</html>
