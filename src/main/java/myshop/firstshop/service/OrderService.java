package myshop.firstshop.service;

import lombok.RequiredArgsConstructor;
import myshop.firstshop.domain.Item;
import myshop.firstshop.domain.Member;
import myshop.firstshop.domain.Order;
import myshop.firstshop.repository.ItemRepository;
import myshop.firstshop.repository.MemberRepository;
import myshop.firstshop.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void save(Long itemId, Long memberId, int count){
        Member member = memberRepository.findById(memberId).get();
        Item item = itemRepository.findById(itemId).get();

        Order order = new Order(count, item.getPrice(), LocalDateTime.now(), member,item);
        orderRepository.save(order);
    }

    public Order orders(Long id){
        return orderRepository.findById(id).get();
    }

    public List<Order> findByName(String name){
        return orderRepository.findByname(name);
    }
}
