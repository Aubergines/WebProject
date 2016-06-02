package com.cn.aubergine.auth;

import com.alibaba.fastjson.JSON;
import com.cn.aubergine.model.AppRole;
import com.cn.aubergine.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by china on 2016/6/2.
 */
public class GetUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("========================================================");
        List<AppRole> listRole = new ArrayList<AppRole>();
        AppRole role = new AppRole("1","π‹¿Ì‘±","0001","viewCode","viewCode");
        listRole.add(role);
        User user = new User();
        user.setToken("token");
        user.setEmpId("empId");
        user.setUserName("userName");
        user.setCompCode("compCOde");
        user.setDeptCode("deptCode");
        user.setIpAddress("ipAddress");
        user.setPassword("password");
        user.setSalesDeptCode("salesDeptCode");
        user.setPhoneNumber("phoneNumber");
        user.setAppRole(listRole);
        String json = JSON.toJSONString(user, true);
        PrintWriter out = response.getWriter();
        out.print(json);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }


}
