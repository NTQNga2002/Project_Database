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
public class LoginManagerAction extends org.apache.struts.action.Action {

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
        LoginManagerForm formBean = (LoginManagerForm) form;
        String user = formBean.getUser();
        String pass = formBean.getPass();
        if (checkuserpass(user,pass)==1)
            return mapping.findForward(SUCCESS);
        /*else
        if ((user == null) || 
            pass.length() < 8 || 
            user.equals("")) {   
        
        return mapping.findForward(FAILURE);
        }*/
        return mapping.findForward(FAILURE);
    }
    public int checkuserpass(String user, String pass){
        int check = 0;
        /*if (user.equals("nam.ng") && pass.equals("123456"))
            check = 1;*/
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
            rs = stmt.executeQuery("select * from admin");
            while (rs.next()){
                if(user.equals(rs.getString(2))){
                    if (pass.equals(rs.getString(3))) {
                        check = 1;
                        return 1;
                    } 
                }
            }
        rs.close();
        stmt.close();
        con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception c){
            c.printStackTrace();
        }
        return 0;
    }
}
