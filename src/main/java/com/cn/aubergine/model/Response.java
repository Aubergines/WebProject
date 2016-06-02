package com.cn.aubergine.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * Created by china on 2016/6/3.
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object body;
    private int status;
    private static final Response NONE;
    private String requestId;

    protected Response() {
    }

    public Response(Object obs) {
        this.body = obs;
    }

    public Response(Object body, int status, String requestId) {
        this.body = body;
        this.status = status;
        this.requestId = requestId;
    }

    public Object body() {
        return this.body;
    }

    public boolean isError() {
        return this.body != null && Throwable.class.isAssignableFrom(this.body.getClass());
    }


    public String toJson(SerializerFeature... features) {
        return this.body == null?"{}": JSON.toJSONString(this.body, features);
    }

    public final String requestId() {
        return this.requestId;
    }

    public static Response none() {
        return NONE;
    }

    static {
        NONE = new Response("".getBytes());
    }
}