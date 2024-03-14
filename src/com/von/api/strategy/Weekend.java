package com.von.api.strategy;

import java.util.Scanner;

public class Weekend {

    public static void main(String[] args) {
        System.out.println("1-7까지 입력");
        Scanner sc = new Scanner(System.in);
        String day  = WeekendStrategy.excute(sc);
        System.out.println("전략의 결과 : "+day);
    }

}