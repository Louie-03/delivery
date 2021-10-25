package delivery.com.controller;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * delivery.com.controller.QBasketDto is a Querydsl Projection type for BasketDto
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QBasketDto extends ConstructorExpression<BasketDto> {

    private static final long serialVersionUID = -1030400690L;

    public QBasketDto(com.querydsl.core.types.Expression<? extends delivery.com.domain.Basket> basket) {
        super(BasketDto.class, new Class<?>[]{delivery.com.domain.Basket.class}, basket);
    }

}

