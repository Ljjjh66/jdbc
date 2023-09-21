package jdbc;

public class Work {
       private Integer cId;
       private String cName;
       private String  cStuId;
       private String  cPost;
       private String  cGrade;
       private String cCollege;
       private String cEntrytime;


    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcStuId() {
        return cStuId;
    }

    public void setcStuId(String cStuId) {
        this.cStuId = cStuId;
    }

    public String getcPost() {
        return cPost;
    }

    public void setcPost(String cPost) {
        this.cPost = cPost;
    }

    public String getcGrade() {
        return cGrade;
    }

    public void setcGrade(String cGrade) {
        this.cGrade = cGrade;
    }

    public String getC_college() {
        return cCollege;
    }

    public void setC_college(String c_college) {
        this.cCollege = c_college;
    }

    public String getC_entrytime() {
        return cEntrytime;
    }

    public void setC_entrytime(String c_entrytime) {
        this.cEntrytime = c_entrytime;}


    @Override
    public String toString() {
        return "work{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cStuId='" + cStuId + '\'' +
                ", cPost='" + cPost + '\'' +
                ", cGrade='" + cGrade + '\'' +
                ", c_college='" + cCollege + '\'' +
                ", c_entrytime='" + cEntrytime + '\'' +
                '}';
    }

}
