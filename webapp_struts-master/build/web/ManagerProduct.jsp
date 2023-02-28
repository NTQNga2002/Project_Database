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
        <title>Product</title>
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
                                <html:form action="/searchproduct">  
                                <tr>
                                    <td colspan="3" style="font-size: 25px;"><bean:write name="SearchProductForm" property="error" filter="false"/></td>
                                </tr>
                                <tr>
                                    <td>Product ID:</td>
                                    <td><html:text property="id"/></td>
                                    <td><html:submit value="Search"/></td>
                                </tr>
                                </html:form> 
                                <html:form action="/deleteproduct">
                                <tr>
                                    <td colspan="3" style="font-size: 25px;"><bean:write name="DeleteProductForm" property="error" filter="false"/></td>
                                </tr>
                                <tr>
                                    <td>Product ID:</td>
                                    <td><html:text property="id"/></td>
                                    <td><html:submit value="Delete"/></td>
                                </tr>
                                </html:form>
                            </table>
                            <logic:notEmpty name="DeleteProductForm" property="name" >
                                <bean:write name="DeleteProductForm" property="name"/> has been deleted!
                            </logic:notEmpty>
                            <logic:notEmpty name="SearchProductForm" property="name" >
                                <bean:write name="SearchProductForm" property="id"/> : <bean:write name="SearchProductForm" property="name"/> !
                            </logic:notEmpty>
                    </div>
                    <logic:notEmpty name="SearchProductForm" property="products" >
                        <logic:iterate id="product" name="SearchProductForm" property="products">
                            <table style="width: 600px; height:200px;margin-left: 100px; ">
                                <tr >
                                    <td>product id:</td>
                                    <td><bean:write name="product" property="id"/> </td>
                                    <td>name:</td>
                                    <td><bean:write name="product" property="name"/></td>
                                </tr>
                                <tr>
                                    <td>amount:</td>
                                    <td><bean:write name="product" property="amount"/></td>
                                
                                    <td>input price:</td>
                                    <td><bean:write name="product" property="inputprice"/></td>
                                </tr>
                                <tr>
                                    <td>output price:</td>
                                    <td><bean:write name="product" property="outputprice"/></td>
                                
                                    <td>sale price:</td>
                                    <td><bean:write name="product" property="saleprice"/></td>
                                </tr>
                                <tr>
                                    <td>start date:</td>
                                    <td><bean:write name="product" property="startdate"/></td>
                                
                                    <td>end date:</td>
                                    <td><bean:write name="product" property="enddate"/></td>
                                </tr>
                                <tr>
                                    <td>category id:</td>
                                    <td><bean:write name="product" property="cate_id"/></td>
                                
                                    <td>distributor id:</td>
                                    <td><bean:write name="product" property="dis_id"/></td>
                                </tr>
                                
                            </table>
                        </logic:iterate>  
               
                </logic:notEmpty>
                </div>
            </article>
        </div>
    </body>
</html>
