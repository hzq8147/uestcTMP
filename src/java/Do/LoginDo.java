package Do;

import Strings.ResponseStrings;
import Utils.SqlSessionFactoryUtils;
import com.alibaba.fastjson.JSON;
import model.User;

import org.apache.ibatis.session.SqlSession;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.util.List;

public class LoginDo {

    public static  void main(String[] argc) throws IOException{

//testMain
        SqlSession session= SqlSessionFactoryUtils.getSession();
//        User usernew=new User();
//        usernew.setUsername("hzq8147");
//        usernew.setPassword("hzqhzq");
       // checkUser("hzq8147","hzqhzq");
//        User usernew=new User();
//        usernew.setName("lxy");
//        insertUser(session,usernew);
        //listAll(session);
     //   getUser(2);
        updateOpenid(1,"");

        session.commit();
        session.close();
    }
    public static User getUserByOpenid(String openid){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        User findUser=new User();
        findUser.setOpenId(openid);

        User user=session.selectOne("getUserByOpenid",findUser);
        if (user!=null) {
            System.out.println(user.getName());
            user.setPassword("");
            user.setOpenId("");
            return user;
        }
        return null;
    }
    public static User getUserByid(int Userid){
        SqlSession session= SqlSessionFactoryUtils.getSession();
        User findUser=new User();
        findUser.setId(Userid);

        User user=session.selectOne("getUser",findUser);
        if (user!=null) {
            System.out.println(user.getName());
            user.setPassword("");
            user.setOpenId("");
            return user;
        }
        return  null;

    }
    public static void updateOpenid(int UserId,String openId){
        //更新openid
        SqlSession session=SqlSessionFactoryUtils.getSession();
        User findUser=new User();
        findUser.setId(UserId);
        findUser.setOpenId(openId);

        int a=session.update("updateOpenid",findUser);
        System.out.println(a);
        session.commit();
        session.close();
    }
    public static User checkUser(String username,String password){
        //登录检测

        User loginUser=new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        SqlSession session= SqlSessionFactoryUtils.getSession();

        User user=session.selectOne("checkUser",loginUser);
        if (user!=null) {
            System.out.println(user.getName());
            user.setPassword("");
            user.setOpenId("");
            return user;
        }
        return  null;


    }
    private static void listAll(SqlSession session){
        //全部user
        List<User> userList=session.selectList("listUser");
        for(User us:userList){
            System.out.print(us.getId()+" ");
            System.out.print(us.getName()+" ");
            System.out.print(us.getIdentity()+" ");
            System.out.print(us.getUsername()+" ");
            System.out.println(us.getPassword());
        }
    }
    private static void insertUser(SqlSession session,User usernew){
        //注册用户
        session.insert("addUser",usernew);
    }
}
