package com.huwei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Athend
 * @E-mail: athend@foxmail.com
 * @Date: 2023/5/8
 * @Time: 18:34
 * @Description:
 */
public class Main03 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    input.nextLine();
    ArrayList<ArrayList<String>> lists = new ArrayList<>();
    for (int i = 0; i < t; i++) {
      if(input.hasNextLine()){
        int m = input.nextInt();
        input.nextLine();
        ArrayList<String> nums = new ArrayList<>();
        if(input.hasNextLine()){
          String[] split = input.nextLine().split(" ");
          for (int j = 0; j < m; j++) {
            nums.add(split[j]);
          }
        }
        lists.add(nums);
      }
    }
    ArrayList<Integer> result = solution(lists);
    for (Integer integer : result) {
      System.out.println(integer);
    }
  }

  private static ArrayList<Integer> solution(ArrayList<ArrayList<String>> lists) {

    ArrayList<Integer> result = new ArrayList<>();

    for (ArrayList<String> elem : lists) {
      elem.sort(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          return -o1.compareTo(o2);
        }
      });
      StringBuilder builder = new StringBuilder();
      for (String s : elem) {
        builder.append(s);
      }
      result.add(Integer.parseInt(builder.toString()));
    }

    return result;
  }
}
