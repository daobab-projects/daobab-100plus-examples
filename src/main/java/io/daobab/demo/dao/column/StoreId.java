package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface StoreId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getStoreId(){
		return readParam("StoreId");
	}

	default E setStoreId(F val){
		return storeParam("StoreId",val);
	}
    /**
     * table:CUSTOMER, type:TINYINT, size:8, nullable:false
     * table:INVENTORY, type:TINYINT, size:8, nullable:false
     * table:STAFF, type:TINYINT, size:8, nullable:false
     * table:STORE, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,StoreId> colStoreId(){
		return DaobabCache.getColumn("StoreId", "STORE_ID", (Table<?>) this, Integer.class);
	}
}
