package action;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "ImgServlet", value = "/uploadimage")
@MultipartConfig
public class ImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        imgUpload(request, response);

    }


    private void imgUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        JSONObject result = new JSONObject();

        PrintWriter out = response.getWriter();

        String basePath = this.getServletContext().getRealPath("/");//获取webapps的路径

        Part p = request.getPart("upfile");

        if (p.getContentType().contains("image")) {

            String fileName = p.getSubmittedFileName();//获取上传文件的名称


            String path = basePath + "/upload/";

            File file = new File(path);

            if (!file.exists())
                file.mkdirs();

            String newFileName = UUID.randomUUID()+fileName;

            p.write(path + newFileName);

            result.append("state", "SUCCESS");
            result.append("url", "/upload/" + newFileName);
//            result.append("title",newFileName);
//            result.append("original", fileName);
            result.append("type",".jpg");
            result.append("size",p.getSize());


        } else {
            result.append("state", "FAIL");
        }
        System.out.println(result.toString());
        out.write(result.toString());
    }
}
