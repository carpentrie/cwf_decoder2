package org.go.inq.decoder.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 19:31
 * To change this template use File | Settings | File Templates.
 */
public class UnicodeShifter {
    public static String encrypt(String text, int shift){
        StringBuilder sb = new StringBuilder();
        for(char c: text.toCharArray()){
            sb.append((char)(c+shift));  // +
        }
        return sb.toString();
    }

    public static String decrypt(String text, int shift){
        StringBuilder sb = new StringBuilder();
        for(char c: text.toCharArray()){
            sb.append((char)(c-shift));  // -
        }
        return sb.toString();
    }
}
