package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface CategoryId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getCategoryId(){
		return readParam("CategoryId");
	}

	default E setCategoryId(F val){
		return storeParam("CategoryId",val);
	}
    /**
     * table:CATEGORY, type:TINYINT, size:8, nullable:false
     * table:FILM_CATEGORY, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,CategoryId> colCategoryId(){
		return DaobabCache.getColumn("CategoryId", "CATEGORY_ID", (Table<?>) this, Integer.class);
	}
}
