package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface OriginalLanguageId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getOriginalLanguageId(){
		return readParam("OriginalLanguageId");
	}

	default E setOriginalLanguageId(Integer val){
		return storeParam("OriginalLanguageId",val);
	}

    /**
     * table:FILM, type:TINYINT, size:8, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,OriginalLanguageId> colOriginalLanguageId(){
		return DaobabCache.getColumn("OriginalLanguageId", "ORIGINAL_LANGUAGE_ID", (Table<?>) this, Integer.class);
	}
}
