<%-- 
    Document   : Insert
    Created on : Apr 17, 2018, 2:37:13 AM
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
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $('document').ready(function(){
                $('#sentdate').datepicker();
            });
        </script>
    </head>
    <body style="margin-left: 20px;padding-left: 30px">
        <div style="margin-left: 20px">
            <br/><Br/>
            <form action="gettest.htm" method="get">
                <table style="padding-left: 20px">
                    <tr>
                        <td><span>Product: </span></td>
                        <td>
                            <select>
                                <c:forEach items="${product_name}" var="x">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Sub-product: </span></td>
                        <td>
                            <select>
                                <c:forEach items="${subproduct_name}" var="x">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Issue: </span></td>
                        <td>
                            <select>
                                <c:forEach items="${issue_name}" var="x">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Subissue: </span></td>
                        <td>
                            <select>
                                <c:forEach items="${subissue_name}" var="x">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Company </span></td>
                        <td><input type="text" name="cname"/></td>
                    </tr>
                    <tr>
                        <td><span>Customer Name: </span></td>
                        <td><input type="text" name="customer"/></td>
                    </tr>
                    <tr>
                        <td><span>Company Response: </span></td>
                        <td>
                            <select>
                                <c:forEach items="${company_response}" var="x">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Response Status: </span></td>
                        <td>
                            <select>
                                <c:forEach items="${response_status}" var="x">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Consumer Disputed: </span></td>
                        <td>
                            <Select>
                                <option value="Yes">Yes</option>
                                <option value="No">No</option>
                            </Select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Timely Response: </span></td>
                        <td>
                            <Select>
                                <option value="Yes">Yes</option>
                                <option value="No">No</option>
                            </Select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Date Received: </span></td>
                        <td><input type="date" name="date_received"/></td>
                    </tr>
                    <tr>
                        <td><span>Date Sent to Company: </span></td>
                        <td><input type="date"  name="date_sent_to_company"/></td>
                    </tr>
                    <tr>
                        <td><span>Complaint Narratives: </span></td>
                        <td><input type="text" name="complaint_narratives"/></td>
                    </tr>
                    <tr>
                        <td><span>Tags: </span></td>
                        <td>
                            <select>
                                <c:forEach items="${tags}" var="x">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Consent Provided: </span></td>
                        <td>
                            <select>
                                <option value="Consent provided">Consent provided</option>
                                <option value="Consent not provided">Consent not provided</option>
                                <option value="Other">Other</option>
                                <option value="Consent Withdrawn">Consent Withdrawn</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Submitted Via: </span></td>
                        <td>
                            <select>
                                <c:forEach items="${submitted_via}" var="x">
                                    <option value="${x}">${x}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><span>Customer Age: </span></td>
                        <td><input type="text" name="age"/></td>
                    </tr>
                    <tr>
                        <td><span>Customer Income: </span></td>
                        <td><input type="text" name="income"/></td>
                    </tr>
                    <tr>
                        <td><span>Customer Zip: </span></td>
                        <td><input type="text" name="zip"/></td>
                    </tr>
                    <tr  style="color:red" >
                        <td colspan="2" style="text-align: center" >
                            <br/>
                            <input type="submit" value="Submit" />
                        </td>
                    </tr>
                </table>
                
            </form>
        </div>
    </body>
</html>
