package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Address<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getAddress(){
		return readParam("Address");
	}

	default E setAddress(String val){
		return storeParam("Address",val);
	}

    /**
     * table:ADDRESS, type:VARCHAR, size:50, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Address> colAddress(){
		return DaobabCache.getColumn("Address", "ADDRESS", (Table<?>) this, String.class);
	}
}
