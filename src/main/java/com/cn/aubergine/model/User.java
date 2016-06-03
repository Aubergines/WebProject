package com.cn.aubergine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by china on 2016/6/2.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    public static String NAME = User.class.getName();
    private String token = "";
    private String empId;
    private String userName;
    private String compCode;
    private String deptCode;
    private String ipAddress;
    private String password;
    private List<AppRole> appRole = new ArrayList();
    private String salesDeptCode;
    private String phoneNumber;

    public User() {
    }

    public User(String token, String empId, String userName, String compCode, String deptCode, String ipAddress, String password, List<AppRole> appRole, String salesDeptCode, String phoneNumber) {
        this.token = token;
        this.empId = empId;
        this.userName = userName;
        this.compCode = compCode;
        this.deptCode = deptCode;
        this.ipAddress = ipAddress;
        this.password = password;
        this.appRole = appRole;
        this.salesDeptCode = salesDeptCode;
        this.phoneNumber = phoneNumber;
    }

    public User(String empId, String userName, String compCode, String deptCode, String ipAddress, String password, List<AppRole> appRole, String salesDeptCode, String phoneNumber) {
        this.empId = empId;
        this.userName = userName;
        this.compCode = compCode;
        this.deptCode = deptCode;
        this.ipAddress = ipAddress;
        this.password = password;
        this.appRole = appRole;
        this.salesDeptCode = salesDeptCode;
        this.phoneNumber = phoneNumber;
    }

    public User(String empId, String password, String userName) {
        this.empId = empId;
        this.password = password;
        this.userName = userName;
    }

    public void addAppRole(AppRole role) {
        if(this.appRole == null) {
            this.appRole = new ArrayList();
        }

        this.appRole.add(role);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmpId() {
        return this.empId;
    }

    public List<AppRole> getAppRole() {
        return this.appRole;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getCompCode() {
        return this.compCode;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSalesDeptCode() {
        return this.salesDeptCode;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }


    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAppRole(List<AppRole> appRole) {
        this.appRole = appRole;
    }

    public void setSalesDeptCode(String salesDeptCode) {
        this.salesDeptCode = salesDeptCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
