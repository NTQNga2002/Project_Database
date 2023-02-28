<%-- 
    Document   : welcomeShop
    Created on : 18 thg 7, 2022, 16:50:18
    Author     : admin
--%>

<%@page contentType="text/html"%>
    
<!--

    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

-->
    
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <link rel="stylesheet" type="text/css" href="shopping.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Welcome to my shop!</title>
    </head>
    <body>
        <div class="container">
            <header>
                <img class="header_img" src="image/icon.png" alt="">
                <div class="header_name">
                    
                </div>
            </header>
            <article>
                
                <h1>CHOOSE YOUR POSITION</h1>
                <div class='chooses'>
                    <div class='choose_button'>
                        <div class="choose_text">
                            <a href="LoginManager.jsp" style=" text-decoration: none; color: #ff0000;">Manager</a>
                        </div>
                    </div>
                    <div class='choose_button'>
                        <div class="choose_text">
                            <a href="LoginSale.jsp" style=" text-decoration: none; color: #ff0000;">Sale</a>
                        </div>
                    </div>
                </div>
            </article>
        </div>
    </body>
</html:html>
