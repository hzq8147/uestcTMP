package Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WechatLogin {
    public static void main(String argc[]){

        getOpenId("");
    }
    public static String getOpenId(String code){
        //发送GET请求 到微信api
            String result = "";
            BufferedReader in = null;
            String appId="wx89458589d559c95a";
            String secret="a6755ae64e0725a68ddf2e13fd71efd0";

            String url=" https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
            try {
                String urlName = url;
                URL realUrl = new URL(urlName);
                URLConnection conn = realUrl.openConnection();// 打开和URL之间的连接
                conn.setRequestProperty("accept", "*/*");// 设置通用的请求属性
                conn.setRequestProperty("connection", "Keep-Alive");
                conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
                conn.setConnectTimeout(4000);
                conn.connect();// 建立实际的连接
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));// 定义BufferedReader输入流来读取URL的响应
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            } catch (Exception e) {
                System.out.println("发送GET请求出现异常！" + e);
            } finally {// 使用finally块来关闭输入流
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    System.out.println("关闭流异常");
                }
            }

            JSONObject jsonObject= JSON.parseObject(result);
            String openID=jsonObject.getString("openid");
            System.out.println(openID);
            return openID;


    }
}
