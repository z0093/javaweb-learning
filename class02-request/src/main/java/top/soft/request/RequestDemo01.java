package top.soft.request;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo01")
public class RequestDemo01 extends HelloServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String merhod = request.getMethod();
        System.out.println("请求方式"+merhod);

        String servletPath = request.getServletPath();
        System.out.println("获取servlet路径"+servletPath);

        String queryString = request.getQueryString();
        System.out.println("GET请求参数"+queryString);

        String requestURI = request.getRequestURI();
        System.out.println("请求URI"+requestURI);

        String requestURL = request.getRequestURL().toString();
        System.out.println("请求URL"+requestURL);

        String protocol = request.getProtocol();
        System.out.println("获取协议地址"+protocol);

        String contextPath = request.getContextPath();
        System.out.println("虚拟目录"+contextPath);
    }
}
