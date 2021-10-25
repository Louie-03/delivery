package delivery.com.repository.customRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import delivery.com.controller.BasketDto;
import delivery.com.controller.QBasketDto;
import delivery.com.domain.QBasketItem;

import javax.persistence.EntityManager;

import static delivery.com.domain.QBasket.*;
import static delivery.com.domain.QBasketItem.*;

public class BasketRepositoryCustomImpl implements BasketRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public BasketRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public BasketDto findDtoToItemByMemberId(Long memberId) {
        return queryFactory
                .select(new QBasketDto(basket))
                .from(basket)
                .join(basket.basketItems, basketItem).fetchJoin()
                .join(basketItem.item).fetchJoin()
                .where(basket.member.id.eq(memberId))
                .fetchOne();
    }
}
