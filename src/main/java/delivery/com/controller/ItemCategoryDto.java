package delivery.com.controller;

import delivery.com.domain.Item;
import delivery.com.domain.ItemCategory;
import delivery.com.domain.ItemCategoryDetail;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemCategoryDto {

    private String itemCategoryName;
    private List<ItemDto> itemDtoList = new ArrayList<>();

    public ItemCategoryDto(ItemCategory itemCategory) {
        itemCategoryName = itemCategory.getName();
        for (ItemCategoryDetail itemCategoryDetail : itemCategory.getItemCategoryDetails()) {
            Item item = itemCategoryDetail.getItem();
            itemDtoList.add(new ItemDto(item.getId(), item.getName(), item.getPrice()));
        }
    }
}
