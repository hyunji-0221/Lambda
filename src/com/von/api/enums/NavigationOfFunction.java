package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.article.ArticleView;
import com.von.api.board.BoardView;
import com.von.api.crawler.CrawlerView;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    Exit("exit",i->"x"),
    Crawler("crawler",i-> {
        try {
            System.out.println("INc");
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    User("user",i->{
        try {
            System.out.println("INu");
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("article",i-> {
        try {
            System.out.println("INar");
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Account("account",i-> {
        System.out.println("INac");
        AccountView.main(i);
        return "";
    }),
    Board("board",i-> {
        try {
            System.out.println("INb");
            BoardView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Error("nav_error",i->{
        return "nav_error";
    });

    private final String name;
    private final Function<Scanner,String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String select(Scanner scan) {
        System.out.println("exit-종료 \ncrawler-Crawler \nuser-UserView " +
                "\nboard-Board \naccount-AccountView \narticle-ArticleView");
        String selectMenu = scan.next();
        System.out.println("선택한 메뉴 : "+selectMenu);
        return Stream.of(values())
                .filter(i->i.name.equals(selectMenu))
                .findAny().orElseGet(()->Error)
                .function.apply(scan);
    }
}
