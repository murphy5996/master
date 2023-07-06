package com.athend.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Athend
 * @E-mail: athend@foxmail.com
 * @Date: 2023/4/15
 * @Time: 12:53
 * @Description:
 * 小王是一名基站维护工程师，负责某区域的基站维护,
 * 某地方有n个基站（1<n<10），已知各基站之间的距离s（0<s<500），
 * 并且基站x到基站y的距离，与基站y到基站x的距离并不一定会相同
 * 小王从基站1出发，途经每个基站1次，然后返回基站1，需要请你为他选择一条距离最短的路
 * 输入描述：
 * 站点数n和各站点之间的距离(均为整数)。
 * 3 {站点数}
 * 0 2 1 {站点1到各站点的路程}
 * 1 0 2 {站点2到各站点的路程}
 * 2 1 0 {站点3到各站点的路程}
 * 输出描述：
 * 最短路程的数值 3
 */
public class Test03 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    int[][] array = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        array[i][j] = scanner.nextInt();
      }
      scanner.nextLine();
    }
    System.out.println(solution(n, array));
  }

  private static int solution(int n, int[][] array) {
    boolean[] check = new boolean[n];
    LinkedList<Integer> path = new LinkedList<>();
    ArrayList<LinkedList<Integer>> resDim = new ArrayList<>();
    dfs(n, check, path, resDim);

    int result = Integer.MAX_VALUE;

    for (LinkedList<Integer> elem : resDim) {
      int dis = array[0][elem.get(0)];
      for (int i = 0; i < elem.size() - 1; i++) {
        int p = elem.get(i);
        int c = elem.get(i + 1);
        dis += array[p][c];
      }
      dis += array[elem.getLast()][0];
      result = Math.min(result, dis);
    }
    return result;
  }

  private static void dfs(int n, boolean[] check, LinkedList<Integer> path,
                          ArrayList<LinkedList<Integer>> resDim) {
    if ((path.size() == n - 1)) {
      resDim.add((LinkedList<Integer>) path.clone());
      return;
    }
    for (int i = 1; i < n; i++) {
      if (!check[i]) {
        path.push(i);
        check[i] = true;
        dfs(n, check, path, resDim);
        check[i] = false;
        path.pop();
      }
    }
  }
}
