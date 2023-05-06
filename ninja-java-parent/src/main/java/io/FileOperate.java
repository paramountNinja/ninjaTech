package io;

import java.io.File;
import java.io.IOException;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2022/4/27
 */
public class FileOperate {

    public static void main(String[] args) throws IOException {
        //File.separator根据操作系统自动识别路径分隔符
        File file = new File("test" + File.separator + "demo.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.createNewFile();
        }
    }
}
