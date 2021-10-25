package delivery.com.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInterestShop is a Querydsl query type for InterestShop
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInterestShop extends EntityPathBase<InterestShop> {

    private static final long serialVersionUID = 1345929827L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInterestShop interestShop = new QInterestShop("interestShop");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final QShop shop;

    public QInterestShop(String variable) {
        this(InterestShop.class, forVariable(variable), INITS);
    }

    public QInterestShop(Path<? extends InterestShop> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInterestShop(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInterestShop(PathMetadata metadata, PathInits inits) {
        this(InterestShop.class, metadata, inits);
    }

    public QInterestShop(Class<? extends InterestShop> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
        this.shop = inits.isInitialized("shop") ? new QShop(forProperty("shop")) : null;
    }

}

