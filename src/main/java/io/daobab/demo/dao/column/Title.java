package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Title<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getTitle(){
		return readParam("Title");
	}

	default E setTitle(String val){
		return storeParam("Title",val);
	}

    /**
     * table:FILM, type:VARCHAR, size:255, nullable:false
     * table:FILM_TEXT, type:VARCHAR, size:255, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Title> colTitle(){
		return DaobabCache.getColumn("Title", "TITLE", (Table<?>) this, String.class);
	}
}
