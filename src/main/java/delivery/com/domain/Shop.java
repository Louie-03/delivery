package delivery.com.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Shop {

    @Id
    @GeneratedValue
    @Column(name = "shop_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "shop")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "shop")
    private List<ItemCategory> itemCategories = new ArrayList<>();

    public Shop(String name) {
        this.name = name;
    }
}
