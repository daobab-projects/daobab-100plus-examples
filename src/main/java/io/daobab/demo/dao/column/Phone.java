package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Phone<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getPhone(){
		return readParam("Phone");
	}

	default E setPhone(F val){
		return storeParam("Phone",val);
	}
    /**
     * table:ADDRESS, type:VARCHAR, size:20, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,Phone> colPhone(){
		return DaobabCache.getColumn("Phone", "PHONE", (Table<?>) this, String.class);
	}
}
