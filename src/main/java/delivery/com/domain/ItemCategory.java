package delivery.com.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ItemCategory {

    @Id
    @GeneratedValue
    @Column(name = "item_category_id")
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToMany(mappedBy = "itemCategory")
    private List<ItemCategoryDetail> itemCategoryDetails = new ArrayList<>();

    private String name;

    public ItemCategory(Shop shop, String name) {
        this.name = name;
        setShop(shop);
    }

    private void setShop(Shop shop) {
        this.shop = shop;
        shop.getItemCategories().add(this);
    }
}
