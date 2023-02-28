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
public class SearchEmployeeAction extends org.apache.struts.action.Action {

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
        SearchEmployeeForm formBean = (SearchEmployeeForm) form;
        String id = formBean.getId();
        List<Employee> employees = checkEmployee(id);
        if(employees!=null){
            formBean.setName(null);
            formBean.setEmployee(employees);
            return mapping.findForward(SUCCESS);
        }
        formBean.setName(": invalid or error!");
            
        return mapping.findForward(FAILURE);
        
    }
    public List checkEmployee(String id) throws ClassNotFoundException{
        List<Employee> employees = new ArrayList<>();
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
                if(id.equals(rs.getString("employee_id"))){
                    Employee employee = new Employee();
                    employee.setId(rs.getString(1));
                    employee.setName(rs.getString(2));
                    employee.setDob(rs.getString(3));
                    employee.setSex(rs.getString(4));
                    employee.setAddress(rs.getString(5));
                    employee.setPhone(rs.getString(6));
                    employee.setSalary(rs.getString(7));
                    employees.add(employee);
                }
            }
        rs.close();
        stmt.close();
        con.close();    
        }catch(SQLException e){
            
            e.printStackTrace();
        }
        return employees;
        
    } 
}
