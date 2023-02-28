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
import java.io.IOException;
/**
 *
 * @author admin
 */
public class LoginSaleAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    String name="";

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
        LoginSaleForm formBean = (LoginSaleForm) form;
        String user = formBean.getUser();
        String pass = formBean.getPass();
        if (checkuserpass(user,pass)==1){
            formBean.setName(name);
            return mapping.findForward(SUCCESS);
        }
        /*else
        if ((user == null) || 
            pass.length() < 8 || 
            user.equals("")) {   
        
        return mapping.findForward(FAILURE);
        }*/
        return mapping.findForward(FAILURE);
    }
    public int checkuserpass(String user, String pass) throws ClassNotFoundException{
        int check = 0;
        /*if (user.equals("nam.ng") && pass.equals("123456"))
            check = 1;*/
        Connection con = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quanlibanhang_final?loggerLevel=OFF","postgres","namhhbg0001");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from employee");
            while (rs.next()){
                if(user.equals(rs.getString(1))&&pass.equals(rs.getString(6))){
                    check = 1;
                    name = rs.getString(2);
                    return 1;
                }
            }
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            name="";
            e.printStackTrace();
        }
        return 0;
    }
}
