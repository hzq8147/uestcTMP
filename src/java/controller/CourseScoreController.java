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

        String resStr= CourseDo.getCourse(Integer.parseInt(userId));
        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);

    }
	
	
	
	
	
	
	//教案
	@RequestMapping("/postJiaoAnResult")
    public void postJiaoAnResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");
        String xinkeAnswer=jsonObj.getString("xinkeAnswer");
        String jiaoanAnswer=jsonObj.getString("jiaoanAnswer");
        String no1Answer=jsonObj.getString("no1Answer");
        String no1Text=jsonObj.getString("no1Text");
        String no2Answer=jsonObj.getString("no2Answer");
        String no2Text=jsonObj.getString("no2Text");
        String no3Answer=jsonObj.getString("no3Answer");
        String no3Text=jsonObj.getString("no3Text");
        String no4Answer=jsonObj.getString("no4Answer");
        String no4Text=jsonObj.getString("no4Text");
        String no5Answer=jsonObj.getString("no5Answer");
        String no5Text=jsonObj.getString("no5Text");
        String no6Answer=jsonObj.getString("no6Answer");
        String no6Text=jsonObj.getString("no6Text");
        String no7Answer=jsonObj.getString("no7Answer");
        String no7Text=jsonObj.getString("no7Text");
        String no8Answer=jsonObj.getString("no8Answer");
        String no8Text=jsonObj.getString("no8Text");
        String zongtiAnswer=jsonObj.getString("zongtiAnswer");
        String score=jsonObj.getString("score");

        String resStr= CourseDo.postjiaoanResult(Integer.parseInt(courseId),xinkeAnswer,jiaoanAnswer,no1Answer,no1Text,no2Answer,no2Text,no3Answer,no3Text,no4Answer,no4Text,no5Answer,no5Text,no6Answer,no6Text,no7Answer,no7Text,no8Answer,no8Text,zongtiAnswer,Integer.parseInt(score));

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);

    }
	//讲稿
	@RequestMapping("/postJiangGaoResult")
    public void postJiangGaoResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String courseId=jsonObj.getString("courseId");
		String no1Answer=jsonObj.getString("no1Answer");
        String no1Text=jsonObj.getString("no1Text");
        String no2Answer=jsonObj.getString("no2Answer");
        String no2Text=jsonObj.getString("no2Text");
        String no3Answer=jsonObj.getString("no3Answer");
        String no3Text=jsonObj.getString("no3Text");
		String score=jsonObj.getString("score");
		String resStr= CourseDo.postjianggaoResult(Integer.parseInt(courseId),no1Answer,no1Text,no2Answer,no2Text,no3Answer,no3Text,Integer.parseInt(score));

		OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
	//中期
	@RequestMapping("/postZhongQiResult")
    public void postzhongqiResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
		
        String courseId=jsonObj.getString("courseId");
		String dayiAnswer=jsonObj.getString("dayiAnswer");
        String buzhiAnswer=jsonObj.getString("buzhiAnswer");
        String pigaiAnswer=jsonObj.getString("pigaiAnswer");
        String chuqinAnswer=jsonObj.getString("chuqinAnswer");
      
		String score=jsonObj.getString("score");
		String resStr= CourseDo.postzhongqiResult(Integer.parseInt(courseId),dayiAnswer,buzhiAnswer,pigaiAnswer,chuqinAnswer,Integer.parseInt(score));

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
	//zhuanjia
	@RequestMapping("/postZhuanJiaResult")
    public void postzhuanjiaResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
		
        String courseId=jsonObj.getString("courseId");
		String no1Answer=jsonObj.getString("no1Answer");
		String no2Answer=jsonObj.getString("no2Answer");
		String no3Answer=jsonObj.getString("no3Answer");
		String no4Answer=jsonObj.getString("no4Answer");
		String no5Answer=jsonObj.getString("no5Answer");
		String no6Answer=jsonObj.getString("no6Answer");
		String no7Answer=jsonObj.getString("no7Answer");
        String advice=jsonObj.getString("advice");
        
      
		String score=jsonObj.getString("score");
		String resStr= CourseDo.postzhuanjiaResult(Integer.parseInt(courseId),no1Answer,no2Answer,no3Answer,no4Answer,no5Answer,no6Answer,no7Answer,advice,Integer.parseInt(score));

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
	//chuti
	@RequestMapping("/postchutiResult")
    public void postchutiResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
		
        String courseId=jsonObj.getString("courseId");
		String no1Answer=jsonObj.getString("no1Answer");
		String no2Answer=jsonObj.getString("no2Answer");
		String no3Answer=jsonObj.getString("no3Answer");
		String no4Answer=jsonObj.getString("no4Answer");
		String no5Answer=jsonObj.getString("no5Answer");
		String no6Answer=jsonObj.getString("no6Answer");
		String no7Answer=jsonObj.getString("no7Answer");
		String no8Answer=jsonObj.getString("no8Answer");
		String no9Answer=jsonObj.getString("no9Answer");
		String no10Answer=jsonObj.getString("no10Answer");
        String advice=jsonObj.getString("advice");
        
      
		String score=jsonObj.getString("score");
		String resStr= CourseDo.postchutiResult(Integer.parseInt(courseId),no1Answer,no2Answer,no3Answer,no4Answer,no5Answer,no6Answer,no7Answer,no8Answer,no9Answer,no10Answer,advice,Integer.parseInt(score));

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
	//pingyue
	@RequestMapping("/postpingyueResult")
    public void postpingyueResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
		
        String courseId=jsonObj.getString("courseId");
		String no1Answer=jsonObj.getString("no1Answer");
		String no2Answer=jsonObj.getString("no2Answer");
		String no3Answer=jsonObj.getString("no3Answer");
		String no4Answer=jsonObj.getString("no4Answer");
		String no5Answer=jsonObj.getString("no5Answer");
		
        String advice=jsonObj.getString("advice");
        
      
		String score=jsonObj.getString("score");
		String resStr= CourseDo.postpingyueResult(Integer.parseInt(courseId),no1Answer,no2Answer,no3Answer,no4Answer,no5Answer,advice,Integer.parseInt(score));

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
	//fenxi
	@RequestMapping("/postfenxiResult")
    public void postfenxiResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String jsonstring=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonstring);
		
        String courseId=jsonObj.getString("courseId");
		String no1Answer=jsonObj.getString("no1Answer");
		String no2Answer=jsonObj.getString("no2Answer");
		String no3Answer=jsonObj.getString("no3Answer");
		String no4Answer=jsonObj.getString("no4Answer");
		String no5Answer=jsonObj.getString("no5Answer");
		
        String advice=jsonObj.getString("advice");
        
      
		String score=jsonObj.getString("score");
		String resStr= CourseDo.postfenxiResult(Integer.parseInt(courseId),no1Answer,no2Answer,no3Answer,no4Answer,no5Answer,advice,Integer.parseInt(score));

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


        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
	

}
