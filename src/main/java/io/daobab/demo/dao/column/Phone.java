package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Phone<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getPhone(){
		return readParam("Phone");
	}

	default E setPhone(String val){
		return storeParam("Phone",val);
	}

    /**
     * table:ADDRESS, type:VARCHAR, size:20, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Phone> colPhone(){
		return DaobabCache.getColumn("Phone", "PHONE", (Table<?>) this, String.class);
	}
}
