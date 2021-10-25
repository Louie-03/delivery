package delivery.com.repository.customRepository;

import delivery.com.controller.ShopCategoryDto;
import delivery.com.controller.ShopDto;

import java.util.List;

public interface ShopRepositoryCustom {
    List<ShopCategoryDto> findDtoByNameAndItemNameContains(String name);
    List<ShopCategoryDto> findDtoByShopCategoryIdInAndNameAndItemNameContains(String name, List<Long> shopIdList);
    ShopDto findToItemById(Long id);
    List<Long> findShopIdListByShopCategoryId(Long shopCategoryId);
}
