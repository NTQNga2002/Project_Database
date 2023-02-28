/*/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
/*package com.myapp.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author admin
 */
/*public class ToolAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
/*    private static final String SUCCESS = "success";

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
/*    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ToolForm formBean = (ToolForm) form;
        String cmd = formBean.getCmd();
        
        return mapping.findForward(SUCCESS);
    }
    public String Runcmd(String cmd){
        /*if (user.equals("nam.ng") && pass.equals("123456"))
            check = 1;*/
        
 /*       String host="localhost";
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
}*/
