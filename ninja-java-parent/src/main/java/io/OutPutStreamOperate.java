package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/4/27
 */
public class OutPutStreamOperate {

    public static void main(String[] args) throws IOException {
        File file = new File("test" + File.separator + "demo.txt");
        //append代表追加
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        String data = "hello world\n";
        fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8), 0, 2);
        fileOutputStream.close();
    }
}
