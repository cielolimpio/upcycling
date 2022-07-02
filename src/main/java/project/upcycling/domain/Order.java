package project.upcycling.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;
import static project.upcycling.domain.OrderStatus.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private int orderPrice;
    private int count;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public Order(int orderPrice, int count, Member member, Item item) {
        orderDate = LocalDateTime.now();
        orderStatus = FUNDING_READY;
        this.orderPrice = orderPrice;
        this.count = count;
        this.member = member;
        delivery = new Delivery(member.getAddress());
        this.item = item;
    }

    public Order(int orderPrice, int count, Member member, Address address, Item item) {
        orderDate = LocalDateTime.now();
        orderStatus = FUNDING_READY;
        this.orderPrice = orderPrice;
        this.count = count;
        this.member = member;
        this.delivery = new Delivery(address);
        this.item = item;
    }
}
