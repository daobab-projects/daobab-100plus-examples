package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface CategoryId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getCategoryId(){
		return readParam("CategoryId");
	}

	default E setCategoryId(Integer val){
		return storeParam("CategoryId",val);
	}

    /**
     * table:CATEGORY, type:TINYINT, size:8, nullable:false
     * table:FILM_CATEGORY, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,CategoryId> colCategoryId(){
		return DaobabCache.getColumn("CategoryId", "CATEGORY_ID", (Table<?>) this, Integer.class);
	}
}
