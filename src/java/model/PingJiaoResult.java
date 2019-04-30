package model;

public class PingJiaoResult {

    private int id;
    private int courseId;
    private String peopleAnswer;
    private String percentAnswer;
    private String peopleNumber;
    private String starNumber;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getPeopleAnswer() {
        return peopleAnswer;
    }

    public void setPeopleAnswer(String peopleAnswer) {
        this.peopleAnswer = peopleAnswer;
    }

    public String getPercentAnswer() {
        return percentAnswer;
    }

    public void setPercentAnswer(String percentAnswer) {
        this.percentAnswer = percentAnswer;
    }

    public String getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(String peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(String starNumber) {
        this.starNumber = starNumber;
    }

}
