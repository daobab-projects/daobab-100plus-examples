package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



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
    @SuppressWarnings("unchecked")
    default Column<E, F, CategoryId> colCategoryId() {
        return ColumnCache.INSTANCE.getColumn("CategoryId","CATEGORY_ID",(Table<?>)this,Integer.class);
    }

}
