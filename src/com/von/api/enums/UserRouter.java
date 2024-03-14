package com.von.api.enums;

import com.von.api.user.User;
import com.von.api.user.UserController;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public enum UserRouter {
    EXIT("exit",(a,b)->{
        System.out.println("EXIT");
        return false;
    }),
    JOIN("join",(a,b)->{
        System.out.println("JOIN");
        b.save(a);
        return true;
    }),
    LOGIN("login",(a,b)->{
        System.out.println("LOGIN");
        System.out.println(b.login(a));;
        return true;
    }),
    NEWPW("newpw",(a,b)->{
        System.out.println(b.changePassword(a));
        return true;
    }),
    WITHDRAW("wd",(a,b)->{
        System.out.println(b.delete(a));;
        return true;
    }),
    USERLIST("list",(a,b)->{
        List<User> users = null;
        try {
            users = b.findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        users.forEach(i-> System.out.println(i));
        return true;
    }),
    SEARCHID("id",(a,b)->{

        return true;
    }),
    SEARCHNAME("name",(a,b)->{

        return true;
    }),
    SEARCHJOB("job",(a,b)->{

        return true;
    }),
    COUNTUSER("count",(a,b)->{
        System.out.println(b.count()+"명");
        return true;
    }),
    TOUCH("touch",(a,b)->{
        try {
            b.createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    RM("rm",(a,b)->{
        try {
            b.deleteTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ROUTER_ERROR("router_error",(a,b)->{
        System.out.println("ROUTER_ERROR");
        return false;
    })
    ;
    private final String name;
    private final BiPredicate<Scanner,UserController> predicate;

    UserRouter(String name, BiPredicate<Scanner, UserController> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    public static Boolean getInput(Scanner scan, UserController ctrl){
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
                .findAny().orElse(ROUTER_ERROR).predicate.test(scan,ctrl);
    }

}
