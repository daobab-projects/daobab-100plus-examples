package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Username<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getUsername(){
		return readParam("Username");
	}

	default E setUsername(F val){
		return storeParam("Username",val);
	}
    /**
     * table:STAFF, type:VARCHAR, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,Username> colUsername(){
		return DaobabCache.getColumn("Username", "USERNAME", (Table<?>) this, String.class);
	}
}
