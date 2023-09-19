package Jmucnki;
import java.util.Map;
public class Similarity {
    public static double calculateCosineSimilarity(Map<String, Integer> features1, Map<String, Integer> features2) {
        double dotProduct = 0.00;// 定义一个双精度浮点数变量 dotProduct，初始值为 0.00，用于存储两个向量的点积
        double nor1 = 0.0;// 定义一个双精度浮点数变量 nor1，初始值为 0.0，用于存储第一个向量的归一化长度
        double nor2 = 0.0;// 定义一个双精度浮点数变量 nor1，初始值为 0.0，用于存储第二个向量的归一化长度

        // 遍历第一个特征向量的每个元素（单词和它的频率）
        for (Map.Entry<String, Integer> entry : features1.entrySet()) {
            String word = entry.getKey();
            int c1 = entry.getValue(); // 获取当前单词在第一个特征向量中的频率
            int c2 = features2.getOrDefault(word, 0); // 获取当前单词在第二个特征向量中的频率，不存在则默认0

            dotProduct += c1 * c2;
            nor1 += Math.pow(c1, 2);//计算归一化长度
        }

        for (int count : features2.values()) {
            nor2 += Math.pow(count, 2);//计算归一化长度
        }

        double similarity = dotProduct / (Math.sqrt(nor1) * Math.sqrt(nor2));// 计算余弦相似性，点积除以两个向量的归一化长度的乘积
        return similarity;
    }
}
