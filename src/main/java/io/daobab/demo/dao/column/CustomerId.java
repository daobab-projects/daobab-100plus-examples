package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface CustomerId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getCustomerId(){
		return readParam("CustomerId");
	}

	default E setCustomerId(Integer val){
		return storeParam("CustomerId",val);
	}

    /**
     * table:CUSTOMER, type:SMALLINT, size:16, nullable:false
     * table:PAYMENT, type:SMALLINT, size:16, nullable:false
     * table:RENTAL, type:SMALLINT, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,CustomerId> colCustomerId(){
		return DaobabCache.getColumn("CustomerId", "CUSTOMER_ID", (Table<?>) this, Integer.class);
	}
}
