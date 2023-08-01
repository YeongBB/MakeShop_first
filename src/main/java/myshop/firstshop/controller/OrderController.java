package myshop.firstshop.controller;

import lombok.RequiredArgsConstructor;
import myshop.firstshop.domain.Item;
import myshop.firstshop.domain.Member;
import myshop.firstshop.domain.Order;
import myshop.firstshop.service.ItemService;
import myshop.firstshop.service.MemberService;
import myshop.firstshop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ItemService itemService;
    private final MemberService memberService;

    @GetMapping("/order")
    public String createForm(Model model){
        List<Member> members = memberService.memberList();
        List<Item> items = itemService.itemList();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderFrom";
    }

    @PostMapping("orders")
    public String orderList(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId,
                                @RequestParam("count") int count){
        orderService.save(itemId,memberId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("itemId") String itemId,Model model){
        List<Order> orders = orderService.findByName(itemId);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

}
