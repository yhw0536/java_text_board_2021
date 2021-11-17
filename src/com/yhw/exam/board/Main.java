package com.yhw.exam.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    int articlesLastId = 0;
    while (true) {
      System.out.printf("명령 : ");
      String str = sc.nextLine();
      // System.out.printf("입력된 명령어 : %s\n", str);
      if (str.equals("/user/article/write")) {
        System.out.println("- 게시물 등록 -");
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String board = sc.nextLine();
        int Num = articlesLastId + 1;
        articlesLastId = Num;

        System.out.printf("%d번 게시물이 등록되었습니다. \n", Num);

      } else if (str.equals("exit")) {
        break;
      }
    }

    System.out.println("== 프로그램 종료 ==");
    sc.close();
  }
}
