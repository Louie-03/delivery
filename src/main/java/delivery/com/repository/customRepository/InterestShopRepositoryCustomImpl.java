package delivery.com.repository.customRepository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import delivery.com.controller.InterestShopDto;
import delivery.com.controller.QInterestShopDto;
import delivery.com.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static delivery.com.domain.QInterestShop.*;
import static delivery.com.domain.QMember.*;
import static delivery.com.domain.QShop.*;
import static org.springframework.util.StringUtils.*;

public class InterestShopRepositoryCustomImpl implements InterestShopRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public InterestShopRepositoryCustomImpl(EntityManager em) {
        this.em = em;
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<InterestShopDto> findAllNameByMemberId(Long memberId) {
        return queryFactory
                .select(new QInterestShopDto(shop.id, shop.name, member.name))
                .from(interestShop)
                .join(interestShop.member, member)
                .join(interestShop.shop, shop)
                .where(memberIdEq(memberId))
                .fetch();
    }

    private BooleanExpression memberIdEq(Long memberId) {
        return isEmpty(memberId) ? null : member.id.eq(memberId);
    }
}
