package myshop.firstshop.service;

import myshop.firstshop.domain.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired ItemService itemService;

    @Test
    void save(){
        //given
        Item item = new Item("ItemA", 10000, 10);

        //when
        itemService.saveItem(item);

        //then
        Item findItem = itemService.findItem(item.getId());
        Assertions.assertThat(findItem.getName()).isEqualTo(item.getName());
    }


    @Test
    @Transactional
    void update(){
        //given
        Item item = new Item("ItemA", 10000, 10);
        itemService.saveItem(item);

        //when
        Item findItem = itemService.findItem(item.getId());
        itemService.updateItem(findItem.getId(), "ItemB",20000, 20);

        //then
        Item resultItem = itemService.findItem(1L);
        Assertions.assertThat(resultItem.getName()).isEqualTo("ItemB");

    }
}