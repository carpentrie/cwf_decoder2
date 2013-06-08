package org.go.inq.decoder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.go.inq.decoder.algorithm.UnicodeShifter;

import javax.swing.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
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
    private String outputDirectory = System.getProperty("user.dir") + File.separator;
    private String keywords;

    private String FAKE_FILE = "inq_picture_list.txt";
    private String KEYWORDS_FILE = "keywords.txt";

    private static final String[] CHARSET_LIST = new String[]{Const.CHARSET_UTF8, Const.CHARSET_CP1251, Const.CHARSET_ISO_8859_1};

    public Decoder(){
        this.keywords = initKeywords();
    }

    public Decoder(String inputFile){
        this.inputFile = inputFile;
        this.keywords = initKeywords();
    }

    private String initKeywords(){
        File keywordFile = new File(outputDirectory+KEYWORDS_FILE);
        if(!keywordFile.exists()){
            return Const.DEFAULT_KEYWORD_LIST;
        }
        String keywords = FileManager.readFile(keywordFile.getAbsolutePath(), Const.CHARSET_UTF8);
        keywords = keywords.trim();
        return keywords;
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

    public DecryptResult decrypt(){
        FileManager.copy(inputFile, outputDirectory+"copy_original.txt");

        List<String> keywordList = getKeywordList();

        DecryptResult result = new DecryptResult();
        result.setCountContainedKeywords(0); // forced init

        for(String charset: CHARSET_LIST){
            String fileBody = FileManager.readFile(inputFile, charset);

            for (int i=-Const.MAX_CHAR_SHIFT; i < Const.MAX_CHAR_SHIFT; i++){
                String decrypted = UnicodeShifter.decrypt(fileBody, i);
                int countContainedKeywords = TextAnalyzer.containKeyword(decrypted, keywordList);

                if( countContainedKeywords > 0) {
                    if(result.getCountContainedKeywords() < countContainedKeywords){
                        result.setText(decrypted);
                        result.setShift(i);
                        result.setCharset(charset);
                        result.setCountContainedKeywords(countContainedKeywords);
                    }

                    FileManager.writeFile(decrypted, outputDirectory+"decrypted_"+i+"_"+charset+".txt", Const.CHARSET_UTF8);
                }


                if(!Const.CHARSET_UTF8.equals(charset)){
                    // and do the same but for variant converted back to original charset
                    decrypted = convertString(decrypted, charset);

                    countContainedKeywords = TextAnalyzer.containKeyword(decrypted, keywordList);

                    if( countContainedKeywords > 0) {
                        if(result.getCountContainedKeywords() < countContainedKeywords){
                            result.setText(decrypted);
                            result.setShift(i);
                            result.setCharset(charset);
                            result.setCountContainedKeywords(countContainedKeywords);
                        }

                        FileManager.writeFile(decrypted, outputDirectory+"decrypted_"+i+"_"+charset+"_converted.txt", Const.CHARSET_UTF8);
                    }
                }
            }
        }
        if(StringUtils.isNotEmpty(result.getText())){
            encryptFakeFile(result.getShift(), result.getCharset());
        }
        return result;
    }

    private void encrypt(String fileBody, String fileName, int shift, String charset){
        String encoded = UnicodeShifter.encrypt(fileBody, shift);
        FileManager.writeFile(encoded, outputDirectory + "encrypted_" + fileName + shift + "_" + charset + ".txt",charset);
    }

    private void encryptFakeFile(int shift, String charset){
        // read with utf8 since it is our file, we know its charset
        File fakeFile = new File(outputDirectory+FAKE_FILE);
        if(!fakeFile.exists()){
            return;
        }

        String fileBody = FileManager.readFile(fakeFile.getAbsolutePath(), Const.CHARSET_UTF8);
        encrypt(fileBody, "fake", shift, charset);
    }

    private String convertString(String string, String charset){
        try {
            return new String(string.getBytes(Const.CHARSET_UTF8), charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> getKeywordList(){
        return Arrays.asList(StringUtils.split(Const.DEFAULT_KEYWORD_LIST, Const.COMMA));
    }


    public static void main(String[] args){
//        Decoder decoder = new Decoder();
//        decoder.setInputFile(decoder.getOutputDirectory() + "список.txt");

//        decoder.encrypt(decoder.getInputFile(), 3, Const.CHARSET_UTF8);
//        decoder.encrypt(decoder.getInputFile(), -17, Const.CHARSET_UTF8);

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
