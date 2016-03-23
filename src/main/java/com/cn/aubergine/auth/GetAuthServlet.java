package com.cn.aubergine.auth;

import com.alibaba.fastjson.JSON;
import com.qiniu.util.Auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by china on 2016/3/13.
 */
public class GetAuthServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("========================================================");
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        String ACCESS_KEY = "DgD2ppwRLMqSITFwJSEFSBaqkwPQdD3xUQVuVWpt";
        String SECRET_KEY = "vJ6DbpexZQjXgOomuyBxyCisuN4JV0ZmRjL6sKjo";
        //Ҫ�ϴ��Ŀռ�
        String bucketname = "dragon";
        //�ϴ�����ţ�󱣴���ļ���
        String key = "my-java.png";
        //�ϴ��ļ���·��
        String FilePath = "/.../...";
        //��Կ����
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //�����ϴ�����
        String upToken = getUpToken(auth, bucketname);
        Map map = new HashMap();
        map.put( "token", upToken);
        map.put( "name", getCurrentDateNum());
        String json = JSON.toJSONString(map, true);
        PrintWriter out = response.getWriter();
        out.print(json);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public String getUpToken(Auth auth,String bucketname){

        return auth.uploadToken(bucketname);
    }

    public static String getCurrentDateNum()
    {
        Date dttime= new Date();
        long time = dttime.getTime();
        return String.valueOf(time).concat(".mp4");
    }

}
