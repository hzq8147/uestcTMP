package Do;

import Utils.SqlSessionFactoryUtils;
import model.Course;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CourseDo {
    public static void main(String argc[]) throws IOException {
    //test Get Course
        SqlSession sqlSession= SqlSessionFactoryUtils.getSession();

        listAll(sqlSession);

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
