package com.von.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;

public enum NavigationOfConsumer {
    Exit("exit",i->{

    }),
    Crawler("crawler",i->{

    }),
    User("user",i->{

    }),
    Article("article",i->{

    }),
    Account("account",i->{

    }),
    Board("board",i->{

    });

    private final String name;
    private final Consumer<Scanner> consumer;

    NavigationOfConsumer(String name, Consumer<Scanner> consumer) {
        this.name = name;
        this.consumer = consumer;
    }


    public static void select(Scanner scan) {
    }
}
