package org.apache.mycat.advisor.common.net.http;

/**
 * Created by cjl on 2016/3/11.
 */
public class StringSeriesTools {
    public static String replaceAllMatch(String content, String s, String s1) {
        return content.replaceAll(s,s1);
    }
}
