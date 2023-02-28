/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.sql.*;
/**
 *
 * @author admin
 */
public class DeleteEmployeeAction extends org.apache.struts.action.Action {

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
        DeleteEmployeeForm formBean =(DeleteEmployeeForm) form;
        String id = formBean.getId();
        String name = DropEmployee(id);
        if (name!=null){
            formBean.setName(name);
            return mapping.findForward(SUCCESS);
        }
        else {
            formBean.setName(null);
            return mapping.findForward(FAILURE);
        }
    }
    public String DropEmployee(String id){
        String name = null;
        String host="localhost";
        String port="5432";
        String dbname="quanlibanhang_final";
        String dbuser="postgres";
        String dbpass="namhhbg0001";
        String dburl="jdbc:postgresql://"+host+":"+port+"/"+dbname+"?loggerLevel=OFF";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from employee");
            while (rs.next())
                if(rs.getString(1).equals(id))
                {
                    name = rs.getString(2);
                    stmt.executeUpdate("delete from employee where product_id='"+id+"'");
                }
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException | ClassNotFoundException c){
        }
        
        
        return name;
        
    }
}
