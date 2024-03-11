package com.von.api.board;


import com.von.api.common.UtilService;
import com.von.api.common.UtilServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardView {
    public static void main(Scanner scan) throws SQLException {
        List<Board> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();

//        for(int i=0;i<5;i++){
//            articles.add(Board.builder()
//                    .(util.createRandomTitle())
//                    .content(util.createRandomContent())
//                    .writer(util.createRandomName())
//                    .build())
//            ;
//        }
//
//        articles.forEach(i ->{
//            System.out.println(i.toString());
//        });

        while(true){
            System.out.println("0-종료 1-article로 가기");

            switch (scan.next()){
                case "0" :
                    System.out.println("종료되었습니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }

    }
}
