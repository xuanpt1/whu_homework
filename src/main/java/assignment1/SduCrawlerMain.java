package assignment1;

import com.alibaba.excel.EasyExcel;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class SduCrawlerMain implements PageProcessor {
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

    /**
     * 仅在process()中更改一次
     * 用于判断是否获取了所有职称的页面
     */
    boolean getLinksRight=false;

    @Override
    public void process(Page page) {
        //编写抽取逻辑
        if(!getLinksRight){
            List<String> jobTitleLinks=page.getHtml().xpath("//ul[@class='lbhz']").links().all();
            //获取所有职称的页面url
            page.addTargetRequests(jobTitleLinks);
            System.out.println(jobTitleLinks.size());
            getLinksRight=true;
        }else {
            //开始提取每个页面中的有效信息
            System.out.println("in process");


        }
        List<String> name = page.getHtml().xpath("//div[@class=\"table-responsive\"]//tr/td[1]/a/text()").all();
        if(name.isEmpty()){return;}
        List<String> jobTitle = page.getHtml().xpath("//div[@class=\"table-responsive\"]//tr/td[2]/a/text()").all();
        List<String> researchInterest = page.getHtml().xpath("//div[@class=\"table-responsive\"]//tr/td[3]/a/text()").all();

            /*System.out.println("size of name "+name.size());
            System.out.println("size of gend "+gender.size());
            System.out.println("size of jobT "+jobTitle.size());
            System.out.println("size of rese "+researchInterest.size());*/

        for (int i = 0; i < name.size(); i++) {
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setName(name.get(i));
            teacherInfo.setJobTitle(jobTitle.get(i));
            teacherInfo.setResearchInterest(researchInterest.get(i));
            teacherInfoList.add(teacherInfo);
            //System.out.println("add successful");
            //System.out.println("size of everytime"+teacherInfoList.size());
        }


    }

    /*public static void writeToExcel(String excelPath, List<TeacherInfo> teacherInfoList){
        ExcelWriterBuilder writerBuilder = EasyExcel.write(excelPath,TeacherInfo.class);
        ExcelWriterSheetBuilder writerSheetBuilder = writerBuilder.sheet();
        writerSheetBuilder.doWrite(teacherInfoList);
    }*/

    public static void main(String[] args) {

        Spider.create(new SduCrawlerMain()).addUrl("https://www.cs.sdu.edu.cn/szdw1/js.htm").addPipeline(new ConsolePipeline()).run();
//        System.out.println("info size "+teacherInfoList.size());

        /*for (TeacherInfo info: teacherInfoList
             ) {
            info.showInfo();
        }*/

        //excel文件路径
        String excelPath = "sduInfo.xlsx";
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
