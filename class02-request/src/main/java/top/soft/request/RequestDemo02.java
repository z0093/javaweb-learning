package top.soft.request;


import jakarta. servlet. ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta. servlet.http.HttpServlet;
import jakarta.servlet.http. HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util. Enumeration;

/*
* @author ycshang
* @description: 获取请求头信息
*@date 2024-09-10 F43:36
* */



@WebServlet("/requestDemo02")
public class RequestDemo02 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头数据
        //1、遍历所有请求头数据
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = req.getHeader(name);
            System.out.println(name + ":" + value);
        }
        String header = req.getHeader(  "user-agent");
        if(header.contains("Edg")){
            System. out. println ("Edge浏览器");
        }
        else if(header.contains("Chrome")) {
            System. out. println("Chrome浏览器");
        }
    }

}