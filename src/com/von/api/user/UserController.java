package com.von.api.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    UserServiceImpl service;

    private static UserController instance = new UserController();

    private UserController() {
        this.service = UserServiceImpl.getInstance();
    }

    public static UserController getInstance(){
        return instance;
    }

    public String save(Scanner scanner) {
        service.save(User.builder()
                .userName(scanner.next())
                .password(scanner.next())
                .name(scanner.next())
                .pNum(scanner.next())
                .job(scanner.next())
                .height(scanner.nextDouble())
                .weight(scanner.nextDouble())
                .build());
        return "회원가입 성공";
    }

    public String login(Scanner scanner) {
        return service.login(User.builder()
                .userName(scanner.next())
                .password(scanner.next())
                .build());
    }

    public String changePassword(Scanner scanner) {
        
        return service.changePassword(User.builder()
                .userName(scanner.next())
                .pNum(scanner.next())
                .password(scanner.next())
                .build());
    }

    public String delete(Scanner scanner) {
        service.delete(User.builder()
                .userName(scanner.next())
                .build());
        return "회원삭제";
    }

    public List<?> findUsersByName(Scanner scanner) {
        return service.findUsersByName(scanner.next());
    }

    public List<?> findUsersByJob(Scanner scanner) {
        return service.findUsersByJob(scanner.next());
    }


    public String count() {
        return service.count();
    }

    public List<User> findUsers() throws SQLException {
        return service.findUsers();
    }

    public void createTable() throws SQLException {
        service.createTable();
    }

    public void deleteTable() throws SQLException {
        service.deleteTable();
    }


    public Optional<User> getOne(Scanner scanner) {
        return service.getOne(scanner.next());
    }

    public User findUser(Scanner scan) {
        String userName = scan.next();
        return service.findUser(userName);
    }
}