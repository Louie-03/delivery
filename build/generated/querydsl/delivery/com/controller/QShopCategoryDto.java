package delivery.com.controller;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * delivery.com.controller.QShopCategoryDto is a Querydsl Projection type for ShopCategoryDto
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QShopCategoryDto extends ConstructorExpression<ShopCategoryDto> {

    private static final long serialVersionUID = -885196160L;

    public QShopCategoryDto(com.querydsl.core.types.Expression<String> shopName, com.querydsl.core.types.Expression<Long> shopId) {
        super(ShopCategoryDto.class, new Class<?>[]{String.class, long.class}, shopName, shopId);
    }

}

