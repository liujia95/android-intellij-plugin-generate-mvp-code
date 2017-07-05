package me.liujia95.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class FileUtils {

    /**
     * 写入文件
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @param content 文件内容
     */
    public static void writeToFile(String filePath,String fileName, String content) {
        try {
            File file = new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
            FileWriter fw = new FileWriter(new File(filePath+fileName), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
