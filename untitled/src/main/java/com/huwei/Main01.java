package com.huwei;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Athend
 * @E-mail: athend@foxmail.com
 * @Date: 2023/4/15
 * @Time: 16:50
 * @Description: 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 * 示例：输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class Main01 {
  public static void main(String[] args) {
    String input = "ababcbacadefegdehijhklij";
    ArrayList<Integer> result = new ArrayList<>();
    int[] map = new int[26];
    char[] chars = input.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      map[chars[i] - 'a'] = i;
    }
    int start = 0;
    int end = 0;
    for (int i = 0; i < chars.length; i++) {
      end = Math.max(end, map[chars[i] - 'a']);
      if (i == end) {
        result.add(end - start + 1);
        start = end + 1;
      }
    }
    System.out.println(result);
  }
}
