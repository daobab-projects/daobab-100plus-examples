package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface StoreId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getStoreId(){
		return readParam("StoreId");
	}

	default E setStoreId(Integer val){
		return storeParam("StoreId",val);
	}

    /**
     * table:CUSTOMER, type:TINYINT, size:8, nullable:false
     * table:INVENTORY, type:TINYINT, size:8, nullable:false
     * table:STAFF, type:TINYINT, size:8, nullable:false
     * table:STORE, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,StoreId> colStoreId(){
		return DaobabCache.getColumn("StoreId", "STORE_ID", (Table<?>) this, Integer.class);
	}
}
