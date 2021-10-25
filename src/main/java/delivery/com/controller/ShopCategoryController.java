package delivery.com.controller;

import delivery.com.domain.ShopCategory;
import delivery.com.service.ReviewService;
import delivery.com.service.ShopCategoryService;
import delivery.com.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShopCategoryController {

    private final ShopService shopService;
    private final ShopCategoryService shopCategoryService;
    private final ReviewService reviewService;

    @GetMapping("/categories")
    public String categoryList(Model model, String searchName) {
        List<ShopCategoryDto> shopCategoryDtoList = shopService.shopSearch(searchName);
        for (ShopCategoryDto shopCategoryDto : shopCategoryDtoList) {
            shopCategoryDto.setReviewAvg(reviewService.findScoreAvgByShopId(shopCategoryDto.getShopId()));
            shopCategoryDto.setReviewCount(reviewService.findCountByShopId(shopCategoryDto.getShopId()));
        }

        model.addAttribute("shopCategoryDtoList", shopCategoryDtoList);
        model.addAttribute("shopCategories", shopCategoryService.findAll());
        return "shop/shops";
    }

    @GetMapping("/categories/{categoryId}")
    public String category(@PathVariable Long categoryId, Model model, String searchName) {
        List<ShopCategoryDto> shopCategoryDtoList = shopService.categoryInShopSearch(categoryId, searchName);
        for (ShopCategoryDto shopCategoryDto : shopCategoryDtoList) {
            shopCategoryDto.setReviewAvg(reviewService.findScoreAvgByShopId(shopCategoryDto.getShopId()));
            shopCategoryDto.setReviewCount(reviewService.findCountByShopId(shopCategoryDto.getShopId()));
        }

        model.addAttribute("shopCategoryDtoList", shopCategoryDtoList);
        model.addAttribute("shopCategories", shopCategoryService.findAll());
        return "shop/shops";
    }

}
