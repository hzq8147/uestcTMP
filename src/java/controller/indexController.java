package controller;

import Do.LoginDo;
import Strings.menuString;
import Utils.JsonUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

@Controller
public class indexController  {
    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mav=new ModelAndView("index.jsp");
        mav.addObject("message","helloSpring Mvc");
        return mav;
    }
    @RequestMapping("/login")
    public void checkLogin(HttpServletRequest request,HttpServletResponse response)throws  Exception{
        //登录接口
        //request action
        response.setCharacterEncoding("UTF-8");
        System.out.println("request Method:"+request.getMethod());
        String jsonstring=JsonUtils.getRequestPostStr(request);
        System.out.println(jsonstring);

        JSONObject userJson = JSON.parseObject(jsonstring);

        String username = userJson.getString("username");
        String password=userJson.getString("password");

        String responseData=LoginDo.checkUser(username,password);

        //response action
        System.out.println(responseData);
        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=responseData.getBytes("UTF-8");
        outputStream.write(dataByteArr);

    }
    @RequestMapping("/register")
    public void register(HttpServletRequest request,HttpServletResponse response)throws  Exception{
        //注册接口
        response.setCharacterEncoding("UTF-8");
        System.out.println("request Method:"+request.getMethod());
        String jsonstring=JsonUtils.getRequestPostStr(request);
        System.out.println(jsonstring);


    }
    @RequestMapping("/getFeatureList")
    public void getFeatureList(HttpServletRequest request,HttpServletResponse response) throws Exception{
    //根据身份获取功能
        response.setCharacterEncoding("UTF-8");
        System.out.println("request Method:"+request.getMethod());
        String identity=request.getParameter("identity");
        System.out.println("identity request: "+identity);

        String str= menuString.getMenu(identity);
        System.out.println(str);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=str.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }




}
