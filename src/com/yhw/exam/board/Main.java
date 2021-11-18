package com.yhw.exam.board;

import java.util.ArrayList;
import java.util.Scanner;

/*
TODO
- [x] 환영메세지 출력
- [x] 고객으로부터 명령어 입력받기
  - [x] 스캐너 객체라도 하나 만들어보기
  - [x] 받은 명령어 출력하기
- [x] exit 명령어 처리
  - [x] exit 입력받으면 종료 라고 출력하기
  - [x] exit 입력받을 때 까지 계속 실행
- [x] /usr/article/write 명령어 입력처리
  - [x] 시작문구라도 출력
  - [x] 제목과 내용이라도 입력받기
  - [x] 생성된 게시물 번호 출력
  - [x] 생성될 때 마다 게시물번호가 증가
  - [x] 생성된 게시물을 객체에 담기
  - [x] Article 객체 생성하기
  - [x] Article 클래스 생성하기
- [x] /usr/article/detail 명령어 입력처리
  - [x] 명령어 입력 받으면 가장 최근 게시물 출력
- [x] /usr/article/list 명령어 입력 처리
  - [x] 지금까지 입력 받은 게시물 리스트 역순으로 출력
- [x] 명령어를 제대로 입력했다면, 입력받은 명령어 문구는 안나오도록
- [x] toString 메서드 오버라이드 하기
- [x] 생성자 도입
 */

class Article {
  int id;
  String title;
  String body;

  Article() {

  }

  Article(int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }

  @Override
  public String toString() {
    return String.format("{id : \"%d\", title : \"%s\", body : \"%s\"}", id, title, body);
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int articlesLastId = 0;
    Article lastArticle = null;
    ArrayList<Article> arr = new ArrayList<Article>();

    System.out.println("- 텍스트 게시판 v0.5 -");
    System.out.println("== 프로그램 시작 ==");

    while (true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();

      if (cmd.equals("exit")) {
        break;
      } else if (cmd.equals("/usr/article/write")) {
        Article article = new Article();
        System.out.println("- 게시물 입력 -");
        System.out.printf("제목 : ");
        String title = sc.nextLine();
        System.out.printf("내용 : ");
        String body = sc.nextLine();
        int id = articlesLastId + 1;
        articlesLastId = id;

        article.id = id;
        article.title = title;
        article.body = body;

        System.out.printf("게시물 번호 : %s \n", id);
        System.out.printf("게시물이 담긴 객체 : %s \n", article);

        lastArticle = article;
        arr.add(article);
      } else if (cmd.equals("/usr/article/detail")) {
        if (lastArticle == null) {
          System.out.println("등록된 게시물이 없습니다.");
          continue;
        }
        System.out.println("- 게시물 상세 -");

        Article article = lastArticle;
        System.out.printf("번호 : %d\n", article.id);
        System.out.printf("제목 : %s\n", article.title);
        System.out.printf("내용 : %s\n", article.body);

      } else if (cmd.equals("/usr/article/list")) {
        System.out.println("- 게시물 리스트- ");
        System.out.println("----------------");
        System.out.println("번호 / 제목 ");
        System.out.println("----------------");
        for (int i = arr.size() - 1; i >= 0; i--) {
          Article article = arr.get(i);

          System.out.println("  " + article.id + " / " + article.title);
          //System.out.println(arr.get(i));
        }
      } else {
        System.out.printf("입력 받은 명령어 : %s \n", cmd);
      }
    }
    System.out.println("프로그램 종료");
    sc.close();
  }
}
