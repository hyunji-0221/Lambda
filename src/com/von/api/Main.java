package com.von.api;

import com.von.api.enums.*;
import com.von.api.menu.Menu;
import com.von.api.menu.MenuController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, SQLException {
//        MenuController.getInstance().makeMenuTable();



//        NavigationOfPredicate.select(scan);

//        boolean booleanFlag = NavigationOfPredicate.select(scan);
//        while(booleanFlag);

//        String strFlag = NavigationOfSupplier.select(scan);
//        while(strFlag.equals("x"));

/**
 * 강사님 풀이..
 */
//        Messenger msg = MenuController.getInstance().returnMessenger();
//        Menu oneMenu = MenuController.getInstance().returnOneMenu();
//        List<?> allMenu = MenuController.getInstance().returnAllMenus();

        //add


        String strFlag2 = NavigationOfFunction.select(scan);
        while(!strFlag2.equals("x"));

    }
}