package top.soft.bookonline.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.bookonline.service.UserService;
import top.soft.bookonline.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String captcha = req.getParameter("captcha");
        HttpSession session = req.getSession();
        String storedCaptcha = (String) session.getAttribute("captcha");
        if (storedCaptcha!= null && storedCaptcha.equalsIgnoreCase(captcha)) {
            // 验证码正确，进行注册逻辑
            try {
                int user = userService.register(account, password);
                if (user == 1) {
                    resp.setContentType("text/html;charset=utf-8");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter writer = resp.getWriter();
                    writer.write("<script>alert('注册成功！');");
                    writer.write("setTimeout(function(){window.location.href='login.html';},100);</script>");
                } else {
                    resp.setContentType("text/html;charset=utf-8");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write("<script>alert('注册失败');location.href='/redisterPage';</script>");
                }
            } catch (Exception e) {
                resp.setContentType("text/html;charset=utf-8");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("<script>alert('账户已经存在');location.href='/redisterPage';</script>");
            }
        } else {
            // 验证码错误
            resp.setContentType("text/html;charset=utf-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<script>alert('验证码错误');location.href='/redisterPage';</script>");
        }
    }
}