package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface CountryId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getCountryId(){
		return readParam("CountryId");
	}

	default E setCountryId(Integer val){
		return storeParam("CountryId",val);
	}

    /**
     * table:CITY, type:SMALLINT, size:16, nullable:false
     * table:COUNTRY, type:SMALLINT, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,CountryId> colCountryId(){
		return DaobabCache.getColumn("CountryId", "COUNTRY_ID", (Table<?>) this, Integer.class);
	}
}
