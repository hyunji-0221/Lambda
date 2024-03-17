package com.von.api.user;

import com.von.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;
    private PreparedStatement pstmt;
    private ResultSet rs;
    Connection connection;


    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private UserRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/adadb"
                , "ada"
                , "ada");
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
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .pNum(rs.getString("pNum"))
                        .job(rs.getString("job"))
                        .height(rs.getDouble("height"))
                        .weight(rs.getDouble("weight"))
                        .build()
                );
//                System.out.printf("ID : %d\t userName : %s\t password : %s\t name : %s\t" +
//                                " pNum : %s\t job : %s\t height : %s\t weight : %s\n",
//                        rs.getInt("id"),
//                        rs.getString("userName"),
//                        rs.getString("password"),
//                        rs.getString("name"),
//                        rs.getString("pNum"),
//                        rs.getString("job"),
//                        rs.getString("height"),
//                        rs.getString("weight"));
            }
            while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }

        return ls;
    }

    public Messenger createTable() throws SQLException {
        String sql = "CREATE TABLE users(" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "userName VARCHAR(20) NOT NULL,\n" +
                "password VARCHAR(20) NOT NULL,\n" +
                "name VARCHAR(20),\n" +
                "pNum VARCHAR(20),\n" +
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
