package top.soft.response.response;
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

@WebServlet("/responseType")
public class ResponseDemo03 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        switch (type) {
            case "image":
                getImage(request, response);
                break;
            case "pdf":
                gerPdf(request, response);
                break;
            case "txt":
                getTxt(request, response);
                break;
            case "html":
                getHtml(request, response);
                break;
            default:
                break;
        }
    }
    private void getImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        String realPath = request.getServletContext().getRealPath("")+"/image/test.png";
        File file =new File(realPath);
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.close();
    }
    private void gerPdf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        String realPath = request.getServletContext().getRealPath("") + "/pdf/Get 请求获取参数数据-已压缩.pdf";
        File file = new File(realPath);
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.close();
    }
    private void getTxt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/plain");
        String realPath = request.getServletContext().getRealPath("") + "/txt/test.txt";
        File file = new File(realPath);
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.close();
    }
    private void getHtml(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
        String realPath = request.getServletContext().getRealPath("") + "/html/15.1 表格.html";
        File file = new File(realPath);
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.close();
    }
}

