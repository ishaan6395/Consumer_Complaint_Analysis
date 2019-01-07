<%-- 
    Document   : index
    Created on : Apr 8, 2018, 4:23:33 PM
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
            var width = parseInt($(document).width());
            var height = parseInt($(document).height());
            $('#left_panel').width(width/5);
            $('#left_panel').height(height*0.9); 
            $('#right_panel').height(height*0.9);
            //$('#rightbody').load('insert.htm');
            $('#entercomplaint').click(function(){
              $('#rightbody').load('insert.htm');  
            });
            $('#previewtables').click(function(){
                $('#rightbody').load('preview.htm');
            });
            $('#preview').click(function(){
                $('#rightbody').load('preview.htm');
            });
            $('#inneroptions1').hide();
            $('#inneroptions2').hide();
            $('#options1').click(function(){
                if($('#options1').attr('stat')=="show"){
                    $('#inneroptions1').slideDown(500,function(){
                    $('#options1').text("Hide Data Management Options");
                    $('#options1').attr('stat','hide');
                });
                }else{
                    $('#inneroptions1').slideUp(500,function(){
                    $('#options1').text("Show Data Management Options");
                    $('#options1').attr('stat','show');
                    });
                }
                
            });
            $('#options2').click(function(){
                if($('#options2').attr('stat')=="show"){
                    $('#inneroptions2').slideDown(500,function(){
                    $('#options2').text("Hide Data Analytics Options");
                    $('#options2').attr('stat','hide');
                });
                }else{
                    $('#inneroptions2').slideUp(500,function(){
                    $('#options2').text("Show Data Analytics Options");
                    $('#options2').attr('stat','show');
                    });
                }
                
            });
            
            $('#querytables').click(function(){
                $('#rightbody').load('queries.htm');
            });
        });
</script>
        <style type = "text/css" media = "all">
            #header{
                background-color: #282524;
                color:White;
                border:1px solid black;
                text-align: center;
                font-style:italic;
                
            }
            #options1{
                color:white;
            }
            #options1:hover{
                cursor: pointer;
            }
            #options2:hover{
                cursor: pointer;
            }
            
            #header_text{
                font-size: 25px;
                font-weight: bold
            }
            
            #left_panel{
                background-color:#3C312E;
                float:left;
                
            }
            #right_panel{
                width: 100%;
                background-color:#F9F5F3;
                
            }
            
            #options2{
                color:white;
            }
            #left_panel_header{
                margin-top:5px;
                text-align:center;
                color:white;
                font-size: 20px;
            }
            .left_panel_content{
                margin-left: 30px;
            }
            a{
                text-decoration:none;
                color:white;
            }
            a:hover{
                font-weight: bold;
            }
            
            #rightbody{
                width: 100%;
                height:300px;
            }
            .tablename:hover{
                cursor:pointer;
            }
      </style>
    </head>
    <body>
        <div id="header">
            <p id="header_text">Consumer Financial Complaints Analysis</p>
        </div>
        
        <div id="main">
            <div id="left_panel">
                <div id="left_panel_header">
                    <b><u>Your Work Space</u></b> <br/>
                </div>
                <div class="left_panel_content">
                    <h4 ><span id="options1" stat="show"> Show Data Management Options</span> </h4>
                    <div id="inneroptions1">
                        <a id="entercomplaint"  class="tablename" > Enter a Complaint </a><br/><br/>
                        <a id="querytables"  class="tablename"> Perform Quering </a><br/><br/>
                        <a id="previewtables"   class="tablename"> Preview Structures </a><br/><br/>
                    </div>
                    <br/><br/>
                </div> 
                <div class="left_panel_content" style="margin-right: 10px">
                    <h4 ><span id="options2" stat="show"> Show Data Analytics Options</span> </h4>
                    <div id="inneroptions2">
                        <a id="entercomplaint"  class="tablename" > Classification</a><br/><br/>
                        <a id="querytables"  class="tablename">Clustering</a><br/><br/>
                    </div>
                    <br/><br/>
                </div> 
            </div>
            <div id="right_panel" >
                
                <div id ="rightbody" style="margin-left: 20px;">
                    
                </div>
            </div>
        </div>
        
    </body>
</html>
