package org.go.inq.decoder.algorithm.caesar;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class Caesar implements ShiftCryptAlgorythm {
    private String alphabet;      // Алфавит, заданный пользователем

    /**
     * Конструктор класса
     * @param alphabet Алфавит шифрования
     */
    public Caesar(String alphabet){
        this.alphabet=alphabet;
    }

    /**
     * Метод Цезаря шифрование текста
     * @param text Исходный текст
     * @param position Количество позиций для сдвига
     * @return Зашифрованный текст
     */
    @Override
    public String encrypt(String text, int position){
        String cipher ="";
        for(int i=0;i<text.length();i++){
            cipher+=alphabet.charAt((alphabet.indexOf(text.charAt(i))+position)%alphabet.length());
        }
        return cipher;
    }

    /**
     * Метод Цезаря де шифрование текста
     * @param cipher Зашифрованный текст
     * @param position Количество позиций для сдвига
     * @return Исходный текст
     */
    @Override
    public String decrypt(String cipher, int position){
        String text ="";
        for(int i=0;i<cipher.length();i++){
            if(alphabet.indexOf(cipher.charAt(i))-position<0){
                text+=alphabet.charAt(alphabet.length() - 1 +
                        (alphabet.indexOf(cipher.charAt(i))-position + 1)%alphabet.length());
            }else{
                text+=alphabet.charAt((alphabet.indexOf(cipher.charAt(i))-position)%alphabet.length());
            }
        }
        return text;
    }
}
