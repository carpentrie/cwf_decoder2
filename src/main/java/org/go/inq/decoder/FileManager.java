package org.go.inq.decoder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public class FileManager {


    public static String readFile(String filePath, String charset){
        try {
            return FileUtils.readFileToString(new File(filePath), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(String fileContent, String filePath, String charset){
        try {
            FileUtils.writeStringToFile(new File(filePath), fileContent, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(String from, String to){
        try {
            FileUtils.copyFile(new File(from), new File(to));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testFiles(){
        String basePath = "/home/nanomonk/dev/workspace/cwf/";
        String cp1251 = "text_cp1251.txt";
        String utf8 = "text_utf8.txt";
        String result = "result_";


        writeFile(readFile(basePath+cp1251, Const.CHARSET_CP1251), basePath+result+cp1251, Const.CHARSET_CP1251);
        writeFile(readFile(basePath+utf8, Const.CHARSET_UTF8), basePath+result+utf8, Const.CHARSET_UTF8);
    }
}
