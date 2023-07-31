package myshop.firstshop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private int quantity;       // 주문 수량
    private int price;          // 주문 가격
    private LocalDateTime localDateTime;        // 주문 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public Order(int quantity, int price, LocalDateTime localDateTime, Member member, Item item) {
        this.quantity = quantity;
        this.price = price;
        this.localDateTime = localDateTime;
        this.member = member;
        this.item = item;
    }
}
