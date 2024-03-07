package article;

import user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner scan) throws SQLException {
        ArticleController ctrl = new ArticleController();
        while(true){
            System.out.println("0-종료 1-글 목록");
            switch (scan.next()){
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("======= 글 목록 =======");
                    List<Article> list = ctrl.getList();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
