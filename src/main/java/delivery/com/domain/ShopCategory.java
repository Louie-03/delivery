package delivery.com.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ShopCategory {

    @Id
    @GeneratedValue
    @Column(name = "shop_category_id")
    private Long id;

    @Column(unique = true)
    private String name;

    public ShopCategory(String name) {
        this.name = name;
    }
}
