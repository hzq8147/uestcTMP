package model;

public class Course {
    private int courseId;
    private String name;
    private int teacherId;
    private int resTeacherId;
    private String Term;
    private int JiaoAnScore;
    private int JiangGaoScore;
    private int ZhongQiScore;
    private int TingKeScore;
    private int PingJiaoScore;
    private int ChuTiScore;
    private int PingYueScore;
    private int BaoGaoScore;
    private int TotalScore;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getResTeacherId() {
        return resTeacherId;
    }

    public void setResTeacherId(int resTeacherId) {
        this.resTeacherId = resTeacherId;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public int getJiaoAnScore() {
        return JiaoAnScore;
    }

    public void setJiaoAnScore(int jiaoAnScore) {
        JiaoAnScore = jiaoAnScore;
    }

    public int getJiangGaoScore() {
        return JiangGaoScore;
    }

    public void setJiangGaoScore(int jiangGaoScore) {
        JiangGaoScore = jiangGaoScore;
    }

    public int getZhongQiScore() {
        return ZhongQiScore;
    }

    public void setZhongQiScore(int zhongQiScore) {
        ZhongQiScore = zhongQiScore;
    }

    public int getTingKeScore() {
        return TingKeScore;
    }

    public void setTingKeScore(int tingKeScore) {
        TingKeScore = tingKeScore;
    }

    public int getPingJiaoScore() {
        return PingJiaoScore;
    }

    public void setPingJiaoScore(int pingJiaoScore) {
        PingJiaoScore = pingJiaoScore;
    }

    public int getChuTiScore() {
        return ChuTiScore;
    }

    public void setChuTiScore(int chuTiScore) {
        ChuTiScore = chuTiScore;
    }

    public int getPingYueScore() {
        return PingYueScore;
    }

    public void setPingYueScore(int pingYueScore) {
        PingYueScore = pingYueScore;
    }

    public int getBaoGaoScore() {
        return BaoGaoScore;
    }

    public void setBaoGaoScore(int baoGaoScore) {
        BaoGaoScore = baoGaoScore;
    }

    public int getTotalScore() {
        return TotalScore;
    }

    public void setTotalScore(int totalScore) {
        TotalScore = totalScore;
    }
}
