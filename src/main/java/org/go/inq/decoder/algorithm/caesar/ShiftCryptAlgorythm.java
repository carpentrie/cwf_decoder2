package org.go.inq.decoder.algorithm.caesar;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
public interface ShiftCryptAlgorythm {
    public String decrypt(String text, int shift);
    public String encrypt(String text, int shift);
}
