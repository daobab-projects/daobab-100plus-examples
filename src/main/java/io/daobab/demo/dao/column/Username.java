package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Username<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getUsername(){
		return readParam("Username");
	}

	default E setUsername(String val){
		return storeParam("Username",val);
	}

    /**
     * table:STAFF, type:VARCHAR, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Username> colUsername(){
		return DaobabCache.getColumn("Username", "USERNAME", (Table<?>) this, String.class);
	}
}
