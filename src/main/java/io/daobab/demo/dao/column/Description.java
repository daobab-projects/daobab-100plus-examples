package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Description<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getDescription(){
		return readParam("Description");
	}

	default E setDescription(F val){
		return storeParam("Description",val);
	}
    /**
     * table:FILM, type:VARCHAR, size:1000000000, nullable:true
     * table:FILM_TEXT, type:VARCHAR, size:1000000000, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,Description> colDescription(){
		return DaobabCache.getColumn("Description", "DESCRIPTION", (Table<?>) this, String.class);
	}
}
