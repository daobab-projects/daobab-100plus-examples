package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface OriginalLanguageId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getOriginalLanguageId(){
		return readParam("OriginalLanguageId");
	}

	default E setOriginalLanguageId(F val){
		return storeParam("OriginalLanguageId",val);
	}
    /**
     * table:FILM, type:TINYINT, size:8, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,OriginalLanguageId> colOriginalLanguageId(){
		return DaobabCache.getColumn("OriginalLanguageId", "ORIGINAL_LANGUAGE_ID", (Table<?>) this, Integer.class);
	}
}
