package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

public interface CategoryId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getCategoryId() {
        return readParam("CategoryId");
    }

    default E setCategoryId(F val) {
        return storeParam("CategoryId", val);
    }

    /**
     * table:CATEGORY,type:TINYINT,size:8,nullable:false
     * table:FILM_CATEGORY,type:TINYINT,size:8,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, CategoryId> colCategoryId() {
        return ColumnCache.INSTANCE.getColumn("CategoryId", "CATEGORY_ID", (Table<?>) this, Integer.class);
    }

}
