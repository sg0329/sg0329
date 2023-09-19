package Jmucnki;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class main {

	public static double main(String text1,String text2) {
        // 文本预处理
        String processedText1 = Textprepare.preprocess(text1);
        String processedText2 = Textprepare.preprocess(text2);

        // 特征提取
        Map<String, Integer> features1 = Feature.extractFeatures(processedText1);
        Map<String, Integer> features2 = Feature.extractFeatures(processedText2);

        // 相似度计算
        double similarity = Similarity.calculateCosineSimilarity(features1, features2);
        return similarity;
    }

    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入原文路径：");//D:\\论文查重系统\\a.txt
    	String u1 = scanner.nextLine();
    	System.out.println("请输入抄袭文路径：");//D:\\论文查重系统\\b.txt
    	String u2 = scanner.nextLine();
    	StringBuffer buffer1=new StringBuffer();
    	File f1=new File(u1);
    	BufferedReader bf1=new BufferedReader(new FileReader(f1));
    	String s1=null;
    	while((s1=bf1.readLine())!=null) {
    		buffer1.append(s1.trim());
    	}
    	String text1=buffer1.toString();
    	
    	StringBuffer buffer2=new StringBuffer();
    	File f2=new File(u2);
    	BufferedReader bf2=new BufferedReader(new FileReader(f2));
    	String s2=null;
    	while((s2=bf2.readLine())!=null) {
    		buffer2.append(s2.trim());
    	}
    	String text2=buffer2.toString();
    	System.out.print(text1);
    	System.out.print("\n");
    	System.out.print(text2);
    	System.out.print("\n");
    	
    	
        double similarity = main(text1, text2);
        System.out.printf("查重率： %.02f\n",similarity);
    }


	}
