package com.huwei;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Athend
 * @E-mail: athend@foxmail.com
 * @Date: 2023/4/27
 * @Time: 18:31
 * @Description: 现场编程题题目内容：
 * 写一个方法，这个方法有三个参数：
 * 参数1：一组（数组和list都可以）学生（学号code和姓名）
 * 参数2：一组课程（课程ID和课程名称）
 * 参数3：一组选课信息（学号、课程ID）：一个学生可能选多个课程
 * 要求在方法中按行输出（system.out）学号、姓名、课程id、课程名称，按学号排序。
 * 【题目解释】
 * 1、学生人数100以内，课程10门以内。
 * 2、除了方法，定义必要的类（学生、课程、选课对象）
 * 3、考虑使用较高效的方式，考虑时间复杂度，使用JDK自带的API即可实现
 * 例子：public void printCourse(List<Student> students, ...)
 */
public class Main02 {
  public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<ChooseCourse> chooseCourses = new ArrayList<>();
    printCourse(students, courses, chooseCourses);
  }

  public static void printCourse(List<Student> students, List<Course> courses, List<ChooseCourse> chooseCourses) {
    Result result = new Result();
    HashMap<Integer, String> coursesMap = new HashMap<>();
    HashMap<Integer, List<Integer>> chooseCoursesMap = new HashMap<>();
    for (Course course : courses) {
      coursesMap.put(course.getCourseId(), course.getCourseName());
    }
    for (ChooseCourse chooseCourse : chooseCourses) {
      chooseCoursesMap.put(chooseCourse.getStudentCode(),chooseCourse.getCourseId());
    }
    for (Student student : students) {
      // 课程id列表
      List<Integer> list = chooseCoursesMap.get(student.getStudentCode());
      for (Integer integer : list) {
        String courseName = coursesMap.get(integer);
        System.out.println(student.getStudentCode() + '\t'+ student.getStudentName() + '\t' + integer + '\t' + courseName);
      }
    }
  }
}

class Student {
  private Integer studentCode;
  private String studentName;

  public Integer getStudentCode() {
    return studentCode;
  }

  public void setStudentCode(Integer studentCode) {
    this.studentCode = studentCode;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  @Override
  public int hashCode() {
    return this.getStudentCode().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return this.getStudentCode().equals(obj.hashCode());
  }
}

class Course {
  private Integer courseId;
  private String courseName;

  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
}

class ChooseCourse {
  private Integer studentCode;
  private List<Integer> courseId;

  public Integer getStudentCode() {
    return studentCode;
  }

  public void setStudentCode(Integer studentCode) {
    this.studentCode = studentCode;
  }

  public List<Integer> getCourseId() {
    return courseId;
  }

  public void setCourseId(List<Integer> courseId) {
    this.courseId = courseId;
  }
}

class Result implements Comparable<Result> {
  private Integer studentCode;
  private String studentName;
  private List<Integer> courseId;
  private List<String> courseName;

  @Override
  public int compareTo(Result o) {
    return this.studentCode - o.studentCode;
  }

  public Integer getStudentCode() {
    return studentCode;
  }

  public void setStudentCode(Integer studentCode) {
    this.studentCode = studentCode;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public List<Integer> getCourseId() {
    return courseId;
  }

  public void setCourseId(List<Integer> courseId) {
    this.courseId = courseId;
  }

  public List<String> getCourseName() {
    return courseName;
  }

  public void setCourseName(List<String> courseName) {
    this.courseName = courseName;
  }
}