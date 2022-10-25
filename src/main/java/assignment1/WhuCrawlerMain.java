package assignment1;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xionG
 */




public class WhuCrawlerMain implements PageProcessor {

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
            List<String> jobTitleLinks=page.getHtml().xpath("//div[@class='info']").links().all();
            //获取所有职称的页面url
            page.addTargetRequests(jobTitleLinks);
            System.out.println(jobTitleLinks.size());
            getLinksRight=true;
        }else {
            //开始提取每个页面中的有效信息
            System.out.println("in process");


            }
        List<String> name = page.getHtml().xpath("//div[@class='teacher_zc_list']//tr[@class!='headrow']/td[@class='w1']/a/text()").all();
        if(name.isEmpty()){return;}
        List<String> gender = page.getHtml().xpath("//div[@class='teacher_zc_list']//tr[@class!='headrow']/td[@class='w2']/text()").all();
        List<String> jobTitle = page.getHtml().xpath("//div[@class='teacher_zc_list']//tr[@class!='headrow']/td[@class='w4']/text()").all();
        List<String> researchInterest = page.getHtml().xpath("//div[@class='teacher_zc_list']//tr[@class!='headrow']/td[@class='w5']/text()").all();

            /*System.out.println("size of name "+name.size());
            System.out.println("size of gend "+gender.size());
            System.out.println("size of jobT "+jobTitle.size());
            System.out.println("size of rese "+researchInterest.size());*/

        for (int i = 0; i < name.size(); i++) {
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setName(name.get(i));
            teacherInfo.setGender(gender.get(i));
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

        Spider.create(new WhuCrawlerMain()).addUrl("http://cs.whu.edu.cn/teacher.aspx?showtype=jobtitle&typename=%e6%95%99%e6%8e%88").addPipeline(new ConsolePipeline()).thread(8).run();
//        System.out.println("info size "+teacherInfoList.size());

        /*for (TeacherInfo info: teacherInfoList
             ) {
            info.showInfo();
        }*/


        //excel文件路径
        String excelPath = "whuInfo.xlsx";
        EasyExcel.write(excelPath, TeacherInfo.class).sheet("test").doWrite(teacherInfoList);

        ResearchInterests.analysisResearchInterests(teacherInfoList);



        /*for (SimplifiedInfo s:simplifiedInfoList
             ) {
            s.showInfo();
        }*/

        /*String exelPath="whuTeacherInfo.xlsx";
        try {
            TeacherInfo.TeacherInfoWriter(exelPath,teacherInfoList);
        }catch (Exception e){
            e.printStackTrace();
        }*/


    }


}
