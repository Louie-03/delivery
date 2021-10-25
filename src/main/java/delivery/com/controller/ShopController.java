package delivery.com.controller;

import delivery.com.domain.Basket;
import delivery.com.repository.BasketRepository;
import delivery.com.repository.ShopRepository;
import delivery.com.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;
    private final MemberService memberService;
    private final ShopRepository shopRepository;
    private final ReviewService reviewService;
    private final BasketRepository basketRepository;
    private final InterestShopService interestShopService;

    @GetMapping("/shops/{shopId}")
    public String shop(@PathVariable Long shopId, Long memberId, Model model) {
        ShopDto shopDto = shopRepository.findToItemById(shopId);
        shopDto.setReviewAvg(reviewService.findScoreAvgByShopId(shopId));
        shopDto.setReviewCount(reviewService.findCountByShopId(shopId));
        shopDto.setInterestShopCount(interestShopService.findCountByShopId(shopId));

        Basket basket = null;
        if (memberId != null) {
            basket = basketRepository.findByMemberId(memberId);
        }

        model.addAttribute("shopDto", shopDto);
        model.addAttribute("basket", basket);
        model.addAttribute("members", memberService.findAll());
        return "shop/shop";
    }
}
