package com.von.api.user;


import com.von.api.enums.UserRouter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scan) throws SQLException {
        UserController ctrl = new UserController();
        while (UserRouter.getInput(scan,ctrl));
    }
}
