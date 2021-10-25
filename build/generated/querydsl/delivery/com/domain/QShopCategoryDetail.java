package delivery.com.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopCategoryDetail is a Querydsl query type for ShopCategoryDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShopCategoryDetail extends EntityPathBase<ShopCategoryDetail> {

    private static final long serialVersionUID = 1573000808L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopCategoryDetail shopCategoryDetail = new QShopCategoryDetail("shopCategoryDetail");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QShop shop;

    public final QShopCategory shopCategory;

    public QShopCategoryDetail(String variable) {
        this(ShopCategoryDetail.class, forVariable(variable), INITS);
    }

    public QShopCategoryDetail(Path<? extends ShopCategoryDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopCategoryDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopCategoryDetail(PathMetadata metadata, PathInits inits) {
        this(ShopCategoryDetail.class, metadata, inits);
    }

    public QShopCategoryDetail(Class<? extends ShopCategoryDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new QShop(forProperty("shop")) : null;
        this.shopCategory = inits.isInitialized("shopCategory") ? new QShopCategory(forProperty("shopCategory")) : null;
    }

}

