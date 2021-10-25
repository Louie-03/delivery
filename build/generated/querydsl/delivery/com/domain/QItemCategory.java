package delivery.com.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemCategory is a Querydsl query type for ItemCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemCategory extends EntityPathBase<ItemCategory> {

    private static final long serialVersionUID = 979749460L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemCategory itemCategory = new QItemCategory("itemCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<ItemCategoryDetail, QItemCategoryDetail> itemCategoryDetails = this.<ItemCategoryDetail, QItemCategoryDetail>createList("itemCategoryDetails", ItemCategoryDetail.class, QItemCategoryDetail.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final QShop shop;

    public QItemCategory(String variable) {
        this(ItemCategory.class, forVariable(variable), INITS);
    }

    public QItemCategory(Path<? extends ItemCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItemCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItemCategory(PathMetadata metadata, PathInits inits) {
        this(ItemCategory.class, metadata, inits);
    }

    public QItemCategory(Class<? extends ItemCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new QShop(forProperty("shop")) : null;
    }

}

