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
        <title>Employee</title>
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
                                <html:form action="/searchemployee">  
                                <tr>
                                    <td colspan="3" style="font-size: 25px;"><bean:write name="SearchEmployeeForm" property="error" filter="false"/></td>
                                </tr>
                                <tr>
                                    <td>Employee ID:</td>
                                    <td><html:text property="id"/></td>
                                    <td><html:submit value="Search"/></td>
                                </tr>
                                </html:form> 
                                <html:form action="/deleteemployee">
                                <tr>
                                    <td colspan="3" style="font-size: 25px;"><bean:write name="DeleteEmployeeForm" property="error" filter="false"/></td>
                                </tr>
                                <tr>
                                    <td>Employee ID:</td>
                                    <td><html:text property="id"/></td>
                                    <td><html:submit value="Delete"/></td>
                                </tr>
                                </html:form>
                            </table>
                            <logic:notEmpty name="DeleteEmployeeForm" property="name" >
                                <bean:write name="DeleteEmployeeForm" property="name"/> has been deleted!
                            </logic:notEmpty>
                            <logic:notEmpty name="SearchEmployeeForm" property="name" >
                                <bean:write name="SearchEmployeeForm" property="id"/> : <bean:write name="SearchEmployeeForm" property="name"/> !
                            </logic:notEmpty>
                            
                    </div>
                    <logic:notEmpty name="SearchEmployeeForm" property="employees" >
                        <logic:iterate id="employee" name="SearchEmployeeForm" property="employees">
                            <table style="width: 600px; height:200px;margin-left: 100px; ">
                                <tr >
                                    <td>employee id:</td>
                                    <td><bean:write name="employee" property="id"/> </td>
                                    <td>name:</td>
                                    <td><bean:write name="employee" property="name"/></td>
                                </tr>
                                <tr>
                                    <td>dob:</td>
                                    <td><bean:write name="employee" property="dob"/></td>
                                
                                    <td>sex:</td>
                                    <td><bean:write name="employee" property="sex"/></td>
                                </tr>
                                <tr>
                                    <td>address:</td>
                                    <td><bean:write name="employee" property="address"/></td>
                                
                                    <td>phone:</td>
                                    <td><bean:write name="employee" property="phone"/></td>
                                </tr>
                                <tr>
                                    <td>salary:</td>
                                    <td><bean:write name="employee" property="salary"/></td>
                                
                                    
                                </tr>
                                
                            </table>
                        </logic:iterate>  
               
                </logic:notEmpty>
                </div>
            </article>
        </div>
    </body>
</html>
