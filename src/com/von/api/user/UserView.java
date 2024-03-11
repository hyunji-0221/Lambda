package com.von.api.user;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scan) throws SQLException {
        UserController ctrl = new UserController();
        System.out.println(ctrl.addUsers());

        while (true) {
            System.out.println("[메뉴] 0-종료\n" +
                    "1-회원가입\n" +
                    "2-로그인\n" +
                    "3-ID검색\n" +
                    "4-비번변경\n" +
                    "5-회원탈퇴\n" +
                    "ls-회원목록\n" +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수\n" +
                    "touch - 테이블생성\n" +
                    "rm - 테이블삭제\n");

            switch (scan.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("======= 회원가입 =======");
                    ctrl.save(scan);
                    System.out.println(ctrl.save(scan));
                    break;
                case "2":
                    System.out.println("======= 로그인 =======");
                    System.out.println(ctrl.login(scan));
                    break;
                case "3":
                    System.out.println("======= ID검색 =======");
//                    System.out.println(ctrl.test());
                    User user = ctrl.findUser(scan);
                    System.out.println(ctrl.getOne(scan));
                    break;
                case "4":
                    System.out.println("======= 비밀번호변경 =======");
                    System.out.println(ctrl.changePassword(scan));
                    break;
                case "5":
                    System.out.println("======= 회원탈퇴 =======");
                    System.out.println(ctrl.delete(scan));
                    break;
                case "ls":
                    System.out.println("======= 회원목록 =======");
                    List<User> users = ctrl.findUsers();
                    users.forEach(i-> System.out.println(i));
                    break;
                case "7":
                    System.out.println("======= 이름검색 =======");
                    ctrl.findUsersByName(scan).forEach((i)->{
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("======= 직업검색 =======");
                    ctrl.findUsersByJob(scan).forEach((i)->{
                        System.out.println(i);
                    });
                    break;
                case "9":
                    System.out.println("======= 회원수 =======");
                    String numberOfUsers = ctrl.count();
                    System.out.println("회원수 "+numberOfUsers);
                    break;
                case "touch":
                    System.out.println("======= 테이블생성 =======");
                    ctrl.createTable();
                    System.out.println("회원테이블 생성 성공");
                    break;
                case "rm":
                    System.out.println("======= 테이블삭제 =======");
                    ctrl.deleteTable();
                    System.out.println("회원테이블 삭제 성공");
                    break;
            }
        }
    }
}
