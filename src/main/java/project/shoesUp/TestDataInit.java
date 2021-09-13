package project.shoesUp;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import project.shoesUp.domain.item.Item;
import project.shoesUp.domain.item.ItemRepository;
import project.shoesUp.domain.member.Member;
import project.shoesUp.domain.member.MemberRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;


    @PostConstruct
    public void init() throws IOException {

        Member member = new Member();
//        member.setLoginId("test");
//        member.setPassword("test!");
//        member.setName("테스터");
//        memberRepository.save(member);


        String url = "https://www.nike.com/kr/launch/?type=upcoming";

        Document doc = Jsoup.connect(url).get();

        Elements el_drawMonth = doc.getElementsByAttributeValueContaining("class", "headline-4"); //출시월
        Elements el_drawDate = doc.getElementsByAttributeValueContaining("class", "headline-1"); //출시일
        Elements el_name = doc.getElementsByAttributeValueContaining("class", "headline-3"); //제품명
        Elements el_releaseTime = doc.select("div.copy-container h3.headline-5"); //출시시간
        Elements el_imgUrl = doc.select("div.product-card div.ncss-col-sm-12 a.card-link img.img-component");



        for(int i = 0; i<el_name.size(); i++){
            itemRepository.save(new Item(String.valueOf(el_name.get(i).text()),
                    String.valueOf(el_drawMonth.get(i).text()) +String.valueOf(el_drawDate.get(i).text()),
                        String.valueOf(el_imgUrl.get(i).attr("data-src")),
                        String.valueOf(el_releaseTime.get(i).text())
                    )
            );
        }

    }
}
