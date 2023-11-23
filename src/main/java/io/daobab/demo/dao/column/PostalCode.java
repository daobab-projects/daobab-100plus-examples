package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface PostalCode<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getPostalCode(){
		return readParam("PostalCode");
	}

	default E setPostalCode(String val){
		return storeParam("PostalCode",val);
	}

    /**
     * table:ADDRESS, type:VARCHAR, size:10, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,PostalCode> colPostalCode(){
		return DaobabCache.getColumn("PostalCode", "POSTAL_CODE", (Table<?>) this, String.class);
	}
}
