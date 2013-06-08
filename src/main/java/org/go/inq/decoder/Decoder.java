package org.go.inq.decoder;

import org.apache.commons.lang.StringUtils;
import org.go.inq.decoder.algorithm.caesar.Caesar;
import org.go.inq.decoder.algorithm.caesar.CaesarAlphabet;
import org.go.inq.decoder.algorithm.caesar.ShiftCryptAlgorythm;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 9:57
 * To change this template use File | Settings | File Templates.
 */
public class Decoder {
    private String inputFile;
    private String outputDirectory;
    private String keywords;

    private static final String[] CHARSET_LIST = new String[]{Const.CHARSET_UTF8, Const.CHARSET_CP1251};
    public Decoder(){

    }

    public Decoder(String inputFile, String outputDirectory, String keywords){
        this.inputFile = inputFile;
        this.outputDirectory = outputDirectory;
        this.keywords = keywords;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void testCaesar(int charShift){
        Caesar algo = new Caesar(CaesarAlphabet.getEverything());
        String decrypted = algo.decrypt(FileManager.readFile(inputFile, Const.CHARSET_UTF8), charShift);
        String encrypted = algo.encrypt(decrypted, charShift);

        FileManager.writeFile(decrypted, outputDirectory+"/decrypted_"+charShift+".txt", Const.CHARSET_UTF8);
        FileManager.writeFile(encrypted, outputDirectory+"/encrypted_"+charShift+".txt", Const.CHARSET_UTF8);
    }

    public void tryDecrypt(){
        List<String> keywordList = getKeywordList(keywords);
        Caesar algorythm = new Caesar(CaesarAlphabet.getEverything());

        for(String charset: CHARSET_LIST){
            String fileBody = FileManager.readFile(inputFile, charset);

            for (int i=1; i<Const.MAX_CHAR_SHIFT; i++){
                String decrypted = algorythm.decrypt(fileBody, i);
                if(TextAnalyzer.containKeyword(decrypted, keywordList)) {
                    FileManager.writeFile(decrypted, outputDirectory+File.separator+"decrypted_"+i+".txt", Const.CHARSET_UTF8);
                }
            }
        }
    }

    private List<String> getKeywordList(String keywords){
        return Arrays.asList(StringUtils.split(StringUtils.isNotEmpty(keywords)? keywords : Const.DEFAULT_KEYWORD_LIST, Const.COMMA));
    }


    public static void main(String[] args){
        String outputDirectory = "D:\\go";
        Caesar algorythm = new Caesar(CaesarAlphabet.getEverything());
        int charShift = 5;

        String encrypted = algorythm.encrypt(FileManager.readFile(outputDirectory + File.separator + "origin_utf8.txt", Const.CHARSET_UTF8), charShift );

        FileManager.writeFile(encrypted, outputDirectory+File.separator + "encrypted_"+charShift+".txt", Const.CHARSET_UTF8);
        runWindow();
    }

    public static void runWindow(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);

                //Create and set up the window.
                JFrame frame = new JFrame("CWF Decoder");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new DecoderForm());

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
