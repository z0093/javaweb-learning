package top.soft.response.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/servletContextDemo04")
public class ServletContextDemo04 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        String aPath = servletContext.getRealPath("/a.txt");
        System.out.println("a.txt文件地址"+aPath);
        String bPath = servletContext.getRealPath("/WEB-INF/b.txt");
        System.out.println("b.txt文件地址"+bPath);
        String cPath = servletContext.getRealPath("/webapp/c.txt");
        System.out.println("c.txt文件地址"+cPath);
        File file = new File(bPath);
        InputStream in= new FileInputStream(file);
        int read = in.read();
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            outputStream.write(read);
        }
            outputStream.flush();
            outputStream.close();
        }
}
