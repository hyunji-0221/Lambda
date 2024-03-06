package crawler;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner scan) throws IOException {
        CrawlerController controller = new CrawlerController();

        while (true) {
            System.out.println("[메뉴] 0-종료\n" +
                    "1-벅스뮤직\n" +
                    "벅스뮤직 결과\n" +
                    "2-로그인\n" +
                    "로그인 결과\n" +
                    "3-ID 검색\n");
            switch (scan.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("======= 회원가입 =======");
                    Map<String, ?> map = controller.findBugsMusic(scan);
                    Iterator<Element> title = (Iterator<Element>) map.get("title");
                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");
                    Iterator<Element> rank = (Iterator<Element>) map.get("rank");
                    System.out.println("벅스뮤직 결과 : ");
                    while(rank.hasNext()){
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("======= 로그인 =======");

                    break;
                case "3":
                    System.out.println("======= ID검색 =======");

                    break;

            }
        }

    }

}
