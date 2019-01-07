<%-- 
    Document   : queryoutput
    Created on : Apr 19, 2018, 2:28:49 AM
    Author     : Ishaan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            table tr:first-child{
                text-decoration: underline;
                font-weight: bold;
                
            }
            table {
               border-spacing: 15px;
            }
        </style>
    </head>
    <body>
        <div style="overflow-x: scroll;overflow-y: scroll;height:500px">
        <c:if test="${tableName == 'query1'}">
            <table>
                <tr>
                    <Td >Total Complaints</Td>
                    <Td >Company </Td>
                </tr>
                
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.complaints}</Td>
                        <Td>${x.company}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            <c:if test="${tableName == 'query2'}">
            <table>
                <tr>
                    <Td >Total Complaints</Td>
                    <Td >Company </Td>
                </tr>
                
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.complaints}</Td>
                        <Td>${x.company}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            <c:if test="${tableName == 'query3'}">
            <table>
                <tr>
                    <Td >subissue_ID</Td>   
                    <Td >issue_ID </Td>
                    <td>subissue_name</td>
                    <td>issue_name</td>
                </tr>
                
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.subissueID}</Td>
                        <Td>${x.issueID}</Td>
                        <Td>${x.subissueName}</Td>
                        <Td>${x.issueName}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            <c:if test="${tableName == 'query5'}">
            <table>
                <tr>
                    <Td >Total responses</Td>
                    <td>Company Name</td>
                </tr>
                
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.complaints}</Td>
                        <Td>${x.company}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            <c:if test="${tableName == 'query6'}">
            <table>
                <tr>
                    <Td >Total responses</Td>
                    <td>Product Name</td>
                </tr>
                
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.complaints}</Td>
                        <Td>${x.company}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            <c:if test="${tableName == 'query7'}">
            <table>
                <tr>
                    <Td >Total responses</Td>
                    <td>Issue Name</td>
                </tr>
                
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.complaints}</Td>
                        <Td>${x.company}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            <c:if test="${tableName == 'query8'}">
            <table>
                <tr>
                    <Td >Total responses</Td>
                    <td>Issue Name</td>
                </tr>
                
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.complaints}</Td>
                        <Td>${x.company}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            
            
            </div>
    </body>
</html>
