package delivery.com.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = LAZY, cascade = REMOVE)
    @JoinColumn(name = "review_id")
    private Review review;

    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private int totalPrice;

    public static Order createOrder(Member member, Shop shop, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setShop(shop);
        order.member = member;
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
            order.totalPrice += orderItem.getOrderPrice();
        }
        return order;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    private void setShop(Shop shop) {
        this.shop = shop;
        shop.getOrders().add(this);
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
