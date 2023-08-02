package myshop.firstshop.service;

import myshop.firstshop.domain.Item;
import myshop.firstshop.domain.Member;
import myshop.firstshop.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired OrderService orderService;
    @Autowired MemberService memberService;
    @Autowired ItemService itemService;

    @Test
    @Transactional
    void save(){
        //given
        Member member = new Member("MemberA", "ids","passsss", LocalDateTime.now(), "01033334444", "em@em.com");
        memberService.join(member);

        Item item = new Item("ItemA", 1000, 10);
        itemService.saveItem(item);

        //when
        orderService.save(item.getId(), member.getId(), 5);

        //then
        Order orders = orderService.orders(1L);
        Assertions.assertThat(orders.getPrice()).isEqualTo(1000);

    }

}