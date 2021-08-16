package project.shoesUp.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class UpcomingCrawler {
    public static void main(String[] args) throws IOException {
        String url = "https://www.nike.com/kr/launch/?type=upcoming";

        Document doc = Jsoup.connect(url).get();

        Elements el_drawMonth = doc.getElementsByAttributeValueContaining("class", "headline-4");
        Elements el_drawDate = doc.getElementsByAttributeValueContaining("class", "headline-1");
        Elements el_name = doc.getElementsByAttributeValueContaining("class", "headline-3");
        Elements el_releaseTime = doc.getElementsByAttributeValueContaining("class", "div.headline-5");
        Elements el_releaseTime2 = doc.select("div.copy-container h3.headline-5");

        System.out.println(el_drawMonth.size());

        System.out.println(el_releaseTime2.getClass().getName());

        System.out.println("======================");
        for(int i = 0; i<el_name.size(); i++){

            System.out.println("출시 월: "+el_drawMonth.get(i).text());
            System.out.println("출시 일: "+el_drawDate.get(i).text());
            System.out.println("제품 명: "+el_name.get(i).text());
            System.out.println("출시 시간: "+el_releaseTime2.get(i).text());
            System.out.println("===================================");
        }
    }
}
