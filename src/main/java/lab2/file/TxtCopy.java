package lab2.file;

import java.io.*;
import java.nio.file.Files;

public class TxtCopy {

    private static void copy(String name, String pathOld, String pathNew) throws IOException {
        File oldPaths = new File(pathOld + "/" + name);
        File newPaths = new File(pathNew + "/" + name);

        //定向输出
        if(newPaths.exists()){
            if(newPaths.delete()){
                Files.copy(oldPaths.toPath(),newPaths.toPath());
            }
        }else {
            Files.copy(oldPaths.toPath(),newPaths.toPath());
        }

        String newFile = "";
        newFile += newPaths.toPath();

        FileReader r = new FileReader(oldPaths);
        FileWriter w = new FileWriter(newPaths);
        File file = new File(newFile);

        if (!file.exists()){
            file.createNewFile();
        }

        //遍历拷贝文件内容
        char[] buffer = new char[1024];
        int i;
        while ((i = r.read(buffer)) != -1){
            for (int j = 0; j < i; j++) {
                w.write(buffer[j]);
            }
        }
        r.close();
        w.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:/javaLabSource");
        String extendedName = ".txt";
        String pathOld = "D:/javaLabSource";
        String pathNew = "D:/tmp";

        String[] fileList = file.list();

        System.out.println("开始复制");
        if(fileList != null){
            for (String s: fileList
                 ) {
                if(s.endsWith(extendedName)){
                    copy(s,pathOld,pathNew);
                }
            }
        }
        System.out.println("复制完成");
    }

}
