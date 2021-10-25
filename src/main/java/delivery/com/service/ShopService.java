package delivery.com.service;

import delivery.com.controller.ShopCategoryDto;
import delivery.com.domain.Shop;
import delivery.com.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public Shop findShop(Long shopId) {
        return shopRepository.findById(shopId).orElseGet(null);
    }

    public List<ShopCategoryDto> shopSearch(String searchName) {
        return shopRepository.findDtoByNameAndItemNameContains(searchName);
    }

    public List<ShopCategoryDto> categoryInShopSearch(Long shopCategoryId, String searchName) {
        List<Long> shopIdList = shopRepository.findShopIdListByShopCategoryId(shopCategoryId);
        return shopRepository.findDtoByShopCategoryIdInAndNameAndItemNameContains(searchName, shopIdList);
    }

    public List<Shop> findByShopCategoryId(Long shopCategoryId) {
        return shopRepository.findByShopCategoryId(shopCategoryId);
    }
}
