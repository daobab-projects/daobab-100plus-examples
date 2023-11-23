package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface CityId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getCityId(){
		return readParam("CityId");
	}

	default E setCityId(Integer val){
		return storeParam("CityId",val);
	}

    /**
     * table:ADDRESS, type:SMALLINT, size:16, nullable:false
     * table:CITY, type:SMALLINT, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,CityId> colCityId(){
		return DaobabCache.getColumn("CityId", "CITY_ID", (Table<?>) this, Integer.class);
	}
}
