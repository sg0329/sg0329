package Jmucnki;
import java.util.HashMap;
import java.util.Map;
public class Feature {
    public static Map<String, Integer> extractFeatures(String text) {
    	
        String[] words = text.split(" ");//将文本按空格进行分隔得到字符串数组，即一个个单词
        // 创建一个空的HashMap，用于存储单词及其在文本中出现的次数。
        Map<String, Integer> feature = new HashMap<>();
        // 检查当前单词是否已经在features映射中存在。
        for (String word : words) {
            if (feature.containsKey(word)) {
                feature.put(word, feature.get(word) + 1);//存在则计数+1
            } else {
                feature.put(word, 1);//不存在则加入映射，计数置为1
            }
        }
        // 返回包含单词及其出现次数的映射。
        return feature;
    }
}
