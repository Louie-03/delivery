package delivery.com.controller;

import com.querydsl.core.annotations.QueryProjection;
import delivery.com.domain.ItemCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopCategoryDto {

    private Long shopId;
    private String shopName;
    private Double reviewAvg;
    private Long reviewCount;

    @QueryProjection
    public ShopCategoryDto(String shopName, Long shopId) {
        this.shopName = shopName;
        this.shopId = shopId;
    }
}
