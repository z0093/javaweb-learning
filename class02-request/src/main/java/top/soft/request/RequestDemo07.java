package top.soft.request;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo07")
public class RequestDemo07 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

       /* request.getAttribute("msg");
        request.removeAttribute("msg");*/
        ServletContext servletContext = request.getServletContext();
        Object info = String.valueOf(servletContext.getAttribute("info"));
        System.out.println("info: " + info);
    }
}
