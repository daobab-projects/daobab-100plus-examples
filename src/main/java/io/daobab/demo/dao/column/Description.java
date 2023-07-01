package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Description<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getDescription(){
		return readParam("Description");
	}

	default E setDescription(String val){
		return storeParam("Description",val);
	}

    /**
     * table:FILM, type:VARCHAR, size:1000000000, nullable:true
     * table:FILM_TEXT, type:VARCHAR, size:1000000000, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Description> colDescription(){
		return DaobabCache.getColumn("Description", "DESCRIPTION", (Table<?>) this, String.class);
	}
}
