package assignment1;

import java.util.ArrayList;
import java.util.List;

public class ResearchInterests {
    public String name;
    public int count;
    public List<SimplifiedInfo> teachers=new ArrayList<>();
    public static List<String> allTheInterests=new ArrayList<>();

    ResearchInterests(String name,SimplifiedInfo teacherInfo){
        this.name=name;
        count=1;
        teachers.add(teacherInfo);
        allTheInterests.add(name);
    }

    public void showInfo(){
        System.out.println("name: "+name);
        System.out.println("count: "+count);
        System.out.println("teacher: ");
        System.out.print("<");
        for (SimplifiedInfo s:teachers
        ) {
            System.out.print(s.name+" ");
        }
        System.out.println(">\n");
    }

    public static void analysisResearchInterests(List<TeacherInfo> teacherInfoList){
        List<SimplifiedInfo> simplifiedInfoList=new ArrayList<>();
        for (TeacherInfo t: teacherInfoList
        ) {
            if(!t.getResearchInterest().isEmpty()){
                String tempString = t.getResearchInterest().replace("。",",").replace("，",",").replace("、",",").replace("•",",").replace("；",",").replace(";",",");
                String[] tempList=tempString.split(",");
                simplifiedInfoList.add(new SimplifiedInfo(t,tempList));
            }
        }

        List<ResearchInterests> researchInterestsList=new ArrayList<>();
        for (SimplifiedInfo si : simplifiedInfoList
        ) {
            if(researchInterestsList.isEmpty()){
                for (String s:si.interests
                ) {
                    System.out.println("ini" + researchInterestsList.size());
                    researchInterestsList.add(new ResearchInterests(s,si));
                }
            }else {
                for (String s: si.interests
                ) {
                    boolean neverExist=true;
                    for (int i=0;i<researchInterestsList.size();i++) {
                        if (researchInterestsList.get(i).name.equals(s)){
                            researchInterestsList.get(i).count++;
                            researchInterestsList.get(i).teachers.add(si);
                            neverExist=false;
                            break;
                        }
                    }
                    if(neverExist){
                        researchInterestsList.add(new ResearchInterests(s,si));
                    }
                }
            }
        }

        for (ResearchInterests r:researchInterestsList
        ) {
            r.showInfo();
        }
    }
}
