package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Email<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getEmail(){
		return readParam("Email");
	}

	default E setEmail(String val){
		return storeParam("Email",val);
	}

    /**
     * table:CUSTOMER, type:VARCHAR, size:50, nullable:true
     * table:STAFF, type:VARCHAR, size:50, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Email> colEmail(){
		return DaobabCache.getColumn("Email", "EMAIL", (Table<?>) this, String.class);
	}
}
