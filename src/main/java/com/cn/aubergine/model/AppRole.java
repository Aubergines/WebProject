package com.cn.aubergine.model;

import java.io.Serializable;

/**
 * Created by china on 2016/6/2.
 */
public class AppRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String name;
    private String appCode;
    private String viewCode;
    private String viewName;



    public AppRole(String code2, String name2) {
        this.code = code2;
        this.name = name2;
    }

    public AppRole(String code, String name, String appCode, String viewCode, String viewName) {
        this.code = code;
        this.name = name;
        this.appCode = appCode;
        this.viewCode = viewCode;
        this.viewName = viewName;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public void setCode(String rCode) {
        this.code = rCode;
    }

    public void setViewCode(String viewCode) {
        this.viewCode = viewCode;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewCode() {
        return this.viewCode;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getAppCode() {
        return this.appCode;
    }

    public String getViewName() {
        return this.viewName;
    }


    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            AppRole other = (AppRole)o;
            return this.code.equalsIgnoreCase(other.code);
        } else {
            return false;
        }
    }
}
