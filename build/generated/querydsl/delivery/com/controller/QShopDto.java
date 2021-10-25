package delivery.com.controller;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * delivery.com.controller.QShopDto is a Querydsl Projection type for ShopDto
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QShopDto extends ConstructorExpression<ShopDto> {

    private static final long serialVersionUID = -908843170L;

    public QShopDto(com.querydsl.core.types.Expression<? extends delivery.com.domain.Shop> shop) {
        super(ShopDto.class, new Class<?>[]{delivery.com.domain.Shop.class}, shop);
    }

}

