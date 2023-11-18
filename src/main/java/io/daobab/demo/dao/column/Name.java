package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Name<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getName(){
		return readParam("Name");
	}

	default E setName(F val){
		return storeParam("Name",val);
	}
    /**
     * table:CATEGORY, type:VARCHAR, size:25, nullable:false
     * table:LANGUAGE, type:VARCHAR, size:20, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,Name> colName(){
		return DaobabCache.getColumn("Name", "NAME", (Table<?>) this, String.class);
	}
}
