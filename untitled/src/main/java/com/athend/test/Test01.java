package com.athend.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Athend
 * @E-mail: athend@foxmail.com
 * @Date: 2023/4/15
 * @Time: 12:54
 * @Description:
 * 给定一个
 * m×n 的矩阵，由若干字符 X 和 O构成，
 * X表示该处已被占据，O表示该处空闲，请找到最大的单入口空闲区域。
 *
 * 空闲区域是由连通的O组成的区域，位于边界的O可以构成入口，
 * 单入口空闲区域即有且只有一个位于边界的O作为入口的由连通的O组成的区域。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“连通”的
 * 输入描述：
 * 4 4
 * X X X X
 * X O O X
 * X O O X
 * X O X X
 * 输出描述：
 * 若有唯一符合要求的最大单入口空闲区域，输出三个数字，
 * 第一个数字为入口行坐标（范围为0~行数-1），
 * 第二个数字为入口列坐标（范围为0~列数-1），
 * 第三个数字为区域大小，三个数字以空格分隔；
 * 若有多个符合要求的最大单入口空闲区域，输出一个数字，代表区域的大小；
 * 若没有，输出NULL。
 */
public class Test01 {
  static int m = 0;
  static int n = 0;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    m = scanner.nextInt();
    n = scanner.nextInt();
    int[][] offset = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    String[][] array = new String[m][n];
    HashSet<Integer> checked = new HashSet<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        array[i][j] = scanner.next();
      }
    }
    System.out.println(solution(array, m, n, offset, checked));

  }

  private static String solution(String[][] array, int m, int n, int[][] offset, HashSet<Integer> checked) {
    ArrayList<Integer[]> result = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ("O".equals(array[i][j]) && !checked.contains(i * 10 + j)) {
          ArrayList<Integer[]> enter = new ArrayList<>();
          int count = dfs(i, j, 0, array, enter, offset, checked);
          if (enter.size() == 1) {
            Integer[] pos = enter.get(0);
            Integer[] temp = {pos[0], pos[1], count};
            result.add(temp);
          }
        }
      }
    }
    if (result.size() == 0) {
      return "NULL";
    }
    result.sort((a, b) -> b[2] - a[2]);

    if (result.size() == 1 || result.get(0)[2] > result.get(1)[2]) {
      StringBuilder buffer = new StringBuilder();
      for (int i = 0; i < result.get(0).length; i++) {
        if (i == result.get(0).length - 1) {
          buffer.append(result.get(0)[i]);
        } else {
          buffer.append(result.get(0)[i]).append(" ");
        }
      }
      return buffer.toString();
    } else {
      return result.get(0)[2].toString();
    }
  }

  private static int dfs(int i, int j, int count, String[][] array, ArrayList<Integer[]> enter, int[][] offset, HashSet<Integer> checked) {
    if (i < 0 || i >= m || j < 0 || j >= n || "X".equals(array[i][j]) || checked.contains(i * 10 + j)) {
      return count;
    }
    checked.add(i * 10 + j);

    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
      enter.add(new Integer[]{i, j});
    }
    count++;
    for (int k = 0; k < offset.length; k++) {
      int offsetX = offset[k][0];
      int offsetY = offset[k][1];
      count = dfs(i + offsetX, j + offsetY, count, array, enter, offset, checked);
    }
    return count;
  }
}
