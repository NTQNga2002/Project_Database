/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class SearchCustomerAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SearchCustomerForm formBean = (SearchCustomerForm) form;
        String id = formBean.getId();
        List<Customer> customers = checkCustomer(id);
        if(null!=customers){
            formBean.setName(null);
            formBean.setCustomers(customers);
            return mapping.findForward(SUCCESS);
        }
        formBean.setName(": invalid or error!");
        return mapping.findForward(FAILURE);
    }
     public List checkCustomer(String id) throws ClassNotFoundException{
        List<Customer> customers = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quanlibanhang_final?loggerLevel=OFF","postgres","namhhbg0001");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from custommer");
            while (rs.next()){
                if(id.equals(rs.getString("custommer_id"))){
                    Customer customer = new Customer();
                    customer.setId(rs.getString(1));
                    customer.setName(rs.getString(2));
                    customer.setSex(rs.getString(3));
                    customer.setPhone(rs.getString(4));
                    customers.add(customer);
                }
            }
        rs.close();
        stmt.close();
        con.close();    
        }catch(SQLException e){
            
            e.printStackTrace();
        }
        return customers;
        
    } 
}
