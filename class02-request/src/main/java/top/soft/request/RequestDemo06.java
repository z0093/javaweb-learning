package top.soft.request;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo06")
public class RequestDemo06 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("requestDemo6被请求");
        response.getWriter().write("RequestDemo6");
        request.setAttribute("msg","hello");

        ServletContext context = request.getServletContext();
        context.setAttribute("info","hello");
    }
}
