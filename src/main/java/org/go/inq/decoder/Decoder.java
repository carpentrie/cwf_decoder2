package org.go.inq.decoder;

import org.apache.commons.io.FileUtils;
import org.go.inq.decoder.algorithm.caesar.Caesar;
import org.go.inq.decoder.algorithm.caesar.CaesarAlphabet;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

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

    public Decoder(){

    }

    public Decoder(String inputFile, String outputDirectory){
        this.inputFile = inputFile;
        this.outputDirectory = outputDirectory;
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

    public void testCaesar(int charShift){
        Caesar algo = new Caesar(CaesarAlphabet.getEverything());
        String decrypted = algo.getDecryption(FileManager.readFile(inputFile, FileManager.CHARSET_UTF8), charShift);
        String encrypted = algo.getEncryption(decrypted, charShift);

        FileManager.writeFile(decrypted, outputDirectory+"/decrypted"+charShift+".txt", FileManager.CHARSET_UTF8);
        FileManager.writeFile(encrypted, outputDirectory+"/encrypted"+charShift+".txt", FileManager.CHARSET_UTF8);
    }



    public static void main(String[] args){

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
