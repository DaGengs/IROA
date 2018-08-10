package cn.iruier.common.utils;

//字符串工具类 判定字符串是否为空
//非空返回true
//空返回false
public class StringUtils {
    public static boolean empty(String... msg) {
        boolean res = true;
        for (String s : msg) {
            res = (s != null && s.length() > 0);
            if (!res) {
                break;
            }
        }
        return res;
    }
}
