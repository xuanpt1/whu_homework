package assignment1;

import com.alibaba.excel.EasyExcel;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class TongJiCrawlerMain implements PageProcessor {
    //暂存抓取到的教师信息
    public static List<TeacherInfo> teacherInfoList=new ArrayList<>();

    /**抓取网站的相关配置,可包含：编码、抓取间隔、重试次数等*/
    private Site site = Site.me();

    /**
     * 解析页面
     */
    @Override
    public Site getSite() {
        return site;
    }


    List<String> teacherHomePages = new ArrayList<>();
    private int index=0;
    private final int maxIndex = 5;
    @Override
    public void process(Page page) {
        //编写抽取逻辑
        if(page.getUrl().regex("https://see\\.tongji\\.edu\\.cn/info/1285/.+\\.htm").match()){
            System.out.println("in process");
            String name = page.getHtml().xpath("//table[@class='jstab']//tr[1]/td[2]/text()").toString();
            //String gender = page.getHtml().xpath("//table[@class='jstab']//tr[2]/td[2]/text()").toString();
            String jobTitle = page.getHtml().xpath("//table[@class='jstab']//tr[2]/td[2]/text()").toString();
            String researchInterest = page.getHtml().xpath("//table[@class='jstab']//tr[5]/td[2]/text()").toString();

            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setName(name);
            //teacherInfo.setGender(gender);
            teacherInfo.setJobTitle(jobTitle);
            teacherInfo.setResearchInterest(researchInterest);
            teacherInfoList.add(teacherInfo);

        }else {
            System.out.println("ok");
            List<String> linksOfThisPage = page.getHtml().xpath("//div[@class='Pic1']//li/a").links().all();
            System.out.println(page.getHtml().xpath("//a[@class='Next']").links().toString());
            page.addTargetRequests(page.getHtml().xpath("//a[@class='Next']").links().all());
            teacherHomePages.addAll(linksOfThisPage);
            index++;
            System.out.println(teacherHomePages.size());
            if(index==maxIndex){
                page.addTargetRequests(teacherHomePages);
            }
            //if(page.getHtml().xpath("//a[@class='Next']").links().all().isEmpty()){page.addTargetRequests(teacherHomePages);}

        }

        /*if(index>0){
            System.out.println("ok");
            //获取所有职称的页面url
            List<String> linksOfThisPage = page.getHtml().xpath("//div[@class='Pic1']//li/a").links().all();
            teacherHomePages.addAll(linksOfThisPage);
            page.addTargetRequest("https://see.tongji.edu.cn/szdw/dsmd/axkhf/jsjkxyjsxk/"+index+".htm");
            index--;
            System.out.println(teacherHomePages.size());
        }else {
            //开始提取每个页面中的有效信息
            System.out.println("in process");
            getAllLinks=true;
            page.addTargetRequests(teacherHomePages);
        }*/


    }

    /*public static void writeToExcel(String excelPath, List<TeacherInfo> teacherInfoList){
        ExcelWriterBuilder writerBuilder = EasyExcel.write(excelPath,TeacherInfo.class);
        ExcelWriterSheetBuilder writerSheetBuilder = writerBuilder.sheet();
        writerSheetBuilder.doWrite(teacherInfoList);
    }*/

    public static void main(String[] args) {

        Spider.create(new TongJiCrawlerMain()).addUrl("https://see.tongji.edu.cn/szdw/dsmd/axkhf/jsjkxyjsxk.htm").addPipeline(new ConsolePipeline()).thread(8).run();
//        System.out.println("info size "+teacherInfoList.size());

        /*for (TeacherInfo info: teacherInfoList
             ) {
            info.showInfo();
        }*/

        //excel文件路径
        String excelPath = "tongjiInfo.xlsx";
        EasyExcel.write(excelPath, TeacherInfo.class).sheet("test").doWrite(teacherInfoList);

        ResearchInterests.analysisResearchInterests(teacherInfoList);

        /*String exelPath="whuTeacherInfo.xlsx";
        try {
            TeacherInfo.TeacherInfoWriter(exelPath,teacherInfoList);
        }catch (Exception e){
            e.printStackTrace();
        }*/


    }

}
