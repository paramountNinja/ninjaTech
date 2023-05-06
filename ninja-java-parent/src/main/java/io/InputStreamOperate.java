package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/4/27
 */
public class InputStreamOperate {

    public static void main(String[] args) throws IOException {
        File file = new File("test" + File.separator + "demo.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //System.out.println((char) fileInputStream.read());
        //System.out.println((char) fileInputStream.read());

        byte[] data = new byte[1024];
        System.out.println(fileInputStream.read(data));
        System.out.println(new String(data));
    }
}
