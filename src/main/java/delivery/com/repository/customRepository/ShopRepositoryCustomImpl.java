package delivery.com.repository.customRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import delivery.com.controller.QShopCategoryDto;
import delivery.com.controller.QShopDto;
import delivery.com.controller.ShopCategoryDto;
import delivery.com.controller.ShopDto;
import delivery.com.domain.*;

import javax.persistence.EntityManager;
import java.util.List;

import static delivery.com.domain.QItem.*;
import static delivery.com.domain.QItemCategory.*;
import static delivery.com.domain.QItemCategoryDetail.*;
import static delivery.com.domain.QShop.*;
import static delivery.com.domain.QShopCategoryDetail.*;
import static org.springframework.util.StringUtils.*;

public class ShopRepositoryCustomImpl implements ShopRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public ShopRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ShopCategoryDto> findDtoByNameAndItemNameContains(String name) {
        return queryFactory
                .from(item)
                .select(new QShopCategoryDto(shop.name, shop.id)).distinct()
                .join(item.itemCategoryDetails, itemCategoryDetail)
                .join(itemCategoryDetail.itemCategory.shop, shop)
                .where(itemNameAndShopNameContains(name))
                .fetch();
    }

    @Override
    public List<ShopCategoryDto> findDtoByShopCategoryIdInAndNameAndItemNameContains(String name, List<Long> shopIdList) {
        return queryFactory
                .select(new QShopCategoryDto(shop.name, shop.id)).distinct()
                .from(item)
                .join(item.itemCategoryDetails, itemCategoryDetail)
                .join(itemCategoryDetail.itemCategory.shop, shop)
                .where(shop.id.in(shopIdList).and(itemNameAndShopNameContains(name)))
                .fetch();
    }

    @Override
    public ShopDto findToItemById(Long id) {
        return queryFactory
                .select(new QShopDto(shop)).distinct()
                .from(shop)
                .join(shop.itemCategories, itemCategory)
                .join(itemCategory.itemCategoryDetails, itemCategoryDetail)
                .join(itemCategoryDetail.item)
                .where(shop.id.eq(id))
                .fetchOne();
    }

    @Override
    public List<Long> findShopIdListByShopCategoryId(Long shopCategoryId) {
        return queryFactory
                .select(shopCategoryDetail.shop.id)
                .from(shopCategoryDetail)
                .where(shopCategoryDetail.shopCategory.id.eq(shopCategoryId))
                .fetch();
    }

    private BooleanBuilder itemNameAndShopNameContains(String name) {
        return itemNameContains(name).or(shopNameContains(name));
    }

    private BooleanBuilder itemNameContains(String name) {
        return isEmpty(name) ? new BooleanBuilder() : new BooleanBuilder(item.name.contains(name));
    }
    private BooleanBuilder shopNameContains(String name) {
        return isEmpty(name) ? new BooleanBuilder() : new BooleanBuilder(shop.name.contains(name));
    }
}
