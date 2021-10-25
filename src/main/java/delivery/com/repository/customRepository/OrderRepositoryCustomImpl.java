package delivery.com.repository.customRepository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import delivery.com.domain.*;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static delivery.com.domain.QItem.*;
import static delivery.com.domain.QMember.*;
import static delivery.com.domain.QOrder.*;
import static delivery.com.domain.QOrderItem.*;
import static org.springframework.util.StringUtils.*;

public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public OrderRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Order> findOrderWithAll() {
        return queryFactory
                .selectFrom(order)
                .join(order.member, member).fetchJoin()
                .join(order.orderItems, orderItem).fetchJoin()
                .join(orderItem.item, item).fetchJoin()
                .fetch();
    }

    @Override
    public List<Order> findByMemberId(Long memberId) {
        return queryFactory
                .selectFrom(order)
                .join(order.member).fetchJoin()
                .join(order.review).fetchJoin()
                .join(order.orderItems, orderItem).fetchJoin()
                .join(orderItem.item).fetchJoin()
                .where(order.member.id.eq(memberId))
                .fetch();
    }

    @Override
    public List<Order> findByShopId(Long shopId) {
        return queryFactory
                .selectFrom(order)
                .join(order.member).fetchJoin()
                .join(order.review).fetchJoin()
                .join(order.orderItems, orderItem).fetchJoin()
                .join(orderItem.item).fetchJoin()
                .where(order.shop.id.eq(shopId))
                .fetch();
    }

    @Override
    public List<Order> dynamicFindByMemberId(Long memberId) {
        return queryFactory
                .selectFrom(order)
                .join(order.member, member).fetchJoin()
                .join(order.shop).fetchJoin()
                .join(order.orderItems).fetchJoin()
                .where(memberIdEq(memberId))
                .fetch();
    }

    private BooleanExpression memberIdEq(Long memberId) {
        return isEmpty(memberId) ? null : member.id.eq(memberId);
    }
}
