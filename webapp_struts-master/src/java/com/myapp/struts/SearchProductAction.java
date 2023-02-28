/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author admin
 */
public class SearchProductAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SearchProductForm formBean = (SearchProductForm) form;
        String id = formBean.getId();
        List product = findProduct(id);
        if(product!=null){
            formBean.setProducts(product);
            formBean.setName(null);
            request.setAttribute("SearchProductForm", formBean);
            return mapping.findForward(SUCCESS);
        }
        formBean.setName(" invalid or error");
        return mapping.findForward(FAILURE);
    }
    public class product{
        public String id,name,amount,inputprice,outputprice,saleprice,startdate,enddate,cate_id,dis_id;

        public product(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
            this.id = string;
            this.name = string0;
            this.amount = string1;
            this.inputprice = string2;
            this.outputprice = string3;
            this.saleprice = string4;
            this.startdate = string5;
            this.enddate =string6;
            this.cate_id = string7;
            this.dis_id = string8;
            
        }
        
    }
    public List findProduct(String id){
        List<Product> products = new ArrayList<>();
        String host="localhost";
        String port="5432";
        String dbname="quanlibanhang_final";
        String dbuser="postgres";
        String dbpass="namhhbg0001";
        String dburl="jdbc:postgresql://"+host+":"+port+"/"+dbname+"?loggerLevel=OFF";
        Connection con = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from product");
            while (rs.next()){
                if(id.equals(rs.getString("product_id"))){
                    Product p = new Product();
                    p.setId(rs.getString(1));
                    p.setName(rs.getString(2));
                    p.setAmount(rs.getString(3));
                    p.setInputprice(rs.getString(4));
                    p.setOutputprice(rs.getString(5));
                    p.setSaleprice(rs.getString(6));
                    p.setStartdate(rs.getString(7));
                    p.setEnddate(rs.getString(8));
                    p.setCate_id(rs.getString(9));
                    p.setDis_id(rs.getString(10));
                    products.add(p);
                    //products.add(new product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
                    //System.out.print(rs.getString(2));
                return products;
                }
            }
        rs.close();
        stmt.close();
        con.close();    
        }catch(SQLException | ClassNotFoundException c){
        }
        return null;
        
    } 
    
    
}
