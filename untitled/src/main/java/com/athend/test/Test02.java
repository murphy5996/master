package com.athend.test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Athend
 * @E-mail: athend@foxmail.com
 * @Date: 2023/4/15
 * @Time: 12:53
 * @Description:
 * 小华负责公司知识图谱产品，现在要通过新词挖掘完善知识图谱。
 * 新词挖掘：给出一个待挖掘文本内容字符串content和一个词的字符串word，找到content中所有word的新词。
 * 新词：使用词word的字符排列形成的字符串。
 * 请帮小华实现新词挖掘，返回发现的新词的数量
 * 输入描述：
 * 第一行输入为待挖掘的文本内容content；
 * 第二行输入为词word；
 * abab
 * ab
 * 输出描述：
 * 在中找到的所有word的新词的数量
 * 3
 */
public class Test02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String content = scanner.nextLine();
    String word = scanner.nextLine();
    System.out.println(solution(content, word));
  }

  private static int solution(String content, String word) {
    int result = 0;
    if (content.length() < word.length()) {
      return result;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    int count = word.length();
    char[] charsWord = word.toCharArray();
    for (char c : charsWord) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < word.length(); i++) {
      char c = content.charAt(i);
      if (map.containsKey(c)) {
        if (map.get(c) > 0) {
          count--;
        }
        map.put(c, map.get(c) - 1);
      }
    }
    if (count == 0) {
      result++;
    }
    for (int i = 1; i < content.length() - word.length(); i++) {
      char delete = content.charAt(i - 1);
      char insert = content.charAt(i + word.length() - 1);
      if (map.containsKey(delete)) {
        if (map.get(delete) >= 0) {
          count++;
        }
        map.put(delete, map.get(delete) + 1);
      }
      if (map.containsKey(insert)) {
        if (map.get(insert) > 0) {
          count--;
        }
        map.put(insert, map.get(insert) - 1);
      }
      if (count == 0) {
        result++;
      }
    }
    return result;
  }
}
