package com.von.api.enums;

import com.von.api.user.User;
import com.von.api.user.UserController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouterOfFunction {
    Exit("exit",a->{
        System.out.println("exit");
        return "exit";
    }),
    Join("join",a->{
        System.out.println("join");
        return UserController.getInstance().save(a);
    }),
    UserList("list",a->{
        System.out.println("List");
        try {
           List<User> users = UserController.getInstance().findUsers();
           users.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "userList";
    }),
    Wrong("router_error",a->{
        System.out.println("WrongAnswer");
        return "";
    })
    ;

    private final String name;
    private final Function<Scanner,String> function;

    UserRouterOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String select(Scanner scan) {
        System.out.println("[MENU] eixt-EXIT\n" +
                "join-JOIN\n" +
                "login-LOGIN\n" +
                "newpw-CHANGE PASSWORD\n" +
                "wd-WITHDRAW\n" +
                "list-USER LIST\n" +
                "id-SEARCH ID\n" +
                "name-SEARCH NAME\n" +
                "job-SEARCH JOB\n" +
                "count-USER COUNT\n" +
                "touch - CREATE TABLE\n" +
                "rm - DROP TABLE\n");
        String str = scan.next();
        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny().orElseGet(()->Wrong)
                .function.apply(scan);
    }

}
