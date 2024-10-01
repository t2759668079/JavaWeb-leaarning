package top.soft.class03response.response;

/**
 * @author Administrator
 * @description: TODO
 * @date 2024/9/29 14:10
 */

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.ServerException;

public class PdfViewerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        // 设置响应的内容类型为 PDF
        response.setContentType("application/pdf");
        // 设置响应的头部，告诉浏览器内嵌显示PDF
        response.setHeader("Content-Disposition", "inline; filename=\"Response.pdf\"");

        // 获取文件的路径
        String filePath = getServletContext().getRealPath("/Pdf/Response.pdf");

        // 创建输入流
        InputStream inputStream = new FileInputStream(filePath);
        ServletOutputStream outputStream = response.getOutputStream();

        // 创建缓冲区
        byte[] buffer = new byte[4096];
        int bytesRead;

        // 读取文件并写入到输出流
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // 关闭流
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}