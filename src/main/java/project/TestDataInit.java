package project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.shoesUp.item.Item;
import project.shoesUp.item.ItemRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", "8/19"));
        itemRepository.save(new Item("itemB", "8/21"));
    }
}
