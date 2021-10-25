package delivery.com.controller;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * delivery.com.controller.QInterestShopDto is a Querydsl Projection type for InterestShopDto
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QInterestShopDto extends ConstructorExpression<InterestShopDto> {

    private static final long serialVersionUID = 1656582100L;

    public QInterestShopDto(com.querydsl.core.types.Expression<Long> shopId, com.querydsl.core.types.Expression<String> shopName, com.querydsl.core.types.Expression<String> memberName) {
        super(InterestShopDto.class, new Class<?>[]{long.class, String.class, String.class}, shopId, shopName, memberName);
    }

}

