package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface LastName<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getLastName(){
		return readParam("LastName");
	}

	default E setLastName(F val){
		return storeParam("LastName",val);
	}
    /**
     * table:ACTOR, type:VARCHAR, size:45, nullable:false
     * table:CUSTOMER, type:VARCHAR, size:45, nullable:false
     * table:STAFF, type:VARCHAR, size:45, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,LastName> colLastName(){
		return DaobabCache.getColumn("LastName", "LAST_NAME", (Table<?>) this, String.class);
	}
}
