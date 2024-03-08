
import account.AccountView;
import article.ArticleView;
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
            System.out.println("x-종료 c-Crawler u-UserView b-Board m-AccountView a-ArticleView");

            switch (scan.next()){
                case "x" :
                    System.out.println("종료되었습니다.");
                    return;
                case "c" :
                    System.out.println("Crawler");
                    CrawlerView.main(scan);
                    break;
                case "u" :
                    System.out.println("UserView");
                    UserView.main(scan);
                    break;
                case "b" :
                    System.out.println("Board");
                    BoardView.main(scan);
                    break;
                case "m" :
                    System.out.println("AccountView");
                    AccountView.main(scan);
                    break;
                case "a" :
                    System.out.println("ArticleView");
                    ArticleView.main(scan);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}