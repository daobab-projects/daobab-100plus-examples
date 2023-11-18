package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface City<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getCity(){
		return readParam("City");
	}

	default E setCity(F val){
		return storeParam("City",val);
	}
    /**
     * table:CITY, type:VARCHAR, size:50, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,City> colCity(){
		return DaobabCache.getColumn("City", "CITY", (Table<?>) this, String.class);
	}
}
