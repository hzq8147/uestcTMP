package Do;

import Utils.SqlSessionFactoryUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import model.*;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseDo {
    public static void main(String argc[]) throws IOException {
    //test Get Course
        SqlSession sqlSession= SqlSessionFactoryUtils.getSession();

      getPingJiaoResult(2);

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
	
	
	
	
	
	
	
	public static String postjianggaoResult(int courseId,String no1Answer,String no1Text,String no2Answer,String no2Text,String no3Answer,String no3Text,int score){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        JiangGaoResult result=new JiangGaoResult();
        result.setCourseId(courseId);
		result.setNo1Answer(no1Answer);
		result.setNo1Text(no1Text);
		result.setNo2Answer(no2Answer);
		result.setNo2Text(no2Text);
		result.setNo3Answer(no3Answer);
		result.setNo3Text(no3Text);
		Course course=new Course();
		course.setJiangGaoScore(score);
		course.setCourseId(courseId);
        session.insert("insertjianggaoResult", result);
		session.insert("insertjianggaoResultscore", course);
		session.commit();
        session.close();
        JSONObject jsonObj=new JSONObject();
		jsonObj.put("result",1);
		String resStr=JSON.toJSONString(jsonObj);

        
        return resStr;
    }
	public static String postzhongqiResult(int courseId,String dayiAnswer,String buzhiAnswer,String pigaiAnswer,String chuqinAnswer,int score){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        ZhongQiResult result=new ZhongQiResult();
        result.setCourseId(courseId);
		result.setDayiAnswer(dayiAnswer);
		result.setBuzhiAnswer(buzhiAnswer);
		result.setPigaiAnswer(pigaiAnswer);
		result.setChuqinAnswer(chuqinAnswer);
		
		Course course=new Course();
		course.setZhongQiScore(score);
		course.setCourseId(courseId);
        session.insert("insertzhongqiResult", result);
		session.insert("insertzhongqiResultscore", course);
		session.commit();
        session.close();
        JSONObject jsonObj=new JSONObject();
		jsonObj.put("result",1);
		String resStr=JSON.toJSONString(jsonObj);

        
        return resStr;
    }
	public static String postzhuanjiaResult(int courseId,String no1Answer,String no2Answer,String no3Answer,String no4Answer,String no5Answer,String no6Answer,String no7Answer,String advice,int score){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        ZhuanJiaResult result=new ZhuanJiaResult();
        result.setCourseId(courseId);
		result.setNo1Answer(no1Answer);
		result.setNo2Answer(no2Answer);
		result.setNo3Answer(no3Answer);
		result.setNo4Answer(no4Answer);
		result.setNo5Answer(no5Answer);
		result.setNo6Answer(no6Answer);
		result.setNo7Answer(no7Answer);
		result.setAdvice(advice);
		
		
		Course course=new Course();
		course.setTingKeScore(score);
		course.setCourseId(courseId);
        session.insert("insertzhuanjiaResult", result);
		session.insert("insertzhuanjiaResultscore", course);
		session.commit();
        session.close();
        JSONObject jsonObj=new JSONObject();
		jsonObj.put("result",1);
		String resStr=JSON.toJSONString(jsonObj);

        
        return resStr;
    }
	public static String postchutiResult(int courseId,String no1Answer,String no2Answer,String no3Answer,String no4Answer,String no5Answer,String no6Answer,String no7Answer,String no8Answer,String no9Answer,String no10Answer,String advice,int score){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        ChuTiResult result=new ChuTiResult();
        result.setCourseId(courseId);
		result.setChooseAnswer(no1Answer+','+no2Answer+','+no3Answer+','+no4Answer+','+no5Answer+','+no6Answer+','+no7Answer+','+no8Answer+','+no9Answer+','+no10Answer);
		
		result.setAdvice(advice);
		
		
		Course course=new Course();
		course.setChuTiScore(score);
		course.setCourseId(courseId);
        session.insert("insertchutiResult", result);
		session.insert("insertchutiResultscore", course);
		session.commit();
        session.close();
        JSONObject jsonObj=new JSONObject();
		jsonObj.put("result",1);
		String resStr=JSON.toJSONString(jsonObj);

        
        return resStr;
    }
	public static String postpingyueResult(int courseId,String no1Answer,String no2Answer,String no3Answer,String no4Answer,String no5Answer,String advice,int score){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        PingYueResult result=new PingYueResult();
        result.setCourseId(courseId);
		result.setChooseAnswer(no1Answer+','+no2Answer+','+no3Answer+','+no4Answer+','+no5Answer);
		
		result.setAdvice(advice);
		
		
		Course course=new Course();
		course.setPingYueScore(score);
		course.setCourseId(courseId);
        session.insert("insertpingyueResult", result);
		session.insert("insertpingyueResultscore", course);
		session.commit();
        session.close();
        JSONObject jsonObj=new JSONObject();
		jsonObj.put("result",1);
		String resStr=JSON.toJSONString(jsonObj);

        
        return resStr;
    }
	public static String postfenxiResult(int courseId,String no1Answer,String no2Answer,String no3Answer,String no4Answer,String no5Answer,String advice,int score){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        FenXiResult result=new FenXiResult();
        result.setCourseId(courseId);
		result.setChooseAnswer(no1Answer+','+no2Answer+','+no3Answer+','+no4Answer+','+no5Answer);
		
		result.setAdvice(advice);
		
		
		Course course=new Course();
		course.setBaoGaoScore(score);
		course.setCourseId(courseId);
        session.insert("insertfenxiResult", result);
		session.insert("insertfenxiResultscore", course);
		session.commit();
        session.close();
        JSONObject jsonObj=new JSONObject();
		jsonObj.put("result",1);
		String resStr=JSON.toJSONString(jsonObj);

        
        return resStr;
    }
	public static String postjiaoanResult(int courseId,String xinkeAnswer,String jiaoanAnswer,String no1Answer,String no1Text,String no2Answer,String no2Text,String no3Answer,String no3Text,String no4Answer,String no4Text,String no5Answer,String no5Text,String no6Answer,String no6Text,String no7Answer,String no7Text,String no8Answer,String no8Text,String zongtiAnswer,int score){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        JiaoAnResult result=new JiaoAnResult();
		result.setCourseId(courseId);
		result.setXinkeAnswer(xinkeAnswer);
		result.setJiaoanAnswer(jiaoanAnswer);
		result.setNo1Answer(no1Answer);
		result.setNo1Text(no1Text);
		result.setNo2Answer(no2Answer);
		result.setNo2Text(no2Text);
		result.setNo3Answer(no3Answer);
		result.setNo3Text(no3Text);
		result.setNo4Answer(no4Answer);
		result.setNo4Text(no4Text);
		result.setNo5Answer(no5Answer);
		result.setNo5Text(no5Text);
		result.setNo6Answer(no6Answer);
		result.setNo6Text(no6Text);
		result.setNo7Answer(no7Answer);
		result.setNo7Text(no7Text);
		result.setNo8Answer(no8Answer);
		result.setNo8Text(no8Text);
		result.setZongtiAnswer(zongtiAnswer);
		Course course=new Course();
		course.setJiaoAnScore(score);
		course.setCourseId(courseId);
		session.insert("insertJiaoAnResult", result);
		session.insert("insertJiaoAnResultscore", course);
		session.commit();
        session.close();
        JSONObject jsonObj=new JSONObject();
		jsonObj.put("result",1);
		String resStr=JSON.toJSONString(jsonObj);

        
        return resStr;
    }
	
	
	
	
	
	
	
	
    public static String getJiaoAnResult(int CourseId){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        JiaoAnResult result=session.selectOne("selectJiaoAnResult",CourseId);
        Course courseOne=session.selectOne("selectOneCourse",CourseId);
        User teacher=session.selectOne("getUserById",courseOne.getTeacherId());
        int score=courseOne.getJiaoAnScore();
        String name=courseOne.getName();
        String teacherName=teacher.getName();
        String zhiCheng=teacher.getZhiCheng();
        String xueYuan=teacher.getXueYuan();

        JSONObject jsonObj=new JSONObject();
        jsonObj.put("result",result);
        jsonObj.put("courseName",name);
        jsonObj.put("zhiCheng",zhiCheng);
        jsonObj.put("xueYuan",xueYuan);
        jsonObj.put("teacherName",teacherName);
        jsonObj.put("score",score);
        String resStr=JSON.toJSONString(jsonObj);
        return resStr;
    }
    public static String getZhongQiResult(int CourseId){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        ZhongQiResult result=session.selectOne("selectZhongQiResult",CourseId);
        Course courseOne=session.selectOne("selectOneCourse",CourseId);
        int score=courseOne.getZhongQiScore();

        JSONObject jsonObj=new JSONObject();
        jsonObj.put("result",result);
        jsonObj.put("score",score);
        String resStr=JSON.toJSONString(jsonObj);
        return resStr;
    }
    public static String getZhuanJiaResult(int CourseId){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        ZhuanJiaResult result=session.selectOne("selectZhuanJiaResult",CourseId);
        Course courseOne=session.selectOne("selectOneCourse",CourseId);
        int score=courseOne.getTingKeScore();

        JSONObject jsonObj=new JSONObject();
        jsonObj.put("result",result);
        jsonObj.put("score",score);
        String resStr=JSON.toJSONString(jsonObj);
        return resStr;
    }
    public static  String getPingJiaoResult(int CourseId){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        PingJiaoResult result=session.selectOne("selectPingJiaoResult",CourseId);
        if (result!=null) {
            String peoStr = result.getPeopleAnswer();
            String percentStr = result.getPercentAnswer();
            int index = -1;
            List<String> peoplelist = new ArrayList<>();
            for (int i = 0; i < peoStr.length(); i++) {
                char tmp = peoStr.charAt(i);
                if (tmp == ',') {
                    if (index == -1) {
                        index = i;
                        peoplelist.add(peoStr.substring(0, index));
                    } else {
                        peoplelist.add(peoStr.substring(index + 1, i));
                        index = i;
                    }
                }
            }
            peoplelist.add(peoStr.substring(index + 1, peoStr.length()));
            int ind = -1;
            List<String> percentlist = new ArrayList<>();
            for (int i = 0; i < percentStr.length(); i++) {
                char tmp = percentStr.charAt(i);
                if (tmp == ',') {
                    if (ind == -1) {
                        ind = i;
                        percentlist.add(percentStr.substring(0, ind));
                    } else {
                        percentlist.add(percentStr.substring(ind + 1, i));
                        ind = i;
                    }
                }
            }
            percentlist.add(percentStr.substring(ind + 1, percentStr.length()));
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("errId","1");
            jsonobj.put("peopleAnswer", peoplelist);
            jsonobj.put("percentAnswer", percentlist);
            jsonobj.put("peopleNumber", result.getPeopleNumber());
            jsonobj.put("starNumber", result.getStarNumber());

            String resStr = jsonobj.toJSONString();
            System.out.println(resStr);

            return resStr;
        }
        else{
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("errId","0");

            String resStr=jsonobj.toJSONString();
            System.out.println(resStr);

            return resStr;
        }
    }
    public static String getChuTiResult(int CourseId){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        ChuTiResult result=session.selectOne("selectChuTiResult",CourseId);
        if (result!=null) {
            List<Problem> problemList = session.selectList("selectChuTiProblem", CourseId);
            Course cou = session.selectOne("selectOneCourse", CourseId);
            int score = cou.getChuTiScore();
            String answerStr = result.getChooseAnswer();

            int index = -1;
            List<String> answerlist = new ArrayList<>();
            for (int i = 0; i < answerStr.length(); i++) {
                char tmp = answerStr.charAt(i);
                if (tmp == ',') {
                    if (index == -1) {
                        index = i;
                        answerlist.add(answerStr.substring(0, index));
                    } else {
                        answerlist.add(answerStr.substring(index + 1, i));
                        index = i;
                    }
                }
            }
            answerlist.add(answerStr.substring(index + 1, answerStr.length()));

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("errId","1");
            jsonObj.put("answer", answerlist);
            jsonObj.put("advice", result.getAdvice());
            jsonObj.put("problem", problemList);
            jsonObj.put("score", score);

            String resStr = jsonObj.toJSONString();
            return resStr;
        }else{
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("errId","0");

            String resStr=jsonObj.toJSONString();
            return resStr;

        }

    }
    public static String getPingYueResult(int CourseId){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        PingYueResult result=session.selectOne("selectPingYueResult",CourseId);
        if (result!=null) {
            List<Problem> problemList = session.selectList("selectPingYueProblem", CourseId);
            Course cou = session.selectOne("selectOneCourse", CourseId);
            int score = cou.getPingYueScore();
            String answerStr = result.getChooseAnswer();

            int index = -1;
            List<String> answerlist = new ArrayList<>();
            for (int i = 0; i < answerStr.length(); i++) {
                char tmp = answerStr.charAt(i);
                if (tmp == ',') {
                    if (index == -1) {
                        index = i;
                        answerlist.add(answerStr.substring(0, index));
                    } else {
                        answerlist.add(answerStr.substring(index + 1, i));
                        index = i;
                    }
                }
            }
            answerlist.add(answerStr.substring(index + 1, answerStr.length()));

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("errId","1");
            jsonObj.put("answer", answerlist);
            jsonObj.put("advice", result.getAdvice());
            jsonObj.put("problem", problemList);
            jsonObj.put("score", score);

            String resStr = jsonObj.toJSONString();
            return resStr;
        }else{
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("errId","0");

            String resStr= jsonObj.toJSONString();
            return resStr;
        }
    }
    public static String getFenXiResult(int CourseId){
        SqlSession session=SqlSessionFactoryUtils.getSession();
        FenXiResult result=session.selectOne("selectFenXiResult",CourseId);
        if (result!=null) {
            List<Problem> problemList = session.selectList("selectFenXiProblem", CourseId);
            Course cou = session.selectOne("selectOneCourse", CourseId);
            int score = cou.getBaoGaoScore();
            String answerStr = result.getChooseAnswer();

            int index = -1;
            List<String> answerlist = new ArrayList<>();
            for (int i = 0; i < answerStr.length(); i++) {
                char tmp = answerStr.charAt(i);
                if (tmp == ',') {
                    if (index == -1) {
                        index = i;
                        answerlist.add(answerStr.substring(0, index));
                    } else {
                        answerlist.add(answerStr.substring(index + 1, i));
                        index = i;
                    }
                }
            }
            answerlist.add(answerStr.substring(index + 1, answerStr.length()));

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("errId","1");
            jsonObj.put("answer", answerlist);
            jsonObj.put("advice", result.getAdvice());
            jsonObj.put("problem", problemList);
            jsonObj.put("score", score);

            String resStr = jsonObj.toJSONString();
            System.out.println(resStr);
            return resStr;
        }else {
            JSONObject jsonObj=new JSONObject();
            jsonObj.put("errId","0");

            String resStr=jsonObj.toJSONString();
            return resStr;
        }
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
