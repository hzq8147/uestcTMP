package model;

public class ZhongQiResult {
    private int id;
    private int CourseId;
    private String dayiAnswer;
    private String buzhiAnswer;
    private String pigaiAnswer;
    private String chuqinAnswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public String getDayiAnswer() {
        return dayiAnswer;
    }

    public void setDayiAnswer(String dayiAnswer) {
        this.dayiAnswer = dayiAnswer;
    }

    public String getBuzhiAnswer() {
        return buzhiAnswer;
    }

    public void setBuzhiAnswer(String buzhiAnswer) {
        this.buzhiAnswer = buzhiAnswer;
    }

    public String getPigaiAnswer() {
        return pigaiAnswer;
    }

    public void setPigaiAnswer(String pigaiAnswer) {
        this.pigaiAnswer = pigaiAnswer;
    }

    public String getChuqinAnswer() {
        return chuqinAnswer;
    }

    public void setChuqinAnswer(String chuqinAnswer) {
        this.chuqinAnswer = chuqinAnswer;
    }


}
