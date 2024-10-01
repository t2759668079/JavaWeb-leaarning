package top.soft.class03response.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Administrator
 * @description: TODO
 * @date 2024/9/28 16:36
 */
@WebServlet("/servletContextDemo01")
public class servletContextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过request对象获取ServletContext
        ServletContext servletContext01 = req.getServletContext();
        // 通过当前Servlet实例获取ServletContext
        ServletContext servletContext02 = this.getServletContext();

        // 打印两个ServletContext对象是否相同
        System.out.println(servletContext01.equals(servletContext02));
    }
}
