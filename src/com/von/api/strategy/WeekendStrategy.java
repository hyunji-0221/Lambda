package com.von.api.strategy;


import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {
    Monday("monday",i->"monday"),
    Tuesday("Tuesday",i->"Tuesday"),
    Wendseday("Wendseday",i->"Wendseday"),
    Thursday("Thursday",i->"Thursday"),
    Friday("Friday",i->"Friday"),
    Saturday("Saturday",i->"Saturday"),
    Sunday("Sunday",i->"Sunday"),
    Wrong("Wrong",i->"Wrong")
    ;

    private final String name;
    private final Function<String,String> function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String excute(Scanner sc) {
        String str = sc.next();
        return Stream.of(values())
                .filter(i->i.name.equals(str))
                .findAny().orElseGet(()->Wrong)
                .function.apply(str);
    }
}
