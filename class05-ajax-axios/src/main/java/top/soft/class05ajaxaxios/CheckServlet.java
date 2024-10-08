package top.soft.class05ajaxaxios;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 从请求参数获取用户名
        String username = request.getParameter("username");
        //2.判断用户名是否存在
        boolean flag = !"admin".equals(username);
        //3.相应查询结果
        response.getWriter().write(String.valueOf(flag));
    }
}
