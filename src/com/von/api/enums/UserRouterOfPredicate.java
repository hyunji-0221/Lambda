package com.von.api.enums;

import com.von.api.user.User;
import com.von.api.user.UserController;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public enum UserRouterOfPredicate {
    EXIT("exit",(a)->{
        System.out.println("EXIT");
        return false;
    }),
    JOIN("join",(a)->{
        System.out.println("JOIN");
        UserController.getInstance().save(a);
        return true;
    }),
    LOGIN("login",(a)->{
        System.out.println("LOGIN");
        System.out.println(UserController.getInstance().login(a));
        return true;
    }),
    NEWPW("newpw",(a)->{
        System.out.println(UserController.getInstance().changePassword(a));
        return true;
    }),
    WITHDRAW("wd",(a)->{
        System.out.println(UserController.getInstance().delete(a));;
        return true;
    }),
    USERLIST("list",(a)->{
        List<User> users = null;
        try {
            users = UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        users.forEach(i-> System.out.println(i));
        return true;
    }),
    SEARCHID("id",(a)->{

        return true;
    }),
    SEARCHNAME("name",(a)->{

        return true;
    }),
    SEARCHJOB("job",(a)->{

        return true;
    }),
    COUNTUSER("count",(a)->{
        System.out.println(UserController.getInstance().count()+"명");
        return true;
    }),
    TOUCH("touch",(a)->{
        try {
            UserController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    RM("rm",(a)->{
        try {
            UserController.getInstance().deleteTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ROUTER_ERROR("router_error",(a)->{
        System.out.println("ROUTER_ERROR");
        return false;
    })
    ;
    private final String name;
    private final Predicate<Scanner> predicate;

    UserRouterOfPredicate(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean getInput(Scanner scan){
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
        return Arrays.stream(values())
                .filter(i->i.name.equals(str))
                .findAny().orElse(ROUTER_ERROR).predicate.test(scan);
    }

}
