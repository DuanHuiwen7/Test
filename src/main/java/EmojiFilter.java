import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class EmojiFilter {

    private static String regex = "[0-9a-zA-Z\\u4e00-\\u9fa5_，。；！？!?,.;-]*";
    /**
     * 过滤emoji字符
     *
     * @param str
     * @return 一旦含有就抛出
     */
    public static String filterEmoji(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        StringBuilder sb = null;
        for (char codePoint : str.toCharArray()) {
            if (!isEmojiCharacter(codePoint)) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(codePoint);
            }
        }
        return sb == null ? str : sb.toString();
    }

    /**
     * 是否包含特殊符号或字符
     *
     * @param codePoint
     * @return 如果不包含 返回false,包含 则返回true
     */
    public static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }

    public static String filterOffUtf8Mb4(String text) {
        try {
            byte[] bytes = text.getBytes("UTF-8");
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            int i = 0;
            while (i < bytes.length) {
                short b = bytes[i];
                if (b > 0) {
                    buffer.put(bytes[i++]);
                    continue;
                }
                b += 256;
                if ((b ^ 0xC0) >> 4 == 0) {
                    buffer.put(bytes, i, 2);
                    i += 2;
                } else if ((b ^ 0xE0) >> 4 == 0) {
                    buffer.put(bytes, i, 3);
                    i += 3;
                } else if ((b ^ 0xF0) >> 4 == 0) {
                    i += 4;
                }
            }
            buffer.flip();
            return new String(buffer.array(), "utf-8").trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static boolean containUtf8mb4(String str) {
        if (null == str) {
            return false;
        }
        final int LAST_BMP = 0xFFFF;
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i) + "  " + str.codePointAt(i));
            System.out.println("i = " + i);
            if (str.codePointAt(i) >= LAST_BMP) {
                return true;
            }
        }
        return false;
    }

    public static List<String> findUtf8mb4List(String str) {
        List<String> result = new ArrayList<String>();
        if (null == str) {
            return result;
        }
        final int LAST_BMP = 0xFFFF;
        for (int i = 0; i < str.length(); i++) {
            if (str.codePointAt(i) >= LAST_BMP) {
                result.add(new StringBuilder().appendCodePoint(str.codePointAt(i)).toString());
            }
            System.out.println(str.codePointAt(i));
            System.out.println("s  = " + new StringBuilder().appendCodePoint(str.codePointAt(i)).toString());
        }
        int index= 0;
        for (String s : str.split("")){
            System.out.println(s.codePointAt(0));
            System.out.println("str.split =  " + s + index ++);
        }
        return result;
    }

    public static String replaceAllUtf8mb4(String str) {
        if (null == str) {
            return "";
        }
        List<String> utf8mb4;
        if (CollectionUtils.isNotEmpty(utf8mb4 = findUtf8mb4List(str))) {
            for (String s : utf8mb4) {
                str = str.replaceAll(s,"");
            }
        }
        return str;
    }

}