package org.go.inq.decoder;

import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 */
public class TextAnalyzer {
    private static final int MIN_KEYWORD_COUNT = 2;

    public static int containKeyword(String text, List<String> keywordList){
        int count = 0;
        for(String keyword: keywordList){
            if(StringUtils.containsIgnoreCase(text, keyword)) {
                count++;
//                if(count >= MIN_KEYWORD_COUNT){
//                    return true;
//                }
            }
        }
        return count;
    }
}
