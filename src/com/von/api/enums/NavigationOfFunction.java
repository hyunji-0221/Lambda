package com.von.api.enums;

import com.von.api.account.AccountView;
import com.von.api.article.ArticleView;
import com.von.api.board.BoardView;
import com.von.api.crawler.CrawlerView;
import com.von.api.menu.Menu;
import com.von.api.menu.MenuController;
import com.von.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    Exit("x",i->"x"),
    MK("mk",i->{
        System.out.println("Make Menu Table");
        MenuController.getInstance().makeMenuTable();
        return "";
    }),
    Crawler("cwl",i-> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    User("usr",i->{
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("art",i-> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Account("acc",i-> {
        AccountView.main(i);
        return "";
    }),
    Board("bbs",i-> {
        try {
            BoardView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Soccer("scc",i-> {
        System.out.println("Soccer View");
        return null;
    }),
    Error("nav_error",i->{
        System.out.println("Wrong Input");
        return "nav_error";
    });

    private final String name;
    private final Function<Scanner,String> function;

    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String select(Scanner scan) throws SQLException {

        List<?> ls = MenuController.getInstance().returnAllMenus("navigate");

        ls.forEach(System.out::println);

        String selectMenu = scan.next();
        System.out.println("선택한 메뉴 : "+selectMenu);
        return Stream.of(values())
                .filter(i->i.name.equals(selectMenu))
                .findAny().orElseGet(()->Error)
                .function.apply(scan);
    }
}
