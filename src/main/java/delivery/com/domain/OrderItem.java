package delivery.com.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;
    private int count;

    public OrderItem(Item item, int count) {
        this.item = item;
        this.count = count;
        this.orderPrice = item.getPrice() * count;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
