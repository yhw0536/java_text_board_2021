package com.yhw.exam.board;

import java.util.Scanner;

class Article extends Object {
  int id;
  String title;
  String body;

  @Override
  public String toString() {
    // return String.format("{id: " + id + ", " + "title: " + title + ", " + "body: " + body + "}");
    return String.format("{id : %d, title : \"%s\" body : \"%s\"}", id, title, body);
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Article article = new Article();
    int articlesLastId = 0;

    System.out.println("== 게시판 v 0.1 ==");
    System.out.println("== 프로그램 시작 ==");

    while (true) {
      System.out.printf("명령 : ");
      String str = sc.nextLine();
      // System.out.printf("입력된 명령어 : %s\n", str);
      if (str.equals("/user/article/write")) {
        System.out.println("- 게시물 등록 -");
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String body = sc.nextLine();
        int id = articlesLastId + 1;
        articlesLastId = id;

        article.id = id;
        article.title = title;
        article.body = body;
        System.out.println("생성된 게시물 객체 : " + article.toString());
        System.out.printf("%d번 게시물이 등록되었습니다. \n", id);

        /*
        System.out.println("id: " + id);
        System.out.println("title : " + title);
        System.out.println("body : " + body);
        */

        System.out.println();

      } else if (str.equals("exit")) {
        break;
      }
    }

    System.out.println("== 프로그램 종료 ==");
    sc.close();
  }
}
