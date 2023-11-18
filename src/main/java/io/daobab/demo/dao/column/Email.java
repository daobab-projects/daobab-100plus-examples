package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Email<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getEmail(){
		return readParam("Email");
	}

	default E setEmail(F val){
		return storeParam("Email",val);
	}
    /**
     * table:CUSTOMER, type:VARCHAR, size:50, nullable:true
     * table:STAFF, type:VARCHAR, size:50, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,Email> colEmail(){
		return DaobabCache.getColumn("Email", "EMAIL", (Table<?>) this, String.class);
	}
}
