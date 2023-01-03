package lab2.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SkipWhitespaceOutputStream extends FilterOutputStream {

    //定向输出
    public SkipWhitespaceOutputStream(OutputStream out){
        super(out);
    }


    //重写write，改变输出结果
    @Override
    public void write(byte[] source) throws IOException {
        byte[] result;
        String str = new String(source);
        String replaced = str.replace(" ","");
        result = replaced.getBytes();
        super.write(result);
    }
}
