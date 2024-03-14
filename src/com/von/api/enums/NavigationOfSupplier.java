package com.von.api.enums;

import java.util.Scanner;
import java.util.function.Supplier;

public enum NavigationOfSupplier {
//    Exit("exit",()->""),
//    Crawler("crawler",i->""),
//    User("user",i->""),
//    Article("article",i->""),
//    Account("account",i->""),
//    Board("board",i->"")
    ;

    private final String name;
    private final Supplier<Scanner> supplier;

    NavigationOfSupplier(String name, Supplier<Scanner> supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    public static String select(Scanner scan) {
        return "";
    }
}
