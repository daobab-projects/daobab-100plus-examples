package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface LastName<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getLastName(){
		return readParam("LastName");
	}

	default E setLastName(String val){
		return storeParam("LastName",val);
	}

    /**
     * table:ACTOR, type:VARCHAR, size:45, nullable:false
     * table:CUSTOMER, type:VARCHAR, size:45, nullable:false
     * table:STAFF, type:VARCHAR, size:45, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,LastName> colLastName(){
		return DaobabCache.getColumn("LastName", "LAST_NAME", (Table<?>) this, String.class);
	}
}
