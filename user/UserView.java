package user;


import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scan) {
        UserController ctrl = new UserController();
        System.out.println(ctrl.addUsers());

        while (true) {
            System.out.println("[메뉴] 0-종료\n" +
                    "1-회원가입\n" +
                    "2-로그인\n" +
                    "3-ID검색\n" +
                    "4-비번변경\n" +
                    "5-회원탈퇴\n" +
                    "6-회원목록\n" +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");
            switch (scan.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("======= 회원가입 =======");
                    System.out.println(ctrl.save(scan));
                    break;
                case "2":
                    System.out.println("======= 로그인 =======");
                    System.out.println(ctrl.login(scan));
                    break;
                case "3":
                    System.out.println("======= ID검색 =======");
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
                case "6":
                    System.out.println("======= 회원목록 =======");
                    Map<String, ?> users = ctrl.getUserMap();
                    users.forEach((k,v)->{
                        System.out.printf("아이디: %s, 회원정보: %s", k, v);
                    });
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
            }
        }

    }
}
