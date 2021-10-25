package delivery.com.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ShopCategoryDetail {

    @Id
    @GeneratedValue
    @Column(name = "shop_category_detail_id")
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = "shop_category_id")
    private ShopCategory shopCategory;

    public ShopCategoryDetail(Shop shop, ShopCategory shopCategory) {
        this.shop = shop;
        this.shopCategory = shopCategory;
    }
}
