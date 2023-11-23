package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Country<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getCountry(){
		return readParam("Country");
	}

	default E setCountry(String val){
		return storeParam("Country",val);
	}

    /**
     * table:COUNTRY, type:VARCHAR, size:50, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Country> colCountry(){
		return DaobabCache.getColumn("Country", "COUNTRY", (Table<?>) this, String.class);
	}
}
