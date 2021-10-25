package delivery.com.controller;

import delivery.com.domain.Basket;
import delivery.com.domain.Item;
import delivery.com.service.BasketService;
import delivery.com.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ItemService itemService;

    @GetMapping("/basketItems/new")
    public String addBasketItem() {
        return "basket/basketItemForm";
    }

    @PostMapping("/basketItems/new")
    public String addBasketItem(Long shopId, Long itemId, Long memberId, int count) {
        basketService.addBasketItem(shopId, memberId, itemId, count);
        return "redirect:/shops/" + shopId.toString() + "?memberId=" + memberId.toString();
    }
}
