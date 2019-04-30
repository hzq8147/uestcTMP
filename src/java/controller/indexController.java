package controller;

import Do.LoginDo;
import Strings.ResponseStrings;
import Strings.menuString;
import Utils.JsonUtils;

import Utils.WechatLogin;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

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
        String identity=userJson.getString("identity");

        String responseData="";
        User user=LoginDo.checkUser(username,password);
        JSONObject resJson=new JSONObject();
        if (user!=null){
            System.out.println(user.getName()+"login");
            String userIdentity=user.getIdentity();
            int stat=userIdentity.indexOf(identity);
            if (stat==-1){
                //登录身份有误
                resJson.put("errId","-1");
            }else{
                //登陆成功
                user.setIdentity(identity);//设置为登录身份
                resJson.put("errId","1");
                resJson.put("user",user);
            }
        }else{
            //工号或密码错误
            resJson.put("errId","0");
        }
        responseData= JSON.toJSONString(resJson);

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
        String jsonstring=JsonUtils.getRequestPostStr(request);

        JSONObject jsonObj=JSON.parseObject(jsonstring);
        String username=jsonObj.getString("username");
        String password=jsonObj.getString("password");
        String identity=jsonObj.getString("identity");
        String xueYuan=jsonObj.getString("xueYuan");
        String zhiCheng=jsonObj.getString("zhiCheng");
        String name=jsonObj.getString("name");

        String errId=LoginDo.insertUser(username,password,identity,name,xueYuan,zhiCheng);
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("errId",errId);//errId=1时注册成功 =0时注册失败，用户名已经存在
        String resStr=JSON.toJSONString(jsonObject);
        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/loginWechat")
    public void loginWechat(HttpServletRequest request,HttpServletResponse response)throws  Exception{
        //微信登录
        response.setCharacterEncoding("UTF-8");

        String jsonString=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonString);
        String userCode=jsonObj.getString("code");

        String openid=WechatLogin.getOpenId(userCode);
        User user=LoginDo.getUserByOpenid(openid);
        JSONObject jsonObject=new JSONObject();

        if (user!=null){
            jsonObject.put("user",user);
            jsonObject.put("errId","1");
        }else{
            jsonObject.put("errId","0");
        }
        String resStr=JSON.toJSONString(jsonObject);
        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }
    @RequestMapping("/regWechat")
    public void RegWechat(HttpServletRequest request,HttpServletResponse response)throws  Exception{
        //微信注册（用户名密码登录）
        response.setCharacterEncoding("UTF-8");

        String jsonString=JsonUtils.getRequestPostStr(request);
        JSONObject jsonObj=JSON.parseObject(jsonString);
        String username=jsonObj.getString("username");
        String password=jsonObj.getString("password");
        String userCode=jsonObj.getString("code");

        JSONObject jsonObject=new JSONObject();
        User user=LoginDo.checkUser(username,password);
        if (user!=null)
        {
            String openid=WechatLogin.getOpenId(userCode);
            jsonObject.put("errId","1");//注册成功
            jsonObject.put("user",user);
            //保存openid
            LoginDo.updateOpenid(user.getId(),openid);

        }else{
            jsonObject.put("errId","0");//注册失败
        }
        String resStr=JSON.toJSONString(jsonObject);
        System.out.println(resStr);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=resStr.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }

    @RequestMapping("/getFeatureList")
    public void getFeatureList(HttpServletRequest request,HttpServletResponse response) throws Exception{
    //根据身份获取功能
        response.setCharacterEncoding("UTF-8");
        System.out.println("request Method:"+request.getMethod());
        String identity=request.getParameter("identity");
        System.out.println("identity request: "+identity);

        String str= menuString.getMenu(identity);

        OutputStream outputStream=response.getOutputStream();
        response.setHeader("content-type","text/html;charset=UTF-8");
        response.setStatus(200);
        byte[] dataByteArr=str.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }




}
