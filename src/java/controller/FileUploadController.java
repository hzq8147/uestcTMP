package controller;

import Do.UploadDo;
import Utils.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FileUploadController {
    private static final String UPLOAD_LectureNote_DIRECTORY = "uploadLectureNote";
    private static final String UPLOAD_LessonPlan_DIRECTORY = "uploadLessonPlan";

    @RequestMapping("/uploadLectureNote")
    public void uploadLectureNote(HttpServletRequest request, HttpServletResponse response) throws Exception {

        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest mreq = resolver.resolveMultipart(request);
        MultipartFile file = mreq.getFile("file");//接收页面上传的文件名字,得到文件
        String courseId=mreq.getParameter("courseId");//对应的课程ID
        String fileName = file.getOriginalFilename();//上传的文件名
        String fileSize=String.valueOf(file.getSize());
        System.out.println(fileName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(new Date());
        //如果不存在创建目录
       String uploadPath = request.getServletContext().getRealPath("./") + File.separator +UPLOAD_LectureNote_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        //找到上传文件要放的路径,写到里面去
        String saveFileName=courseId+fileName.substring(fileName.lastIndexOf('.'));//实际文件名
        FileOutputStream fos = new FileOutputStream(uploadPath+"/"+saveFileName);
        fos.write(file.getBytes());//按字节方式写进去
        fos.flush();
        fos.close();
        UploadDo.updateLectureNoteFile(courseId,fileName,saveFileName,date,fileSize);//文件信息写入数据库
    }
    @RequestMapping("/getLectureNoteFileInf")
    public void getLectureNoteFileList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring= JsonUtils.getRequestPostStr(request);

        JSONObject jsonObj= JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr=UploadDo.getLectureNoteFileInf(courseId);
        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/uploadLessonPlan")
    public void uploadLessonPlan(HttpServletRequest request, HttpServletResponse response) throws Exception {

        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest mreq = resolver.resolveMultipart(request);
        MultipartFile file = mreq.getFile("file");//接收页面上传的文件名字,得到文件
        String courseId=mreq.getParameter("courseId");//对应的课程ID
        String fileName = file.getOriginalFilename();//上传的文件名
        String fileSize=String.valueOf(file.getSize());
        System.out.println(fileName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(new Date());
        //如果不存在创建目录
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator +UPLOAD_LessonPlan_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        //找到上传文件要放的路径,写到里面去
        String saveFileName=courseId+fileName.substring(fileName.lastIndexOf('.'));//实际文件名
        FileOutputStream fos = new FileOutputStream(uploadPath+"/"+saveFileName);
        fos.write(file.getBytes());//按字节方式写进去
        fos.flush();
        fos.close();
        UploadDo.updateLessonPlanFile(courseId,fileName,saveFileName,date,fileSize);//文件信息写入数据库
    }
    @RequestMapping("/getLessonPlanFileInf")
    public void getLessonPlanFileList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring= JsonUtils.getRequestPostStr(request);

        JSONObject jsonObj= JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr=UploadDo.getLessonPlanFileInf(courseId);
        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }

}
