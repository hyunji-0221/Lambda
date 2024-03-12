package com.von.api.user;

import com.von.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;
    private PreparedStatement pstmt;
    private ResultSet rs;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection connection;

    private UserRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/adadb"
                , "root"
                , "rootroot");
        pstmt = null;
        rs = null;
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository 연결";
    }


    public List<User> findUsers() throws SQLException {
        String sql = "SELECT * FROM users";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<User> ls = new ArrayList<>();
        if (rs.next()) {
            do {
                ls.add(User.builder()
                        .id(rs.getLong("id"))
                        .userName(rs.getString("userName"))
                        .password(rs.getString("userName"))
                        .name(rs.getString("userName"))
                        .userName(rs.getString("userName"))
                        .pNum(rs.getString("pNum"))
                        .job(rs.getString("job"))
                        .height(rs.getDouble("height"))
                        .weight(rs.getDouble("weight"))
                        .build()
                );
                System.out.printf("ID : %d\t Title : %s\t Content : %s\t Writer : %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
            }
            while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }

        return null;
    }

    public Messenger createTable() throws SQLException {
        String sql = "CREATE TABLE users(" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "username VARCHAR(20) NOT NULL,\n" +
                "password VARCHAR(20) NOT NULL,\n" +
                "name VARCHAR(20),\n" +
                "phone VARCHAR(20),\n" +
                "job VARCHAR(20),\n" +
                "height VARCHAR(20),\n" +
                "weight VARCHAR(20))";
        pstmt = connection.prepareStatement(sql);
        int result = pstmt.executeUpdate();


        return (result == 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public Messenger deleteTable() throws SQLException {
        String sql = "drop table users";
        pstmt = connection.prepareStatement(sql);
        int result = pstmt.executeUpdate();

        pstmt.close();
        connection.close();

        return (result == 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }
}
