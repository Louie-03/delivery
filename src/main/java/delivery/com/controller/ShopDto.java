package delivery.com.controller;

import com.querydsl.core.annotations.QueryProjection;
import delivery.com.domain.ItemCategory;
import delivery.com.domain.Shop;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShopDto {

    private String shopName;
    private Long shopId;
    private List<ItemCategoryDto> itemCategoryDtoList = new ArrayList<>();

    private Double reviewAvg;
    private Long reviewCount;
    private Long interestShopCount;

    @QueryProjection
    public ShopDto(Shop shop) {
        shopId = shop.getId();
        shopName = shop.getName();
        for (ItemCategory itemCategory : shop.getItemCategories()) {
            itemCategoryDtoList.add(new ItemCategoryDto(itemCategory));
        }
    }
}
