package top.soft.response.response;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(200);
        response.setHeader("location","/responseDemo02");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("你好ResponseDemo01");
    }
}
