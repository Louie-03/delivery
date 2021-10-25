package delivery.com.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemCategoryDetail is a Querydsl query type for ItemCategoryDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemCategoryDetail extends EntityPathBase<ItemCategoryDetail> {

    private static final long serialVersionUID = -1698644027L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemCategoryDetail itemCategoryDetail = new QItemCategoryDetail("itemCategoryDetail");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QItem item;

    public final QItemCategory itemCategory;

    public QItemCategoryDetail(String variable) {
        this(ItemCategoryDetail.class, forVariable(variable), INITS);
    }

    public QItemCategoryDetail(Path<? extends ItemCategoryDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItemCategoryDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItemCategoryDetail(PathMetadata metadata, PathInits inits) {
        this(ItemCategoryDetail.class, metadata, inits);
    }

    public QItemCategoryDetail(Class<? extends ItemCategoryDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.item = inits.isInitialized("item") ? new QItem(forProperty("item")) : null;
        this.itemCategory = inits.isInitialized("itemCategory") ? new QItemCategory(forProperty("itemCategory"), inits.get("itemCategory")) : null;
    }

}

