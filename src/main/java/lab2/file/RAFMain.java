package lab2.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RAFMain {
    public static void main(String[] args) throws IOException {

        String filePath = "D:/javaLabSource/readme.txt";
        RandomAccessFile raf = null;
        File file = new File(filePath);
        if(file.exists()) file.delete();

        String line1 = "第一行内容 \n";
        String line2 = "第二行内容 \n";
        String line3 = "Shut the f**k up Niko";
        long pos = 0;

        raf = new RandomAccessFile(file,"rw");
        raf.write(line1.getBytes());
        pos = raf.length();
        raf.write(line2.getBytes());

        raf.seek(pos);
        String s = new String(raf.readLine().getBytes("ISO-8859-1"),StandardCharsets.UTF_8);
        //中文需要转换编码格式
        System.out.println(s);

        raf.seek(raf.length());
        raf.write(line3.getBytes());

        raf.close();
    }
}
