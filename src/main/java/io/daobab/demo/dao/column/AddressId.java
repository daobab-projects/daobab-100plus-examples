package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface AddressId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getAddressId(){
		return readParam("AddressId");
	}

	default E setAddressId(Integer val){
		return storeParam("AddressId",val);
	}

    /**
     * table:ADDRESS, type:SMALLINT, size:16, nullable:false
     * table:CUSTOMER, type:SMALLINT, size:16, nullable:false
     * table:STAFF, type:SMALLINT, size:16, nullable:false
     * table:STORE, type:SMALLINT, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,AddressId> colAddressId(){
		return DaobabCache.getColumn("AddressId", "ADDRESS_ID", (Table<?>) this, Integer.class);
	}
}
