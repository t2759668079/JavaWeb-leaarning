package top.soft.class03response.download;

/**
 * @author Administrator
 * @description: TODO
 * @date 2024/9/29 14:26
 */

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("a");
        switch (a){
            case "txt":
                downloadtxt(request, response);
                break;
                case "photo":
                    downloadphoto(request, response);
                    break;
                    default:
                        break;

        }
    }

    public void downloadphoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext servletContext = this.getServletContext();

        // 获取图片的服务器路径
        String imagePath = "/image/zhangsan.png"; // 相对于webapp目录的路径
        String realPath = servletContext.getRealPath(imagePath);

        // 创建FileInputStream来读取图片
        FileInputStream fis = new FileInputStream(realPath);

        // 获取图片的mime类型
        String mimeType = servletContext.getMimeType(imagePath);
        if (mimeType == null) {
            // 如果找不到mime类型，默认使用图片类型
            mimeType = "image/png";
        }

        // 设置响应头
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "zhangsan.png" + "\"");

        // 将图片内容写入响应输出流
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // 关闭流
        fis.close();
        outputStream.close();
    }
    public void downloadtxt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/a.txt");

        // 用字节流关联FileInputStream
        FileInputStream fis = new FileInputStream(realPath);

        // 获取文件的 MIME 类型
        String mimeType = servletContext.getMimeType("a.txt");

        // 设置响应头类型：content-type
        response.setHeader("Content-Type", mimeType);

        // 设置响应头打开方式:content-disposition
        response.setHeader("Content-Disposition", "attachment; filename=\"" +"a.txt"+ "\"");

        // 将输入流的数据写出到输出流中
        OutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len;
        while ((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        fis.close();
        sos.flush();
        sos.close();
    }
}