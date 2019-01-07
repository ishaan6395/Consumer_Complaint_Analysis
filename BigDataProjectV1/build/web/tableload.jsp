<%-- 
    Document   : tableload
    Created on : Apr 18, 2018, 6:24:57 PM
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
               border-spacing: 20px;
            }
        </style>
    </head>
    <body>
        <div style="overflow-x: scroll;overflow-y: no-display;height: 500px">
        <c:if test="${tableName == 'cfpb_complaint'}">
            <table>
                <Tr>
                    <Td>complaint_ID</Td>
                    <Td>date_received</Td>
                    <Td>product_ID</Td>
                    <Td>subproduct_ID</Td>
                    <Td>issue_ID</Td>
                    <Td>subissue_ID</Td>
                    <Td>company_ID</Td>
                    <Td>submitted_via</Td>
                    <Td>complaint_narratives</Td>
                    <Td>tags</Td>
                    <Td>date_sent_to_company</Td>
                    <Td>consent_provided</Td>
                </Tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.complaintID}</Td>
                        <Td>${x.dateReceived}</Td>
                        <Td>${x.productID}</Td>
                        <Td>${x.subproductID}</Td>
                        <Td>${x.issueID}</Td>
                        <Td>${x.subissueID}</Td>
                        <Td>${x.companyID}</Td>
                        <Td>${x.submittedVia}</Td>
                        <Td style="max-height: 20px;overflow-y: no-display;overflow-x: no-display">${x.complaintNarratives}</Td>
                        <Td>${x.tags}</Td>
                        <Td>${x.dateSent}</Td>
                        <Td>${x.consentProvided}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
        
        <c:if test="${tableName == 'product'}">
            <table>
                <tr>
                    <Td>product_ID</Td>
                    <Td>product_Name</Td>
                </tr>
                
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.productID}</Td>
                        <Td>${x.productName}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${tableName == 'subproduct'}">
            <table style="padding: 5px">
                <tr>
                    <Td>subproduct_ID</Td>
                    <Td>product_ID</Td>
                    <Td>subproduct_name</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.subproductID}</Td>
                        <Td>${x.productID}</Td>
                        <Td>${x.subproductName}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
        
        <c:if test="${tableName == 'issue'}">
            <table style="padding: 5px">
                <tr>
                    <Td>issue_ID</Td>
                    <Td>issue_name</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.issueID}</Td>
                        <Td>${x.issueName}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
        
        <c:if test="${tableName == 'subissue'}">
            <table style="padding: 5px">
                <tr>
                    <Td>subissue_ID</Td>
                    <Td>issue_ID</Td>
                    <Td>issue_name</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.subissueID}</Td>
                        <Td>${x.issueID}</Td>
                        <Td>${x.subissueName}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
        
        <c:if test="${tableName == 'company'}">
            <table style="padding: 5px">
                <tr>
                    <Td>company_ID</Td>
                    <Td>company_name</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.companyID}</Td>
                        <Td>${x.companyName}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
        
        <c:if test="${tableName == 'customer'}">
            <table style="padding: 5px">
                <tr>
                    <Td>customer_ID</Td>
                    <Td>customer_name</Td>
                    <Td>ZIP</Td>
                    <Td>Age</Td>
                    <Td>Income</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.customerID}</Td>
                        <Td>${x.customerName}</Td>
                        <Td>${x.zip}</Td>
                        <Td>${x.ageRange}</Td>
                        <Td>${x.incomeRange}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
        
        <c:if test="${tableName == 'company_response'}">
            <table style="padding: 5px">
                <tr>
                    <Td>response_ID</Td>
                    <Td>complaint_ID</Td>
                    <Td>company_ID</Td>
                    <Td>company_response</Td>
                    <Td>response_status</Td>
                    <Td>consumer_disputed</Td>
                    <Td>timely_response</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.responseID}</Td>
                        <Td>${x.complaintID}</Td>
                        <Td>${x.companyID}</Td>
                        <Td>${x.companyResponse}</Td>
                        <Td>${x.responseStatus}</Td>
                        <Td>${x.consumerDisputed}</Td>
                        <Td>${x.timelyResponse}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            <c:if test="${tableName == 'prod_subprod'}">
            <table style="padding: 5px">
                <tr>
                    <Td>product_ID</Td>
                    <Td>product_Name</Td>
                    <Td>subproduct_ID</Td>
                    <Td>subproduct_Name</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.prodId}</Td>
                        <Td>${x.prodName}</Td>
                        <Td>${x.subProdID}</Td>
                        <Td>${x.subprodName}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            
            <c:if test="${tableName == 'issue_subissue'}">
            <table style="padding: 5px">
                <tr>
                    <Td>issue_ID</Td>
                    <Td>issue_Name</Td>
                    <Td>subissue_ID</Td>
                    <Td>subissue_Name</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.issueID}</Td>
                        <Td>${x.issueName}</Td>
                        <Td>${x.subissueID}</Td>
                        <Td>${x.subissueName}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            
            <c:if test="${tableName == 'cfpb_merged'}">
            <table style="padding: 5px">
                <tr>
                    <Td>complaint_ID</Td>
                    <Td>Date Received</Td>
                    <Td>Date Sent</Td>
                    <Td>Product Name</Td>
                    <Td>subproduct Name</Td>
                    <Td>Issue Name</Td>
                    <Td>Subissue Name</Td>
                    <Td>Company Name</Td>
                    <Td>Submitted Via</Td>
                    <Td>Complaint Narratives</Td>
                    <Td>Tags</Td>
                    <Td>Consent Provided</Td>
                </tr>
                <c:forEach items="${name}" var="x">
                    <Tr>
                        <Td>${x.complaintID}</Td>
                        <Td>${x.dateReceived}</Td>
                        <Td>${x.dateSent}</Td>
                        <Td>${x.productName}</Td>
                        <Td>${x.subproductName}</Td>
                        <Td>${x.issueName}</Td>
                        <Td>${x.subissueName}</Td>
                        <Td>${x.companyName}</Td>
                        <Td>${x.submittedVia}</Td>
                        <Td>${x.complaintNarratives}</Td>
                        <Td>${x.tags}</Td>
                        <Td>${x.consentProvided}</Td>
                    </Tr>
                </c:forEach>
            </table>
        </c:if>
            </div>
    </body>
</html>
