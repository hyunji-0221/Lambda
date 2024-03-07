package user;

import java.sql.*;
import java.util.List;

public class UserRepository {

    private static UserRepository instance;

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
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository 연결";
    }


    public List<User> findUsers() throws SQLException {
        String sql = "SELECT * FROM board";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs =  pstmt.executeQuery();
        if (rs.next()){
            do{
                System.out.printf("ID : %d\t Title : %s\t Content : %s\t Writer : %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
            }
            while (rs.next());
        }else{
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        connection.close();

        return null;
    }
}
