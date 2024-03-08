package user;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    String addUsers();
    String login(User user);

    String changePassword(User user);

    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);

    List<?> findUsersByJob(String job);

    Map<String, ?> findUsersByJobFromMap(String job);

    Map<String, ?> getUserMap();

    String test();


    User findUser(String userName);

    List<User> findUsers() throws SQLException;

    void createTable() throws SQLException;

    void deleteTable() throws SQLException;
}
