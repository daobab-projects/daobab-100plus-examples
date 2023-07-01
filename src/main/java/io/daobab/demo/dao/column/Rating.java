package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Rating<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getRating(){
		return readParam("Rating");
	}

	default E setRating(String val){
		return storeParam("Rating",val);
	}

    /**
     * table:FILM, type:VARCHAR, size:5, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Rating> colRating(){
		return DaobabCache.getColumn("Rating", "RATING", (Table<?>) this, String.class);
	}
}
