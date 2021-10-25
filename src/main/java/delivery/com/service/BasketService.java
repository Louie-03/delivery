package delivery.com.service;

import delivery.com.domain.Basket;
import delivery.com.domain.BasketItem;
import delivery.com.domain.Item;
import delivery.com.domain.Shop;
import delivery.com.repository.BasketItemRepository;
import delivery.com.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;
    private final ShopService shopService;
    private final ItemService itemService;

    @Transactional
    public void addBasketItem(Long shopId, Long memberId, Long itemId, int count) {
        Shop shop = shopService.findShop(shopId);
        Item item = itemService.findItem(itemId);
        Basket basket = findByMemberId(memberId);

        if (basket.getShop() != null && basket.getShop() != shop) {
            clearBasket(basket);
        }

        basket.setShop(shop);

        BasketItem newBasketItem = new BasketItem(item, count);
        if (basket.getBasketItems().isEmpty()) {
            basket.addBasketItem(newBasketItem);
        }else {
            boolean check = true;
            for (BasketItem basketItem : basket.getBasketItems()) {
                System.out.println("check = " + check);
                if (basketItem.getItem() == item) {
                    basketItem.addCount(count);
                    check = false;
                    break;
                }
            }
            if (check) {
                basket.addBasketItem(newBasketItem);
            }
        }
    }

    @Transactional
    public void clearBasket(Basket basket) {
        for (BasketItem basketItem : basket.getBasketItems()) {
            basketItemRepository.delete(basketItem);
        }
    }

    public Basket findBasket(Long basketId) {
        return basketRepository.findById(basketId).orElseGet(null);
    }

    public Basket findByMemberId(Long memberId) {
        return basketRepository.findByMemberId(memberId);
    }

}
