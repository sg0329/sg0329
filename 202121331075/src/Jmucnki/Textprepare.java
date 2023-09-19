package Jmucnki;
import java.util.regex.Pattern;

public class Textprepare {
    public static String preprocess(String text) {
        //标点符号转换为空格
        text = text.replaceAll("[^a-zA-Z\\s]", " ");
        //将多个空格转化成一个空格
        text = text.replaceAll("\\s+", " ");
        // 将文本转换为小写
        text = text.toLowerCase();//不区分大小写，一样都算重复
        return text;

    }
}
