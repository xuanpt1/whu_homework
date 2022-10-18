package assignment1;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xionG
 */
public class WhuCrawlerPre implements PageProcessor {

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
            }
            //System.out.println("size of everytime"+teacherInfoList.size());
        }


    }

    public static void main(String[] args) {

        Spider.create(new WhuCrawlerPre()).addUrl("http://cs.whu.edu.cn/teacher.aspx?showtype=jobtitle&typename=%e6%95%99%e6%8e%88").addPipeline(new ConsolePipeline()).run();
//        System.out.println("info size "+teacherInfoList.size());

        for (TeacherInfo info: teacherInfoList
             ) {
            info.showInfo();
        }
    }


}
