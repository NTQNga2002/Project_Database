<%-- 
    Document   : Sale
    Created on : Jul 18, 2022, 1:44:28 PM
    Author     : cntt_namng
--%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
        <link rel="stylesheet" type="text/css" href="shopping.css"/>
    </head>
    <body>
        <div class="container">
            <header>
                <img class="header_img" src="image/icon.png" alt="">
                
                <div class="header_name">
                    <!-- comment <button style="border-radius: 4px; width:200px;text-align: center; text-decoration: none;"> .
                    </button>-->
                </div>
                        
            </header>
            <article>
                <div class="choose_sql_tool">
                    <ul>
                        <li><a href="welcomeStruts.jsp" >Home Page</a></li>
                        <li><a href="ManagerProduct.jsp"  >Product</a></li>
                        <li><a href="ManagerEmployee.jsp" >Employee</a></li>
                        <li><a href="ManagerCustomer.jsp" >Customer</a></li>
                        <li><a href="ManagerTool.jsp" >PSQL Tool</a></li>
                    </ul>
                </div>
                <div class="search">
                    <div class="search_box">
                         
                            <table style="font-size: 15px;">
                                <html:form action="/searchcustomer">
                                <tr>
                                    <td colspan="3" style="font-size: 25px;"><bean:write name="SearchCustomerForm" property="error" filter="false"/></td>
                                </tr>
                                <tr>
                                    <td>Customer ID:</td>
                                    <td><html:text property="id"/></td>
                                    <td><html:submit value="Search"/></td>
                                </tr>
                                </html:form> 
                                
                            </table>
                            <logic:notEmpty name="SearchCustomerForm" property="name" >
                                <bean:write name="SearchCustomerForm" property="id"/> : <bean:write name="SearchCustomerForm" property="name"/> !
                            </logic:notEmpty>
                    </div>
                    <logic:notEmpty name="SearchCustomerForm" property="customers" >
                        <logic:iterate id="customer" name="SearchCustomerForm" property="customers">
                            <table style="width: 600px; height:200px;margin-left: 100px; ">
                                <tr >
                                    <td>employee id:</td>
                                    <td><bean:write name="customer" property="id"/> </td>
                                    
                                </tr>
                                <tr>
                                    <td>name:</td>
                                    <td><bean:write name="customer" property="name"/></td>
                                
                                </tr>
                                <tr>
                                    <td>sex:</td>
                                    <td><bean:write name="customer" property="sex"/></td>
                                
                                </tr>
                                <tr>
                                    <td>phone:</td>
                                    <td><bean:write name="customer" property="phone"/></td>
                                
                                    
                                </tr>
                                
                            </table>
                        </logic:iterate>  
               
                </logic:notEmpty>
                </div>
            </article>
        </div>
    </body>
</html>
