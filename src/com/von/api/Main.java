package com.von.api;

import com.von.api.enums.NavigationOfConsumer;
import com.von.api.enums.NavigationOfFunction;
import com.von.api.enums.NavigationOfPredicate;
import com.von.api.enums.NavigationOfSupplier;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, SQLException {
        NavigationOfFunction.select(scan);
        //NavigationOfConsumer.select(scan);
        //NavigationOfSupplier.select(scan);
        //NavigationOfPredicate.select(scan);
        NavigationOfConsumer.select(scan);

//        boolean booleanFlag = NavigationOfPredicate.select(scan);
//        while(booleanFlag);

//        String strFlag = NavigationOfSupplier.select(scan);
//        while(strFlag.equals("x"));

        String strFlag2 = NavigationOfFunction.select(scan);
        while(!strFlag2.equals("x"));

    }
}