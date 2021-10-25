package delivery.com.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class BasketItem {

    @Id
    @GeneratedValue
    @Column(name = "basket_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int count;

    public BasketItem(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public int getBasketPrice() {
        int basketPrice = item.getPrice() * count;
        return basketPrice;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void addCount(int count) {
        this.count += count;
    }
}
