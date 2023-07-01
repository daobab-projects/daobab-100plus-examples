package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface City<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getCity(){
		return readParam("City");
	}

	default E setCity(String val){
		return storeParam("City",val);
	}

    /**
     * table:CITY, type:VARCHAR, size:50, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,City> colCity(){
		return DaobabCache.getColumn("City", "CITY", (Table<?>) this, String.class);
	}
}
