<%-- 
    Document   : queries
    Created on : Apr 19, 2018, 1:57:28 AM
    Author     : Ishaan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            $(document).ready(function(){
                $('#go1').click(function(){
                   $('#queryoutput').load('queryoutput.htm?name=query1');
                });
                $('#go2').click(function(){
                    var name = "query2,"+$('#goinp1').val();
                    $('#queryoutput').load('queryoutput.htm?name='+name);
                });
                $('#go3').click(function(){
                    var name ="query3,"+ $('#issuesel').val();
                    $('#queryoutput').load('queryoutput.htm?name='+name);
                });
                
                $('#go5').click(function(){
                    var name = "query5,"+$('#goinp5').val();
                    $('#queryoutput').load('queryoutput.htm?name='+name);
                });
                $('#go6').click(function(){
                    $('#queryoutput').load('queryoutput.htm?name=query6');
                });
                $('#go7').click(function(){
                    $('#queryoutput').load('queryoutput.htm?name=query7');
                });
                $('#go8').click(function(){
                    $('#queryoutput').load('queryoutput.htm?name=query8');
                });
            });
        </script>
        <style type="text/css">
            .btn{
                color:blue;
                text-decoration: underline;
            }
            .btn:hover{
                cursor:pointer;
               
            }
            table{
                border-spacing: 15px;
                text-align: left;
            }

        </style>
    </head>
    <body style="margin-left: 20px">
        <br/>
        <div id="querylist" style="float:left;margin-right: 30px;text-align: center">
            <h4 >Query Options</h4>
            <table>
                <tr></tr>
                <Tr>
                <span > <Td>1)</td><Td> See Number of Complaints By companies</span> </td> 
            <Td><span class="btn" id="go1">Run Query</span></td> 
</Tr><Tr>
            <Td>2)</td> <td><span>See top <input type="text" id="goinp1"  style="max-width: 20px"/> &nbsp;  companies with complaints
                </span></td>
                <Td> <span class="btn" id="go2" >Run Query</span></Td></Tr>
<tr>                <td>3)</td><Td><span> See subissue's 
                <select style="max-width: 100px" id="issuesel">
                <c:forEach items="${issue}" var = "x">
                    <option value="${x}">${x}</option>
                </c:forEach>

            </select> Issue
                    </span> </td>
                    <td><span class="btn" id="go3">Run Query</span></td></tr>
<Tr>
                    <td>4)</td><Td><span> See subproduct's 
                <select style="max-width: 100px" id="productsel">
                <c:forEach items="${product}" var = "x">
                    <option value="${x}">${x}</option>
                </c:forEach>

            </select> ; Product
            </span> </Td>
            <td><span class="btn" id="go4">Run Query</span> </td></tr>
<tr>
            <Td>5)</Td><Td><span> See total responses of &nbsp;<input type="text" id="goinp5" style="max-width: 20px;"> &nbsp;  companies 
            
            </span> </Td>
            <Td><span class="btn" id="go5">Run Query</span> </Td>
</tr>
<tr>
            <td>6)</td><Td><span> See Total Complaints per product
            
                </span> </td>
                <Td><span class="btn" id="go6">Run Query</span></Td>
</tr>
<tr>
            <td>7)</td><Td><span> See Total Complaints By issue
            
                </span> </td>
                <Td><span class="btn" id="go7">Run Query</span></Td>
</tr>
<tr>
            <td>8)</td><Td><span> See Total Complaints By Source of Submission
            
                </span> </td>
                <Td><span class="btn" id="go8">Run Query</span></Td>
</tr>
            </table>
        </div>
        <div id="queryoutput">
            
        </div>
    </body>
</html>
