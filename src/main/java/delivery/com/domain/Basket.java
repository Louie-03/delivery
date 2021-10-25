package delivery.com.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Basket {

    @Id
    @GeneratedValue
    @Column(name = "basket_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToMany(mappedBy = "basket", cascade = ALL)
    private List<BasketItem> basketItems = new ArrayList<>();

    public int getTotalPrice() {
        int totalPrice = 0;
        for (BasketItem basketItem : basketItems) {
            totalPrice += basketItem.getBasketPrice();
        }
        return totalPrice;
    }

    public void addBasketItem(BasketItem basketItem) {
        basketItems.add(basketItem);
        basketItem.setBasket(this);
    }

    public Basket(Member member) {
        this.member = member;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
