package com.von.api.user;

import com.von.api.common.AbstractService;
import com.von.api.common.UtilService;
import com.von.api.common.UtilServiceImpl;
import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    UserRepository repository;
    private static UserServiceImpl instance = new UserServiceImpl();
    Map<String, User> users;

    private UserServiceImpl() {
        this.users = new HashMap<>();
        this.repository = UserRepository.getInstance();
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    @Override
    public Messenger save(User user) {
        users.put(user.getUserName(),user);
        return Messenger.SUCCESS;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return users.size()+"";
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(User user) {
        users.remove(user.getUserName());
        return "회원삭제";
    }

    @Override
    public String deleteAll() {
        return "";
    }

    @Override
    public Boolean existById(Long id) {
        return users.containsKey(id);
    }




    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUserName(), User.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ? "로그인 성공" : "로그인 실패";
    }

    public Map<String, ?>   findUserByNameFromMap(String name){
        return users.entrySet()
                .stream()
                .filter(i->i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return users.values()
                .stream()
                .filter(i->i.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return users.entrySet()
                .stream()
                .filter(i ->i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    @Override
    public String changePassword(User user) {
        users.get(user.getUserName()).setPassword(user.getPassword());
        return "비번 변경 성공";
    }

    @Override
    public List<?> findUsersByName(String name) {
        return users
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public Map<String, ?> getUserMap() {
        return users;
    }

    @Override
    public String test() {
        return repository.test();
    }

    @Override
    public User findUser(String userName) {
        //return repository.findUser();
        return null;
    }

    @Override
    public List<User> findUsers() throws SQLException {
        return repository.findUsers();
    }

    @Override
    public Messenger createTable() throws SQLException {
        repository.createTable();
        return Messenger.SUCCESS;
    }

    @Override
    public Messenger deleteTable() throws SQLException {
        repository.deleteTable();
        return Messenger.FAIL   ;
    }


    public List<?> findUserByName(String name){
        return users.values()
                .stream()
                .filter(i->i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public String addUsers() {
        return null;
    }
}
