package delivery.com.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ItemCategoryDetail {

    @Id
    @GeneratedValue
    @Column(name = "item_category_detail_id")
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = "item_category_id")
    private ItemCategory itemCategory;

    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = "item_id")
    private Item item;

    public ItemCategoryDetail(ItemCategory itemCategory, Item item) {
        this.itemCategory = itemCategory;
        this.item = item;
    }
}
