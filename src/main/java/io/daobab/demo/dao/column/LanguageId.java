package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface LanguageId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getLanguageId(){
		return readParam("LanguageId");
	}

	default E setLanguageId(Integer val){
		return storeParam("LanguageId",val);
	}

    /**
     * table:FILM, type:TINYINT, size:8, nullable:false
     * table:LANGUAGE, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,LanguageId> colLanguageId(){
		return DaobabCache.getColumn("LanguageId", "LANGUAGE_ID", (Table<?>) this, Integer.class);
	}
}
