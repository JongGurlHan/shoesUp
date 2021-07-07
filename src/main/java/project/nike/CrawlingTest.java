package project.nike;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CrawlingTest {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.nike.com/kr/launch/?type=upcoming").get();
        Elements el_drawMonth = doc.getElementsByAttributeValueContaining("class", "headline-4");
        Elements el_drawDate = doc.getElementsByAttributeValueContaining("class", "headline-1");
        Elements el_name = doc.getElementsByAttributeValueContaining("class", "headline-3");
        Elements el_releaseTime = doc.getElementsByAttributeValueContaining("class", "headline-5");

//        원하는 정보 찾기
//        getElementById
//        getElementByTag
        // getElementsByAttributeValueContaining
        //getElementByClass
        //getElementByAttribute


        for(int i = 0; i<el_name.size(); i++){
            System.out.println(el_drawMonth.get(i).text());
            System.out.println(el_drawDate.get(i).text());
            System.out.println(el_name.get(i).text());
            System.out.println(el_releaseTime.get(i).text());
            System.out.println("===================================");
        }
    }
}
