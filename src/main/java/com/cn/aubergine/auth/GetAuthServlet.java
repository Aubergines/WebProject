package com.cn.aubergine.auth;

import com.alibaba.fastjson.JSON;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

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
        //要上传的空间
        String bucketname = "dragon";
        //上传到七牛后保存的文件名
        String key = "my-java.png";
        //上传文件的路径
        String FilePath = "/.../...";
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //创建上传对象
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

        StringMap policy = new StringMap();
        String use_bucket = bucketname;
        String offset = "4";
        String keystr = String.valueOf(System.currentTimeMillis());  //.substring(0, key.indexOf("."));
        String tempTime = String.valueOf(System.currentTimeMillis());
        //测试先转码成mp4,然后对这个结果进行
        String saveas1 = UrlSafeBase64.encodeToString(use_bucket + ":" + keystr + "_480_320" + ".mp4");
        String saveas2 = UrlSafeBase64.encodeToString(use_bucket+":"+keystr+"_1280_720"+".mp4");
        String saveas3 = UrlSafeBase64.encodeToString(use_bucket+":"+keystr+"_"+tempTime+"_225_150"+".jpg");
        String saveas4 = UrlSafeBase64.encodeToString(use_bucket+":"+keystr+"_"+tempTime+"_157_109"+".jpg");
        String saveas5 = UrlSafeBase64.encodeToString(use_bucket+":"+keystr+"_"+tempTime+"_75_52"+".jpg");
        //avthumb/mp4/rotate/auto/wmImage | avthumb/mp4/s/480x320
        policy.putNotEmpty("persistentPipeline", "dragon");
        policy.putNotEmpty("persistentOps", "vframe/jpg/offset/"+offset+"/w/225/h/150|saveas/"+saveas3 +
                ";vframe/jpg/offset/"+offset+"/w/157/h/109|saveas/"+saveas4 +
                ";vframe/jpg/offset/"+offset+"/w/75/h/52|saveas/"+saveas5);

        return auth.uploadToken(use_bucket, keystr, 7200, policy);

    }

    public static String getCurrentDateNum()
    {
        Date dttime= new Date();
        long time = dttime.getTime();
        return String.valueOf(time).concat(".mp4");
    }

}
