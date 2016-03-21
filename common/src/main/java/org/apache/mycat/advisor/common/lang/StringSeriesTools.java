/*
        Copyright  DR.YangLong

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.apache.mycat.advisor.common.lang;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * functional describe:字符串相关工具类
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0 2015/5/13 20:04 modify on 2015-7-1 add email,phone verify and object equals method
 */
public class StringSeriesTools {
    // 将数字转化为汉字的数组,因为各个实例都要使用所以设为静态
    private static char[] numStr = new char[]{'零','一','二', '三', '四', '五', '六', '七', '八', '九'};
    // 供分级转化的数组,因为各个实例都要使用所以设为静态
    private static char[] unit = new char[]{' ','十','百','千','万','十'};

    /**
     * 根据所给的源字符串和正则表达式，查找匹配的字符串并返回
     *
     * @param sourceStr 源字符串
     * @param regex     正则表达式
     * @return 匹配的字符串
     */
    public static List<String> findString(final String sourceStr, final String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sourceStr);
        List<String> list = new ArrayList<String>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    /**
     * 替换源字符串中符合表达式的字符串
     *
     * @param sourceStr   原串
     * @param regex       正则
     * @param replacement 要替换成的目标字符串
     * @return
     */
    public static String replaceAllMatch(final String sourceStr, final String regex, final String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sourceStr);
        String source = matcher.replaceAll(replacement);
        return source;
    }

    /**
     * 无符号整数
     *
     * @param numString String
     * @return int
     */
    public static int string2Int(final String numString) {
        if (StringUtils.isNumeric(numString)) {
            return Integer.valueOf(numString);
        }
        return 0;
    }

    /**
     * 输入无符号整数，不是返回0
     *
     * @param numString String
     * @return long
     */
    public static long string2Long(final String numString) {
        if (StringUtils.isNumeric(numString)) {
            return Long.valueOf(numString);
        }
        return 0;
    }

    /**
     * 转double,如果不是数字字符串，将返回0,默认格式0.00
     *
     * @param numString 字符串
     * @param pattern   格式化正则表达式
     * @return double
     */
    public static double string2double(final String numString, final String pattern) {
        try {
            double num = Double.parseDouble(numString);
            String defalutPattern = pattern == null ? "0.00" : pattern;
            DecimalFormat decimalFormat = new DecimalFormat(defalutPattern);
            num = Double.parseDouble(decimalFormat.format(num));
            return num;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 将字符转化为int
     * 主要利用ASCII中0对应数值48来转换,
     * 注意char和char运算的结果是int类型的
     * int x = '6' - '0';x=6
     * char s = 6 + '0';s='6'
     *
     * @param ch 字符
     * @return
     */
    public static int char2num(char ch) {
        return ch - '0';
    }

    /**
     * 字符串整数部分转换为double类型，10的n次幂：100=10^2
     *
     * @param str 整数字符串
     * @return
     */
    public static double intStr2double(final String str) throws NumberFormatException {
        char[] strs = str.toCharArray();
        double result = 0;
        for (int i = 0;i < strs.length;i++) {
            double n = char2num(strs[i]);
            result += n * (Math.pow(10, i));
        }
        return result;
    }

    /**
     * 字符串小数部分转换为double类型，0.1的n次幂：0.01=0.1^2
     *
     * @param str 小数字符串
     * @return
     */
    public static double dotStr2dot(final String str) throws NumberFormatException {
        char[] strs = str.toCharArray();
        double
                result = 0;
        for (int i = 0; i < strs.length; i++) {
            double n = char2num(strs[i]);
            result += n * (Math.pow(1 / 10.0, i + 1));
        }
        return result;
    }

    /**
     * 字符串转换为double
     *
     * @return
     */
    public static double str2double(final String str) throws NumberFormatException {
        if ("".equals(str) || str.isEmpty()) {
            throw new NumberFormatException("字符串为空或NULL或不是数字！");
        }
        int dotIndex = str.indexOf(".");
        if (dotIndex <= 0) {
            return intStr2double(str);
        } else {
            String intStr = str.substring(0, dotIndex);
            String dotStr = str.substring(dotIndex + 1, str.length());
            return intStr2double(intStr) + dotStr2dot(dotStr);
        }
    }

    /**
     * 取n个随机数
     *
     * @param n    in<字符数组长度
     * @param type 类型，1混合，2纯数字，3纯字母
     * @return String
     */
    public static String getRanDomStr(final int n, final int type) {
        String[] charset;
        String[] charsetAll = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
                "4", "5", "6", "7", "8", "9"};
        String[] charsetNum = {"0", "1", "2", "3",
                "4", "5", "6", "7", "8", "9"};
        String[] charsetChar = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        switch (type) {
            case 1:
                charset = charsetAll;
                break;
            case 2:
                charset = charsetNum;
                break;
            case 3:
                charset = charsetChar;
                break;
            default:
                charset = charsetAll;
        }
        Random random = new Random();
        String[] nonces = new String[n];
        //选择数的范围
        List<String> choose = new ArrayList<String>(charset.length);
        //取随机数
        Collections.addAll(choose, charset);
        int nl = n;
        while (nl-- > 0) {
            int k = random.nextInt(choose.size());
            nonces[nl] = choose.get(k);
            choose.remove(k);
        }
        //将数组转换为str
        String nonce = "";
        for (String str : nonces) {
            nonce += str;
        }
        return nonce;
    }

    /**
     * 随机产生六位数
     *
     * @return
     */
    public static String getNumber6FromRandom() {
        Random r = new Random();
        int xx = r.nextInt(1000000);
        while (xx < 100000) {
            xx = r.nextInt(1000000);
        }
        return String.valueOf(xx);
    }

    /**
     * @param num 整型数
     * @return
     * @description 取得中文数
     */
    public static String getCnNumber(int num) {
        if (num < 0) {//不处理负数
            return null;
        }
        String strNum = new Integer(num).toString();
        // 转换
        StringBuffer newStr = new StringBuffer("");
        for (int i = strNum.length() - 1; i >= 0; i--) {
            int index = Integer.parseInt(String.valueOf(strNum.charAt(strNum.length() - i - 1)));
            newStr.append(numStr[index]).append(unit[i]);
        }
        String result = newStr.toString().replaceAll("零万", "万").
                replaceAll("零千", "零").
                replaceAll("零百", "零").
                replaceFirst("零十", "零").
                replaceAll("零+", "零").replaceFirst("一十", "十").trim();
        // 判断最后一位是否为零，如果是则去掉
        if (result.endsWith("零")) {
            result = result.substring(0, newStr.length() - 1);
        }
        return result;
    }

    /**
     * @param strNum 字符串型阿拉伯数字
     * @return
     * @description 取得中文数
     */
    public static String getCnNumber(String strNum) {
        if (strNum.indexOf("-") == 0) {//不处理负数
            return null;
        }
        // 转换
        StringBuffer newStr = new StringBuffer("");
        if (strNum.indexOf(".") != -1) {//不处理小数
            strNum = strNum.substring(0, strNum.indexOf(".")).trim();
        } else {
            strNum = strNum.trim();
        }
        for (int i = strNum.length() - 1; i >= 0; i--) {
            int index = Integer.parseInt(String.valueOf(strNum.charAt(strNum.length() - i - 1)));
            newStr.append(numStr[index]).append(unit[i]);
        }
        String result = newStr.toString().replaceAll("零万", "万").
                replaceAll("零千", "零").
                replaceAll("零百", "零").
                replaceFirst("零十", "零").
                replaceAll("零+", "零").replaceFirst("一十", "十");
        // 判断最后一位是否为零，如果是则去掉
        if (result.endsWith("零")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * 将阿拉伯数字字符串转换为汉字
     *
     * @param index
     * @return
     */
    public static String getCnNum(final String index) {
        String num = null;
        if (StringUtils.isNumeric(index)) {
            try {
                num = String.valueOf(numStr[Integer.parseInt(index)]);
            } catch (NumberFormatException e) {
                return num;
            }
        }
        return num;
    }

    /**
     * 将阿拉伯数字转换为汉字
     *
     * @param index
     * @return
     */
    public static String getCnNum(final int index) {
        String num = null;
        if (index >= 0 && index < numStr.length) {
            num = String.valueOf(numStr[index]);
        }
        return num;
    }

    /**
     * 判断字符串是不是NULL或是空字符串,如果是，返回true，不是false
     *
     * @param str 待判断字符串
     * @return true/false
     */
    public static boolean isNullOrEmpty(final String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串对象是不是NULL或空，如果是，返回true，不是false
     * @param str 字符串对象
     * @return true/false
     */
    public static boolean isNullOrEmpty(final Object str){
        return str==null||"".equals(str.toString());
    }

    /**
     * 验证邮箱地址
     * @param emailAdress 邮箱地址
     * @return true/false
     */
    public static boolean verifyEmailAdress(String emailAdress){
        String regex="[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        return null!=emailAdress&&emailAdress.matches(regex);
    }

    /**
     * 验证手机号码
     * @param phoneNo 手机号码
     * @return true/false
     */
    public static boolean verifyPhoneNum(String phoneNo){
        String regex="^((13[0-9])|(17[0,7])|(15[^4,\\D])||(18[0-9]))\\d{8}$";
        return null!=phoneNo&&phoneNo.matches(regex);
    }

    /**
     * 对比2个对象的内容是否一致
     * @param ob1 对象1
     * @param ob2 对象2
     * @return true/false
     */
    public static boolean equalObject(Object ob1,Object ob2){
        return !(ob1==null||ob2==null)&&ob1.equals(ob2);
    }

    /**
     * 对比2个String对象的内容是否一致,忽略大小写
     * @param ob1 对象1
     * @param ob2 对象2
     * @return true/false
     */
    public static boolean equalStringObjectIgnoreCase(Object ob1,Object ob2){
        return !(ob1==null||ob2==null)&&(ob1.toString().equalsIgnoreCase(ob2.toString()));
    }

    /**
     *
     * @param array 数组
     * @param surffix 分割符号
     * @return
     */
    public static String array2String(final String[] array,final String surffix){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                builder.append(array[i]);
            }
            else {
                builder.append(array[i]).append(surffix);
            }
        }
        return builder.toString();
    }

    /**
     * 调用对象的toString方法，返回对象的字符串，如果是NULL返回null字符串
     * @param o 对象
     * @return String
     */
    public static String wrapperNull(Object o){
        if(o==null){
            return "null";
        }
        return o.toString();
    }

    /**
     * html内容过滤并截取
     * @param content HTML字符串
     * @param length 截取长度
     * @return 字符串
     */
    public static String getSummary(final String content,int length) {
        length=length<200?length:200;
        String text = StringSeriesTools.replaceAllMatch(content, "</?[^>]+>", "");
        if (text.length() > length) {
            text = text.substring(0, length);
        }
        return text;
    }

    /**
     * html内容中提取出第一个图片
     * @param content HTML内容
     * @return src的值
     */
    public static String getAvatar(final String content){
        List<String> avatars = StringSeriesTools.findString(content, "<img.*src=(.*?)[^>]*?>");
        //无图
        String avatar = null;
        if (!(avatars==null||avatars.isEmpty())) {
            avatar = StringSeriesTools.findString(avatars.get(0), "src=\"([^\"]+)\"").get(0).replace("src=", "").replaceAll("\"", "");
        }
        return avatar;
    }
}