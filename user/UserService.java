package user;


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
}