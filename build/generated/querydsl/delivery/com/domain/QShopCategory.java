package delivery.com.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QShopCategory is a Querydsl query type for ShopCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShopCategory extends EntityPathBase<ShopCategory> {

    private static final long serialVersionUID = -733374665L;

    public static final QShopCategory shopCategory = new QShopCategory("shopCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QShopCategory(String variable) {
        super(ShopCategory.class, forVariable(variable));
    }

    public QShopCategory(Path<? extends ShopCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShopCategory(PathMetadata metadata) {
        super(ShopCategory.class, metadata);
    }

}

