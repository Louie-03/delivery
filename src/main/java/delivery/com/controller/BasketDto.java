package delivery.com.controller;

import com.querydsl.core.annotations.QueryProjection;
import delivery.com.domain.Basket;
import delivery.com.domain.BasketItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BasketDto {

    private Long basketId;
    private Long memberId;
    private Long shopId;
    private List<BasketItemDto> basketItemDtoList = new ArrayList<>();

    @QueryProjection
    public BasketDto(Basket basket) {
        basketId = basket.getId();
        memberId = basket.getMember().getId();
        shopId = basket.getShop().getId();
        for (BasketItem basketItem : basket.getBasketItems()) {
            basketItemDtoList.add(new BasketItemDto(basketItem));
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (BasketItemDto basketItemDto : basketItemDtoList) {
            totalPrice += basketItemDto.getBasketPrice();
        }
        return totalPrice;
    }
}
