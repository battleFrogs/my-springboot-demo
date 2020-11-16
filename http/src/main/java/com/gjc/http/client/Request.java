package com.gjc.http.client;

import com.alibaba.fastjson.JSONObject;
import com.gjc.http.entity.UserVO;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class Request {

    @Resource
    private CloseableHttpClient httpClient;


    @Value("${BASE_URL}")
    private String BASE_URL;

    // get请求
    @RequestMapping("/testGet")
    public void testGet() throws IOException {
        String api = "test";
        String url = String.format("%s%s", BASE_URL, api);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @RequestMapping("/testPut")
    // put请求
    public void testPut() throws IOException {
        String api = "testPut";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPut httpPut = new HttpPut(url);

        UserVO userVO = new UserVO();
        userVO.setId(1L);
        userVO.setName("123");
        httpPut.setHeader("Content-Type", "application/json;charset=utf8");
        httpPut.setEntity(new StringEntity(JSONObject.toJSONString(userVO), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPut);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @RequestMapping("/testPost")
    public void testPost() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPost httpPost = new HttpPost(url);
        UserVO userVO = new UserVO();
        userVO.setId(1L);
        userVO.setName("123");
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setEntity(new StringEntity(JSONObject.toJSONString(userVO), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }




}
