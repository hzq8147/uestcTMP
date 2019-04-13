package Do;

import Utils.SqlSessionFactoryUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import model.Course;
import model.JiangGaoResult;
import model.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CourseDo {
    public static void main(String argc[]) throws IOException {
    //test Get Course
        SqlSession sqlSession= SqlSessionFactoryUtils.getSession();

      getJiangGaoResult(1);

    }
    public static String getCourse(int UserID){

        SqlSession session= SqlSessionFactoryUtils.getSession();

        User user=new User();
        user.setId(UserID);
        List<Course> courseList=session.selectList("getCourse",user);

        String resStr= JSON.toJSONString(courseList);

        return resStr;
    }
    public static String getJiangGaoResult(int CourseId){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        JiangGaoResult result=session.selectOne("selectJiangGaoResult",CourseId);
        Course courseOne=session.selectOne("selectOneCourse",CourseId);
        int score=courseOne.getJiangGaoScore();

        JSONObject jsonObj=new JSONObject();
        jsonObj.put("result",result);
        jsonObj.put("score",score);

        String resStr=JSON.toJSONString(jsonObj);
        return resStr;
    }
    public static void listAll(SqlSession sqlSession){
        List<Course> coursesList=sqlSession.selectList("listCourse");
        for (Course co:coursesList){
            System.out.print(co.getCourseId()+" ");
            System.out.print(co.getName()+" ");
            System.out.print(co.getTeacherId()+" ");

        }
    }
}
