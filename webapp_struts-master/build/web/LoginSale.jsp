<%-- 
    Document   : LoginSale
    Created on : Jul 18, 2022, 1:44:28 PM
    Author     : cntt_namng
--%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html:form action = "/loginsale">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
        <link rel="stylesheet" type="text/css" href="shopping.css"/>
    </head>
    <body>
        <div class="container">
            <header>
                <img class="header_img" src="image/icon.png" alt="">
                <div class="header_name">

                </div>
            </header>
            <article>
                <div class="login_block">
                    <div class="login_block_text">
                        <h2>Welcome to,</h2>
                        <h3>3N Supermarket</h3>
                    </div>
                </div>
                <div class="login">
                    <h4>login</h4>
                    <div class="User_pass">
                        <table>
                            <tr>
                                <td colspan="2">
                                    <bean:write name="LoginSaleForm" property="error" filter="false"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <html:text property="user" style="width=250px"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <html:password property="pass"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <html:submit value="Login"/>
                                </td>
                                <td>
                                    <a href="welcomeStruts.jsp" style=" text-decoration: none; ">Return MainPage</a>
                                </td>
                            </tr>
                        </table>
                        
                    </div>
                </div>
                
            </article>
        </div>
    </body>
</html>
</html:form>