package controller;

import Do.CourseDo;
import Do.LoginDo;
import Utils.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;


@Controller
public class CourseScoreController {
    @RequestMapping("/getCourse")
    public void getCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String userId=jsonObj.getString("userId");
        System.out.println(userId +"is getCourse");

        String resStr= CourseDo.getCourse(Integer.parseInt(userId));
        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);

    }
    @RequestMapping("/getJiangGaoResult")
    public void getJiangGaoResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr= CourseDo.getJiangGaoResult(Integer.parseInt(courseId));

        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/getJiaoAnResult")
    public void getJiaoAnResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr= CourseDo.getJiaoAnResult(Integer.parseInt(courseId));

        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/getZhongQiResult")
    public void getZhongQiResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr= CourseDo.getZhongQiResult(Integer.parseInt(courseId));

        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/getZhuanJiaResult")
    public void getZhuanJiaResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr= CourseDo.getZhuanJiaResult(Integer.parseInt(courseId));

        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/getPingJiaoResult")
    public void getPingJiaoResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr= CourseDo.getPingJiaoResult(Integer.parseInt(courseId));

        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/getChuTiResult")
    public void getChuTiResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr= CourseDo.getChuTiResult(Integer.parseInt(courseId));

        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/getPingYueResult")
    public void getPingYueResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr= CourseDo.getPingYueResult(Integer.parseInt(courseId));

        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/getFenXiResult")
    public void getFenXiResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");

        String resStr= CourseDo.getFenXiResult(Integer.parseInt(courseId));

        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }

}
