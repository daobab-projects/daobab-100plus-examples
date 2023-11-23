package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Address2<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getAddress2(){
		return readParam("Address2");
	}

	default E setAddress2(String val){
		return storeParam("Address2",val);
	}

    /**
     * table:ADDRESS, type:VARCHAR, size:50, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Address2> colAddress2(){
		return DaobabCache.getColumn("Address2", "ADDRESS2", (Table<?>) this, String.class);
	}
}
