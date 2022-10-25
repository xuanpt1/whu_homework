package assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimplifiedInfo {
    public String name;
    public List<String> interests=new ArrayList<>();
    SimplifiedInfo(TeacherInfo t,String[] tempList){
        name=t.getName();
        interests.addAll(Arrays.asList(tempList));
    }
    public void showInfo(){
        System.out.println(name);
        System.out.println(interests);
    }
}
