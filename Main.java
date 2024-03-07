
import account.AccountView;
import board.BoardView;
import crawler.CrawlerService;
import crawler.CrawlerView;
import user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("0-종료 1-Crawler 2-사용자관리(맵) 3-게시판 4-계좌관리");

            switch (scan.next()){
                case "0" :
                    System.out.println("종료되었습니다.");
                    return;
                case "1" :
                    System.out.println("Crawler");
                    CrawlerView.main(scan);
                    break;
                case "2" :
                    System.out.println("사용자관리(맵)");
                    UserView.main(scan);
                    break;
                case "3" :
                    System.out.println("게시판");
                    BoardView.main(scan);
                    break;
                case "4" :
                    System.out.println("계좌관리");
                    AccountView.main(scan);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}