package Do;

import Utils.SqlSessionFactoryUtils;
import com.alibaba.fastjson.JSON;
import model.Course;
import model.User;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CourseDo {
    public static void main(String argc[]) throws IOException {
    //test Get Course
        SqlSession sqlSession= SqlSessionFactoryUtils.getSession();

      getCourse(1);

    }
    public static String getCourse(int UserID){

        SqlSession session= SqlSessionFactoryUtils.getSession();

        User user=new User();
        user.setId(UserID);
        List<Course> courseList=session.selectList("getCourse",user);

        String resStr= JSON.toJSONString(courseList);

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
