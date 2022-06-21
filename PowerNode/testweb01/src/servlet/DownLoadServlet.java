package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author cty
 * @date 2021/9/10 21:30
 */
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("down servlet doGet......");

        //1.设置响应头，返回的内容是图片
        resp.setContentType("image/*");
        //2.设置响应头，告诉浏览器将下载的内容使用附件的形式保存
        resp.setHeader("Content-Disposition", "attachment;filename=\"2.jpg\"");
        //3.使用流读取图片内容，发送到浏览器
        InputStream is = new FileInputStream("d:/1.jpg");
        OutputStream os = resp.getOutputStream();
        byte[] bs = new byte[1024];
        int length = 0;
        while ((length = is.read(bs)) != -1){
            os.write(bs, 0, length);
        }
        //4.关闭资源
        os.close();
        is.close();
    }
}
