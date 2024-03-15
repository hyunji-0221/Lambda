package com.von.api.enums;

import com.von.api.menu.MenuController;
import com.von.api.user.User;
import com.von.api.user.UserController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouterOfFunction {
    Exit("x",a->{
        System.out.println("exit");
        return "exit";
    }),
    MK("mk",a->{
        System.out.println("make table");
        try {
            UserController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Join("joi",a->{
        System.out.println("join");
        return UserController.getInstance().save(a);
    }),
    LogIn("log",a->{
        System.out.println("login");
        return null;
    }),
    FindTheOne("cat",a->{
        System.out.println("Find the One");
        return null;
    }),
    NewPW("ch-pw",a->{
        System.out.println("Change password");
        return null;
    }),
    Delete("rm",a->{
        System.out.println("Delete Row");
        return null;
    }),
    UserList("ls-a",a->{
        System.out.println("List");
        try {
           List<User> users = UserController.getInstance().findUsers();
           users.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "userList";
    }),
    UserByName("ls-n",a->{
        System.out.println("Search with Name");
        return null;
    }),
    UserByJob("ls-j",a->{
        System.out.println("Search with Job");
        return null;
    }),
    Count("cnt",a->{
        System.out.println("Count Users");
        return null;
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

    public static String select(Scanner scan) throws SQLException {

        List<?> ls = MenuController.getInstance().returnAllMenus("user");

        ls.forEach(System.out::println);

        String str = scan.next();
        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny().orElseGet(()->Wrong)
                .function.apply(scan);
    }

}
