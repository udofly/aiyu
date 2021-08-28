
package net.liexiang.loveyou.utils;

import android.content.Context;
import android.widget.EditText;

import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * describe：处理字符工具类
 * author： Gao Chunfa.
 * time： 2017/2/28-10:41.
 */
public class StringUtil {



    /**
     * 判断一个字符串是否含有中文
     */
    public static boolean isHasChinese(String str) {
        if (str == null)
            return false;
        for (char c : str.toCharArray()) {
            // 根据字节码判断
            if (c >= 0x4E00 && c <= 0x9FA5) {
                return true;// 有一个中文字符就返回
            }
        }
        return false;
    }


    /**
     * 获取editText的内容
     *
     * @param editText
     * @return
     */
    public static String getEdText(EditText editText) {
        return editText.getText().toString().trim();
    }


    /**
     * 获取editText的内容
     *
     * @return
     */
    public static String test(Context context) {
        if (context!=null){
            return "000";
        }
        return "111";
    }


    /**
     * 比较两个字符串是否相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static final boolean isEqual(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equals(str2);
    }

    /**
     * 不为空
     *
     * @param s
     * @return
     */
    public static boolean isNotNull(String s) {
        return s != null && !"".equals(s.trim());
    }

    /**
     * 为空
     *
     * @param s
     * @return
     */
    public static boolean isNull(String s) {
        return s == null || "".equals(s.trim());
    }


    /**
     * Unicode转utf-8
     *
     * @param src
     * @return
     */
    public static String unicodeToUTF_8(String src) {
        if (null == src) {
            return null;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < src.length(); ) {
            char c = src.charAt(i);
            if (i + 6 < src.length() && c == '\\' && src.charAt(i + 1) == 'u') {
                String hex = src.substring(i + 2, i + 6);
                try {
                    out.append((char) Integer.parseInt(hex, 16));
                } catch (NumberFormatException nfe) {
                    nfe.fillInStackTrace();
                }
                i = i + 6;
            } else {
                out.append(src.charAt(i));
                ++i;
            }
        }
        return out.toString();

    }



    /**
     * 得到字符串参数,中间用逗号分隔,最后不保留逗号
     */
    public static String getStringParams(JSONArray list, String key_get, String separator) {
        if (list.size() == 0 || list == null) {
            return "";
        }
        String        str_result = "";
        StringBuilder builder    = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {

            builder.append(list.getJSONObject(i).getString(key_get) + separator);
        }
        str_result = builder.toString();
        if (str_result.length() != 0) {
            str_result = str_result.substring(0, builder.length() - 1);
        }
        return str_result;
    }


    /**
     * 得到字符串参数,中间用逗号分隔,最后不保留逗号
     */
    public static String getStringParamsString(List<String> list) {

        if (list.size() == 0 || list == null) {
            return "";
        }
        String        str_result = "";
        StringBuilder builder    = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {

            builder.append(list.get(i) + ",");
        }
        str_result = builder.toString();
        if (str_result.length() != 0) {
            str_result = str_result.substring(0, builder.length() - 1);
        }
        return str_result;
    }

    /**
     * 得到字符串参数,中间用逗号分隔,最后不保留逗号
     */
//    public static String getStringParamsGroup(List<InfoGroup> list) {
//
//        if (list.size() == 0 || list == null) {
//            return "";
//        }
//        String        str_result = "";
//        StringBuilder builder    = new StringBuilder();
//        for (int i = 0; i < list.size(); i++) {
//
//            builder.append(list.get(i).id + ",");
//        }
//        str_result = builder.toString();
//        if (str_result.length() != 0) {
//            str_result = str_result.substring(0, builder.length() - 1);
//        }
//        return str_result;
//    }


    /**
     * https转为http
     *
     * @param mUri
     * @return
     */
    public static String parseVideoUrl(String mUri) {

        if (StringUtil.isNull(mUri)) {
            return "";
        }
        if (mUri.contains("https")) {
            return mUri.replace("https", "http");
        }
        return mUri;

    }

    /**
     * 将null返回""
     *
     * @param content
     * @return
     */
    public static String checkStringNull(String content) {

        if (StringUtil.isNull(content) || "null".equals(content)) {
            return "";
        }
        return content;
    }

    /**
     * 将null返回""
     *
     * @param content
     * @return
     */
    public static String checkStringNull(String content, String def) {

        if (StringUtil.isNull(content) || "null".equals(content)) {
            return def;
        }
        return content;
    }

    /**
     * 方法：获取包含Emoji表情字符串的字符个数
     *
     * @param source
     * @return
     */
    public static int filterLen(String source) {
        if (StringUtil.isNotNull(source)) {
//            return source.codePointCount(0, source.length());
            return filterEmoji(source).length();
        }
        return 0;
    }

    public static String filterEmoji(String source) {
        if (source != null) {
            Pattern emoji1 = Pattern
                    .compile("([\ud83c\udc00-\ud83c\udfff]\u200d(?:[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\ud83e\udc00-\ud83e\udfff]))" +
//							"|([\ud83c\udc00-\ud83c\udfff]\u200d[\ud83d\udc00-\ud83d\udfff])" +
//							"|([\ud83c\udc00-\ud83c\udfff]\u200d[\ud83e\udc00-\ud83e\udfff])" +
                                     "|([\ud83c\udffb-\ud83c\udfff]\u200d[\u2600-\uffff][\u2600-\uffff])" +
                                     "|\u200d[\u2600-\uffff][\u2600-\uffff]" +
                                     "|\ud83c\udffb\ufe0f" +
                                     "|\ud83c\udffc\ufe0f" +
                                     "|\ud83c\udffd\ufe0f" +
                                     "|\ud83c\udffe\ufe0f" +
                                     "|\ud83c\udfff\ufe0f" +
                                     "|\u200d(?:[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\ud83e\udc00-\ud83e\udfff])" +
//                                    "|\ud83e\uddb1" +
                                     "|[\u2640-\u2642]" +
                                     "",
                             Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher1 = emoji1.matcher(source);
            if (emojiMatcher1.find()) {
                String s = string2Unicode(source);
                // 空
                source = emojiMatcher1.replaceAll("");
                String s1 = string2Unicode(source);
            }
//            国旗
            Pattern emoji = Pattern
                    .compile(
                            "\ud83c\udff4\udb40\udc67\udb40\udc62\udb40\udc65\udb40\udc6e\udb40\udc67\udb40\udc7f" +
                                    "|\ud83c\udff4\udb40\udc67\udb40\udc62\udb40\udc73\udb40\udc63\udb40\udc74\udb40\udc7f" +
                                    "|\ud83c\udff4\udb40\udc67\udb40\udc62\udb40\udc77\udb40\udc6c\udb40\udc73\udb40\udc7f" +
                                    "|\ud83c\udff3\ufe0f\u200d\ud83c\udf08" +
                                    "|\ud83d\udd90\ud83c\udffd\ufe0f" +
                                    "|\ud83d\udd90\ud83c\udffb\ufe0f" +
                                    "|\ud83d\udd90\ud83c\udffc\ufe0f" +
                                    "|\ud83d\udd90\ud83c\udffe\ufe0f" +
                                    "|\ud83d\udd90\ud83c\udfff\ufe0f" +
                                    "|\ud83d\udc69\ud83c\udffb\u200d" +
                                    "|\ud83d\udc69\ud83c\udffc\u200d" +
                                    "|\ud83d\udc69\ud83c\udffd\u200d" +
                                    "|\ud83d\udc69\ud83c\udffe\u200d" +
                                    "|\ud83d\udc69\ud83c\udfff\u200d" +
                                    "|\ud83d\udc68\ud83c\udffb\u200d" +
                                    "|\ud83d\udc68\ud83c\udffc\u200d" +
                                    "|\ud83d\udc68\ud83c\udffd\u200d" +
                                    "|\ud83d\udc68\ud83c\udffe\u200d" +
                                    "|\ud83d\udc68\ud83c\udfff\u200d" +
                                    "|\u270c\ud83c\udffd\ufe0f" +
                                    "|\u270d\ud83c\udfff\ufe0f" +
                                    "|\u261d\ud83c\udffb\ufe0f" +
                                    "|\ud83e\udd36\ud83c\udffb" +
                                    "|\ud83e\udd36\ud83c\udffb" +
                                    "|\ud83c\udf85\ud83c\udffb" +
                                    "|\ud83e\udd18\ud83c\udffb" +
                                    "|\ud83e\udd18\ud83c\udffc" +
                                    "|\ud83e\udd18\ud83c\udffd" +
                                    "|\ud83e\udd18\ud83c\udffe" +
                                    "|\ud83e\udd18\ud83c\udfff" +
                                    "|\ud83e\udd34\ud83c\udffb" +
                                    "|\ud83e\udd34\ud83c\udffc" +
                                    "|\ud83e\udd34\ud83c\udffd" +
                                    "|\ud83e\udd34\ud83c\udffe" +
                                    "|\ud83e\udd34\ud83c\udfff" +
                                    "|\ud83e\uddd3\ud83c\udffb" +
                                    "|\ud83e\uddd3\ud83c\udffc" +
                                    "|\ud83e\uddd3\ud83c\udffd" +
                                    "|\ud83e\uddd3\ud83c\udffe" +
                                    "|\ud83e\uddd3\ud83c\udfff" +
                                    "|\ud83e\uddd4\ud83c\udffb" +
                                    "|\ud83e\uddd4\ud83c\udffc" +
                                    "|\ud83e\uddd4\ud83c\udffd" +
                                    "|\ud83e\uddd4\ud83c\udffe" +
                                    "|\ud83e\uddd4\ud83c\udfff" +
                                    "|\ud83e\uddd1\ud83c\udffb" +
                                    "|\ud83e\uddd1\ud83c\udffc" +
                                    "|\ud83e\uddd1\ud83c\udffd" +
                                    "|\ud83e\uddd1\ud83c\udffe" +
                                    "|\ud83e\uddd1\ud83c\udfff" +
                                    "|\ud83e\uddd2\ud83c\udffb" +
                                    "|\ud83e\uddd2\ud83c\udffc" +
                                    "|\ud83e\uddd2\ud83c\udffd" +
                                    "|\ud83e\uddd2\ud83c\udffe" +
                                    "|\ud83e\uddd2\ud83c\udfff" +
                                    "|\ud83c\udfc7\ud83c\udffb" +
                                    "|\ud83c\udfc7\ud83c\udffc" +
                                    "|\ud83c\udfc7\ud83c\udffd" +
                                    "|\ud83c\udfc7\ud83c\udffe" +
                                    "|\ud83c\udfc7\ud83c\udfff" +
                                    "|([\ud83d\udc00-\ud83d\udfff][\ud83c\udc00-\ud83c\udfff])" +
                                    "|([\ud83c\udde6-\ud83c\uddff][\ud83c\udde6-\ud83c\uddff])" +
                                    "|\ud83c\ude02\ufe0f" +
                                    "|\ud83c\udff3\ufe0f" +
                                    "|\ud83d\udd78\ufe0f" +
                                    "|\ud83d\udd4a\ufe0f" +
                                    "|\ud83d\udc3f\ufe0f" +
                                    "|\ud83c\udff5\ufe0f" +
                                    "|\ud83c\udf36\ufe0f" +
                                    "|\ud83d\udc41\ufe0f" +
                                    "|\ud83c\udfce\ufe0f" +
                                    "|\ud83c\udfcd\ufe0f" +
                                    "|\ud83d\udee9\ufe0f" +
                                    "|\ud83d\udee5\ufe0f" +
                                    "|\ud83d\udef3\ufe0f" +
                                    "|\ud83d\udd76\ufe0f" +
                                    "|\ud83d\udda5\ufe0f" +
                                    "|\ud83d\udda8\ufe0f" +
                                    "|\ud83d\uddb1\ufe0f" +
                                    "|\ud83d\uddb2\ufe0f" +
                                    "|\ud83d\udd79\ufe0f" +
                                    "|\ud83d\udddc\ufe0f" +
                                    "|\ud83d\udcfd\ufe0f" +
                                    "|\ud83c\udf9e\ufe0f" +
                                    "|\ud83c\udf99\ufe0f" +
                                    "|\ud83c\udf9a\ufe0f" +
                                    "|\ud83c\udf9b\ufe0f" +
                                    "|\ud83d\udd70\ufe0f" +
                                    "|\ud83d\udd6f\ufe0f" +
                                    "|\ud83d\udee2\ufe0f" +
                                    "|\ud83d\udee0\ufe0f" +
                                    "|\ud83d\udde1\ufe0f" +
                                    "|\ud83d\udee1\ufe0f" +
                                    "|\ud83d\udd73\ufe0f" +
                                    "|\ud83c\udf21\ufe0f" +
                                    "|\ud83d\udece\ufe0f" +
                                    "|\ud83d\udddd\ufe0f" +
                                    "|\ud83d\udecb\ufe0f" +
                                    "|\ud83d\udecf\ufe0f" +
                                    "|\ud83d\udecd\ufe0f" +
                                    "|\ud83c\udff7\ufe0f" +
                                    "|\ud83d\uddd2\ufe0f" +
                                    "|\ud83d\uddd3\ufe0f" +
                                    "|\ud83d\uddd1\ufe0f" +
                                    "|\ud83d\uddc3\ufe0f" +
                                    "|\ud83d\uddf3\ufe0f" +
                                    "|\ud83d\uddc4\ufe0f" +
                                    "|\ud83d\uddc2\ufe0f" +
                                    "|\ud83d\uddde\ufe0f" +
                                    "|\ud83d\udd87\ufe0f" +
                                    "|\ud83d\udd8a\ufe0f" +
                                    "|\ud83d\udd8b\ufe0f" +
                                    "|\ud83d\udd8c\ufe0f" +
                                    "|\ud83d\udd8d\ufe0f" +
                                    "|\ud83c\udf9f\ufe0f" +
                                    "|\ud83d\uddfa\ufe0f" +
                                    "|\ud83d\udef0\ufe0f" +
                                    "|\ud83d\udd49\ufe0f" +
                                    "|\ud83c\udd7e\ufe0f" +
                                    "|\ud83c\udd71\ufe0f" +
                                    "|\ud83c\udd70\ufe0f" +
                                    "|\ud83c\udd7f\ufe0f" +
                                    "|\ud83c\ude37\ufe0f" +
                                    "|\ud83c\udf7d\ufe0f" +
                                    "|\ud83c\udf96\ufe0f" +
                                    "|\ud83d\udd77\ufe0f" +
                                    "|\ud83d\udd90\ufe0f" +
                                    "|\u270a\ud83c\udffb" +
                                    "|\u270a\ud83c\udffc" +
                                    "|\u270a\ud83c\udffd" +
                                    "|\u270a\ud83c\udffe" +
                                    "|\u270a\ud83c\udfff" +
                                    "|\u270b\ud83c\udffb" +
                                    "|\u270b\ud83c\udffc" +
                                    "|\u270b\ud83c\udffd" +
                                    "|\u270b\ud83c\udffe" +
                                    "|\u270b\ud83c\udfff" +
                                    "|\ud83c\udfdc\ufe0f" +
                                    "|\ud83d\udee3\ufe0f" +
                                    "|\ud83d\udee4\ufe0f" +
                                    "|\ud83c\udfd5\ufe0f" +
                                    "|\ud83c\udfdd\ufe0f" +
                                    "|\ud83c\udfd6\ufe0f" +
                                    "|\ud83c\udfd4\ufe0f" +
                                    "|\ud83c\udfd9\ufe0f" +
                                    "|\ud83c\udfde\ufe0f" +
                                    "|\ud83d\uddbc\ufe0f" +
                                    "|\u0030\u20e3\ufe0f" +
                                    "|\u0039\u20e3\ufe0f" +
                                    "|\ud83c\udf29\ufe0f" +
                                    "|\ud83c\udf27\ufe0f" +
                                    "|\ud83c\udf26\ufe0f" +
                                    "|\ud83c\udf25\ufe0f" +
                                    "|\ud83c\udf24\ufe0f" +
                                    "|\ud83c\udf28\ufe0f" +
                                    "|\ud83c\udf2b\ufe0f" +
                                    "|\ud83c\udf2a\ufe0f" +
                                    "|\ud83c\udfd8\ufe0f" +
                                    "|\ud83c\udfda\ufe0f" +
                                    "|([\u0030-\u0039]\u20e3\ufe0f)" +
                                    "|(\ud83c[\udd00-\ude40]\ufe0f)" +
                                    "|([\u0030-\u0039]\ufe0f\u20e3)" +
                                    "|\ud80c\udc00" +
                                    "|\ud80c\udc01" +
                                    "|\ud80c\udc03" +
                                    "|\ud80c\udc05" +
                                    "|\ud80c\udc07" +
                                    "|\ud80c\udc0b" +
                                    "|\ud80c\udc0c" +
                                    "|\ud80c\udc0e" +
                                    "|\ud80c\udc19" +
                                    "|\ud80c\udc20" +
                                    "|\ud80c\udc24" +
                                    "|\ud80c\udc25" +
                                    "|\ud80c\udc2b" +
                                    "|\ud80c\udc3c" +
                                    "|\ud80c\udc45" +
                                    "|\ud80c\udc4d" +
                                    "|\ud80c\udc5f" +
                                    "|\ud80c\udc60" +
                                    "|\ud80c\udc69" +
                                    "|\ud80c\udc76" +
                                    "|\ud80c\udc77" +
                                    "|\ud80c\udcd2" +
                                    "|\ud80c\udcd7" +
                                    "|\ud80c\udcd8" +
                                    "|\ud80c\udcdd" +
                                    "|\ud80c\udcdf" +
                                    "|\ud80c\udce0" +
                                    "|\ud80c\udce1" +
                                    "|\ud80c\udce9" +
                                    "|\ud80c\udcec" +
                                    "|\ud80c\udcef" +
                                    "|\ud80c\udcf0" +
                                    "|\ud80c\udcf1" +
                                    "|\ud80c\udcf2" +
                                    "|\ud80c\udcf5" +
                                    "|\ud80c\udcf7" +
                                    "|\ud80c\udcf9" +
                                    "|\ud80c\udcfb" +
                                    "|\ud80c\udd3f" +
                                    "|\ud80c\udd5c" +
                                    "|\ud80c\udd66" +
                                    "|\ud80c\udd6a" +
                                    "|\ud80c\udd6d" +
                                    "|\ud80c\udd70" +
                                    "|\ud80c\udd88" +
                                    "|\ud80c\udd89" +
                                    "|\ud80c\udd8c" +
                                    "|\ud80c\udd8f" +
                                    "|\ud80c\udd97" +
                                    "|\ud80c\udd9f" +
                                    "|\ud80c\udda1" +
                                    "|\ud80c\udda3" +
                                    "|\ud80c\udda6" +
                                    "|\ud80c\udda7" +
                                    "|\ud80c\ude0e" +
                                    "|\u2601\ufe0e" +
                                    "|\u2602\ufe0e" +
                                    "|\u2614\ufe0e" +
                                    "|\u2603\ufe0e" +
                                    "|\u2660\ufe0e" +
                                    "|\u2663\ufe0e" +
                                    "|\u2665\ufe0e" +
                                    "|\u2639\ufe0e" +
                                    "|\u263a\ufe0e" +
                                    "|\u2615\ufe0e" +
                                    "|\u270c\ufe0e" +
                                    "|\u270d\ufe0e" +
                                    "|\u270f\ufe0e" +
                                    "|\u2712\ufe0e" +
                                    "|\u2702\ufe0e" +
                                    "|\u26be\ufe0e" +
                                    "|\u2708\ufe0e" +
                                    "|\u2693\ufe0e" +
                                    "|\u2668\ufe0e" +
                                    "|\u2648\ufe0e" +
                                    "|\u2668\ufe0f" +
                                    "|\u25fc\ufe0f" +
                                    "|\u25aa\ufe0f" +
                                    "|\u25ab\ufe0f" +
                                    "|\u2603\ufe0f" +
                                    "|\u262e\ufe0f" +
                                    "|\u271d\ufe0f" +
                                    "|\u262a\ufe0f" +
                                    "|\u2638\ufe0f" +
                                    "|\u2721\ufe0f" +
                                    "|\u2626\ufe0f" +
                                    "|\u262f\ufe0f" +
                                    "|\u2623\ufe0f" +
                                    "|\u2622\ufe0f" +
                                    "|\u269b\ufe0f" +
                                    "|\u3299\ufe0f" +
                                    "|\u3297\ufe0f" +
                                    "|\u2328\ufe0f" +
                                    "|\u2708\ufe0f" +
                                    "|\u2764\ufe0f" +
                                    "|\u2763\ufe0f" +
                                    "|\u2618\ufe0f" +
                                    "|\u263a\ufe0f" +
                                    "|\u2639\ufe0f" +
                                    "|\u2620\ufe0f" +
                                    "|\u26a0\ufe0f" +
                                    "|\u26d1\ufe0f" +
                                    "|\u26f4\ufe0f" +
                                    "|\u265f\ufe0f" +
                                    "|\u2602\ufe0f" +
                                    "|\u26f1\ufe0f" +
                                    "|\u26d3\ufe0f" +
                                    "|\u2709\ufe0f" +
                                    "|\u26b0\ufe0f" +
                                    "|\u26b1\ufe0f" +
                                    "|\u2697\ufe0f" +
                                    "|\u2696\ufe0f" +
                                    "|\u2692\ufe0f" +
                                    "|\u23f1\ufe0f" +
                                    "|\u2699\ufe0f" +
                                    "|\u23f2\ufe0f" +
                                    "|\u260e\ufe0f" +
                                    "|\u2694\ufe0f" +
                                    "|\u26cf\ufe0f" +
                                    "|\u270f\ufe0f" +
                                    "|\u2712\ufe0f" +
                                    "|\u2702\ufe0f" +
                                    "|\u2649\ufe0e" +
                                    "|\u264a\ufe0e" +
                                    "|\u264b\ufe0e" +
                                    "|\u264c\ufe0e" +
                                    "|\u264d\ufe0e" +
                                    "|\u264e\ufe0e" +
                                    "|\u264f\ufe0e" +
                                    "|\u2650\ufe0e" +
                                    "|\u2651\ufe0e" +
                                    "|\u2652\ufe0e" +
                                    "|\u2653\ufe0e" +
                                    "|\u269c\ufe0e" +
                                    "|\u271d\ufe0e" +
                                    "|\u2696\ufe0e" +
                                    "|\u2697\ufe0e" +
                                    "|\u2618\ufe0e" +
                                    "|\u269b\ufe0e" +
                                    "|\u2692\ufe0e" +
                                    "|\u262f\ufe0e" +
                                    "|\u262e\ufe0e" +
                                    "|\u262a\ufe0e" +
                                    "|\u2638\ufe0e" +
                                    "|\u2694\ufe0e" +
                                    "|\u2604\ufe0e" +
                                    "|\u26b1\ufe0e" +
                                    "|\u26b0\ufe0e" +
                                    "|\u2626\ufe0e" +
                                    "|\u2699\ufe0e" +
                                    "|\u2721\ufe0e" +
                                    "|\u2611\ufe0e" +
                                    "|\u2744\ufe0e" +
                                    "|\u2714\ufe0e" +
                                    "|\u2764\ufe0e" +
                                    "|\u2b07\ufe0e" +
                                    "|\u2b06\ufe0e" +
                                    "|\u2b05\ufe0e" +
                                    "|\u27a1\ufe0e" +
                                    "|\u261d\ufe0e" +
                                    "|\u2935\ufe0e" +
                                    "|\u2934\ufe0e" +
//                                    "|\u2702\ufe0f" +
                                    "|[\ud83c\udc00-\ud83c\udfff]" +
                                    "|[\ud83d\udc00-\ud83d\udfff]" +
                                    "|[\ud83e\udc00-\ud83e\udfff]" +
                                    "|([\u3290-\u3290]\ufe0f)" +
                                    "|([\u2194-\u2b07]\ufe0f)" +
                                    "|[\u2500-\u29ff]" +
                                    "|[\u20d0-\u20e2]" +
                                    "|[\u20e4-\u20f0]" +
                                    "|[\u2b00-\u2bff]" +
                                    "|[\u3297-\u3299]" +
                                    "|[\u2300-\u23ff]" +
                                    "|[\u2190-\u21ff]" +
                                    "|[\u24b6-\u24e9]",
                            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                String s = string2Unicode(source);
                // \ufffd
                source = emojiMatcher.replaceAll("\ufffd");
                String s2 = string2Unicode(source);
                return source;
            }
            return source;
        }
        return source;
    }

    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }

        return unicode.toString();
    }
}
