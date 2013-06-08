package org.go.inq.decoder;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
public class DecryptResult {
    private String text;
    private int countContainedKeywords;
    private int shift;
    private String charset;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCountContainedKeywords() {
        return countContainedKeywords;
    }

    public void setCountContainedKeywords(int countContainedKeywords) {
        this.countContainedKeywords = countContainedKeywords;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}
