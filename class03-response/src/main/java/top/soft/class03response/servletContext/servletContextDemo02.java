package top.soft.class03response.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @description: TODO
 * @date 2024/9/28 16:43
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


@WebServlet("/servletContextDemo02")
public class servletContextDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext servletContext = req.getServletContext();
        resp.setContentType("text/html;charset=utf-8");
        // 获取webapp目录下的资源
        String aRealPath = servletContext.getRealPath("/a.txt");
        System.out.println(aRealPath);

        // 获取WEB-INF目录下的资源
        String bRealPath = servletContext.getRealPath("/WEB-INF/b.txt");
        System.out.println(bRealPath);

        // 读取并输出a.txt文件内容
        File file = new File(aRealPath);
        InputStream in = new FileInputStream(file);
        int read=0;
        OutputStream out = resp.getOutputStream();


        while ((read = in.read()) != -1) {
            out.write(read);
        }

        in.close();
        out.flush();
        out.close();
    }
}