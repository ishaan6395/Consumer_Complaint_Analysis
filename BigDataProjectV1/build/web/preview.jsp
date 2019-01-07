<%-- 
    Document   : preview
    Created on : Apr 17, 2018, 3:45:30 AM
    Author     : Ishaan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
                $('.tname').click(function(){
                    $('#previewdiv').load("tableload.htm?name="+$(this).attr('id'));
                });
            });
        </script>
        <style type = "text/css" media = "all">
            .tname:hover{
                cursor:pointer;
            }
            .tname{
                color:#666260;
            }
        </style>
    </head>
    <body >
        <br/>
        <div style="float: left;color:#666260;border-right: 1px solid lightgray">
        
        <h4 style=""><b>&nbsp;&nbsp;&nbsp;<u>Click on the table to preview the Structure</u></b></h4>
            
        <c:forEach items="${tables}" var="x">
            &nbsp;&nbsp;&nbsp;<a  id="${x}" class="tname"><c:out value=" ${x}"/></a><br/><Br/>
        </c:forEach>
           &nbsp;&nbsp;&nbsp; <a  id="prod_subprod" class="tname">Product's subproducts</a><br/><Br/>
           &nbsp;&nbsp;&nbsp; <a  id="issue_subissue" class="tname">Issue's Subissues</a><br/><Br/>
           &nbsp;&nbsp;&nbsp; <a  id="cfpb_merge" class="tname">Cfpb Merge</a>
        </div> 
        <div id="previewdiv" style="width: 100%;">
            
        </div>
    </body>
</html>
