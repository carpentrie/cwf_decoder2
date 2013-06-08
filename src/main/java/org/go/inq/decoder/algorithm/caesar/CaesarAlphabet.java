package org.go.inq.decoder.algorithm.caesar;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class CaesarAlphabet {
    /**
     * Метод, возвращающий алфавит заглавных
     * английских букв
     * @return Алфавит заглавных английских букв
     */
    public static String getEnglishU(){
        StringBuilder alphabet = new StringBuilder("");
        for(char ch='A';ch<='Z';ch++){
            alphabet.append(ch);
        }
        return alphabet.toString();
    }

    /**
     * Метод, возвращающий алфавит строчных
     * английских букв
     * @return Алфавит строчных английских букв
     */
    public static String getEnglishL(){
        StringBuilder alphabet = new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            alphabet.append(ch);
        }
        return alphabet.toString();
    }

    /**
     * Метод, возвращающий алфавит заглавных
     * русских букв
     * @return Алфавит заглавных русских букв
     */
    public static String getRussianU(){
        StringBuilder alphabet = new StringBuilder("");
        for(char ch='А';ch<='Я';ch++){
            alphabet.append(ch);
        }
        return alphabet.toString();
    }

    /**
     * Метод, возвращающий алфавит строчных
     * русских букв
     * @return алфавит строчных русских букв
     */
    public static String getRussianL(){
        StringBuilder alphabet = new StringBuilder("");
        for(char ch='а';ch<='я';ch++){
            alphabet.append(ch);
        }
        return alphabet.toString();
    }

    /**
     * Метод, возвращающий строку цифр
     * @return строку цифр
     */
    public static String getNumbers(){
        StringBuilder alphabet = new StringBuilder("");
        for(char ch='0';ch<='9';ch++){
            alphabet.append(ch);
        }
        return alphabet.toString();
    }

    /**
     * Метод, возвращающий скобки и знаки препинания
     * @return строка скобок и знаков препинания
     */
    public static String getSpecialCharacters(){
        StringBuilder alphabet = new StringBuilder("");
        for(char ch=' ';ch<='/';ch++){
            alphabet.append(ch);
        }
        for(char ch=':';ch<='?';ch++){
            alphabet.append(ch);
        }
        return alphabet.toString();
    }

    /**
     * Метод, возвращает набор всех возможных символов
     * @return строка всех символов
     */
    public static String getEverything(){
        StringBuilder alphabet = new StringBuilder("");
        alphabet.append(CaesarAlphabet.getRussianL());
        alphabet.append(CaesarAlphabet.getRussianU());
        alphabet.append(CaesarAlphabet.getEnglishL());
        alphabet.append(CaesarAlphabet.getEnglishU());
        alphabet.append(CaesarAlphabet.getNumbers());
        alphabet.append(CaesarAlphabet.getSpecialCharacters());
        return alphabet.toString();
    }

    public static String getEnglish(){
        StringBuilder alphabet = new StringBuilder("");
        alphabet.append(CaesarAlphabet.getEnglishL());
        alphabet.append(CaesarAlphabet.getEnglishU());
        alphabet.append(CaesarAlphabet.getNumbers());
        alphabet.append(CaesarAlphabet.getSpecialCharacters());
        return alphabet.toString();
    }

    public static String getRussian(){
        StringBuilder alphabet = new StringBuilder("");
        alphabet.append(CaesarAlphabet.getRussianL());
        alphabet.append(CaesarAlphabet.getRussianU());
        alphabet.append(CaesarAlphabet.getNumbers());
        alphabet.append(CaesarAlphabet.getSpecialCharacters());
        return alphabet.toString();
    }
}
