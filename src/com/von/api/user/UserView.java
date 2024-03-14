package com.von.api.user;


import com.von.api.enums.UserRouterOfFunction;
import com.von.api.enums.UserRouterOfPredicate;

import java.sql.SQLException;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scan) throws SQLException {
//        while (UserRouterOfPredicate.getInput(scan));

        String strFlag = UserRouterOfFunction.select(scan);
        while(!strFlag.equals("exit"));

    }
}
