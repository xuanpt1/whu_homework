package assignment1;

public class TeacherInfo {
    private String name;
    private String gender;
    private String jobTitle;
    private String researchInterest;

    TeacherInfo(){}
    /*TeacherInfo(String name,String gender,String jobTitle,String researchInterest){
        this.name=name;
        this.gender=gender;
        this.jobTitle=jobTitle;
        this.researchInterest=researchInterest;
    }*/

    public void setName(String name){
        this.name=name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setResearchInterest(String researchInterest) {
        this.researchInterest = researchInterest;
    }

    public void showInfo(){
        System.out.println("<"+name+"-"+gender+"-"+jobTitle+"-"+researchInterest+">");
    }
}
