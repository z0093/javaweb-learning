package top.soft.response.response;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
@WebServlet("/responseDemo02")
public class ResponseDemo02 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html,charset=GBT");
        ServletOutputStream out = response.getOutputStream();
        out.write("你好".getBytes(StandardCharsets.UTF_16));
    }
}
