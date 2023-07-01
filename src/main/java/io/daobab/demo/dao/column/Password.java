package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Password<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getPassword(){
		return readParam("Password");
	}

	default E setPassword(String val){
		return storeParam("Password",val);
	}

    /**
     * table:STAFF, type:VARCHAR, size:40, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Password> colPassword(){
		return DaobabCache.getColumn("Password", "PASSWORD", (Table<?>) this, String.class);
	}
}
