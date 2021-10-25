package delivery.com.controller;

import delivery.com.domain.BasketItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketItemDto {

    private Long basketItemId;
    private ItemDto itemDto;
    private int basketPrice;
    private int count;

    public BasketItemDto(BasketItem basketItem) {
        basketItemId = basketItem.getId();
        itemDto = new ItemDto(basketItem.getItem().getId(), basketItem.getItem().getName(), basketItem.getItem().getPrice());
        basketPrice = basketItem.getBasketPrice();
        count = basketItem.getCount();
    }
}
