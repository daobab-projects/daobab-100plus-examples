package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface FirstName<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getFirstName(){
		return readParam("FirstName");
	}

	default E setFirstName(String val){
		return storeParam("FirstName",val);
	}

    /**
     * table:ACTOR, type:VARCHAR, size:45, nullable:false
     * table:CUSTOMER, type:VARCHAR, size:45, nullable:false
     * table:STAFF, type:VARCHAR, size:45, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,FirstName> colFirstName(){
		return DaobabCache.getColumn("FirstName", "FIRST_NAME", (Table<?>) this, String.class);
	}
}
