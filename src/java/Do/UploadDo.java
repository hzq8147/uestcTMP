package Do;

import Utils.SqlSessionFactoryUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import model.Files;
import org.apache.ibatis.session.SqlSession;

public class UploadDo {
        public static void updateLectureNoteFile(String courseId,String name,String filename,String date,String size) {
            SqlSession sqlSession= SqlSessionFactoryUtils.getSession();

            Files newFile=new Files();
            newFile.setCourseId(Integer.parseInt(courseId));
            newFile.setName(name);
            newFile.setFileName(filename);
            newFile.setDate(date);
            newFile.setSize(size);

            Files file=sqlSession.selectOne("findLectureNoteFile",Integer.parseInt(courseId));
            if (file!=null){
                sqlSession.update("updateLectureNoteFile",newFile);
            }else{
                sqlSession.insert("insertLectureNoteFile",newFile);
            }
            sqlSession.commit();
            sqlSession.close();
            return ;

        }
        public static String getLectureNoteFileInf(String courseId){
            SqlSession sqlSession= SqlSessionFactoryUtils.getSession();
            Files file=sqlSession.selectOne("findLectureNoteFile",Integer.parseInt(courseId));
            JSONObject jsonObj=new JSONObject();
            if (file!=null){
                jsonObj.put("errId","1");
                jsonObj.put("files",file);
            }else{
                //没有文件
                jsonObj.put("errId","0");
            }
            String resStr= JSON.toJSONString(jsonObj);
            return resStr;
        }
    public static void updateLessonPlanFile(String courseId,String name,String filename,String date,String size) {
        SqlSession sqlSession= SqlSessionFactoryUtils.getSession();

        Files newFile=new Files();
        newFile.setCourseId(Integer.parseInt(courseId));
        newFile.setName(name);
        newFile.setFileName(filename);
        newFile.setDate(date);
        newFile.setSize(size);

        Files file=sqlSession.selectOne("findLessonPlanFile",Integer.parseInt(courseId));
        if (file!=null){
            sqlSession.update("updateLessonPlanFile",newFile);
        }else{
            sqlSession.insert("insertLessonPlanFile",newFile);
        }
        sqlSession.commit();
        sqlSession.close();
        return ;

    }
    public static String getLessonPlanFileInf(String courseId){
        SqlSession sqlSession= SqlSessionFactoryUtils.getSession();
        Files file=sqlSession.selectOne("findLessonPlanFile",Integer.parseInt(courseId));
        JSONObject jsonObj=new JSONObject();
        if (file!=null){
            jsonObj.put("errId","1");
            jsonObj.put("files",file);
        }else{
            //没有文件
            jsonObj.put("errId","0");
        }
        String resStr= JSON.toJSONString(jsonObj);
        return resStr;
    }

}

