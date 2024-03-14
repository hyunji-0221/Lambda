package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.article.ArticleView;
import com.von.api.board.BoardView;
import com.von.api.crawler.CrawlerView;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {
    EXIT("exit",i->{
        System.out.println("EXIT");
        return false;
    }),
    CRAWLER("crawler",i->{
        System.out.println("CRAWLERVIEW");
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    USER("user",i->{
        System.out.println("USERVIEW");
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    BOARD("board",i->{
        System.out.println("BOARDVIEW");
        try {
            BoardView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ACCOUNT("account",i->{
        System.out.println("ACCOUNTVIEW");
        AccountView.main(i);
        return true;
    }),
    ARTICLE("article",i->{
        System.out.println("ARTICLEVIEW");
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    NAVIGATION_ERROR("navigation_error",i->{
        System.out.println("Wrong Input");
        return true;
    })
    ;

    private final String name;
    private final Predicate<Scanner> predicate;

    Navigation(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean Navigate(Scanner scan){
        System.out.println("exit-종료 \ncrawler-Crawler \nuser-UserView \nboard-Board \naccount-AccountView \narticle-ArticleView");
        String str = scan.next();
        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny().orElse(NAVIGATION_ERROR).predicate.test(scan);
    }
}
