package delivery.com.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    private Long itemId;
    private String name;
    private int price;

    public ItemDto(Long itemId, String name, int price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }
}
