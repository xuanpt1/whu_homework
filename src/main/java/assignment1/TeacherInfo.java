package assignment1;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.util.ArrayList;
import java.util.List;

public class TeacherInfo {
    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("性别")
    private String gender="不详";

    @ExcelProperty("职称")
    @ColumnWidth(10)
    private String jobTitle;

    @ExcelProperty("研究方向")
    @ColumnWidth(50)
    private String researchInterest;

    //表头    public static final String[] exelHead={"姓名","性别","职称","研究方向"};

    /*public static void TeacherInfoWriter(String url, List<TeacherInfo> teacherInfoList) throws Exception{
        //创建新workbook
        FileOutputStream outputStream = new FileOutputStream(url);
        //创建新页
        WritableWorkbook workbook = Workbook.createWorkbook(outputStream);
        //创建新行
        WritableSheet sheet =new workbook.createSheet("whu teacherInfo",0);

        //添加首行内容
        for (int i = 0; i < exelHead.length; i++) {
            jxl.write.Label label = new Label(i,0,exelHead[i]);
            sheet.addCell(label);
        }

        //添加内容
        for (int i = 0; i < teacherInfoList.size(); i++) {
            jxl.write.Label labelName =new Label(0,i+1,teacherInfoList.get(i).getName());
            jxl.write.Label labelGender =new Label(1,i+1,teacherInfoList.get(i).getGender());
            jxl.write.Label labelJobTitle =new Label(2,i+1,teacherInfoList.get(i).getJobTitle());
            jxl.write.Label labelResearchInterest =new Label(3,i+1,teacherInfoList.get(i).getResearchInterest());
            sheet.addCell(labelName);
            sheet.addCell(labelGender);
            sheet.addCell(labelJobTitle);
            sheet.addCell(labelResearchInterest);
        }

        workbook.write();
        workbook.close();
        outputStream.close();

    }*/

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

    public String getName(){
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getResearchInterest() {
        return researchInterest;
    }

    public void showInfo(){
        System.out.println("<"+name+"-"+gender+"-"+jobTitle+"-"+researchInterest+">");
    }
}
