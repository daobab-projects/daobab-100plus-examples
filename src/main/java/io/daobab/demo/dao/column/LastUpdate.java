package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;

import java.time.LocalDateTime;
public interface LastUpdate<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getLastUpdate(){
		return readParam("LastUpdate");
	}

	default E setLastUpdate(F val){
		return storeParam("LastUpdate",val);
	}
    /**
     * table:ACTOR, type:TIMESTAMP, size:26, nullable:false
     * table:ADDRESS, type:TIMESTAMP, size:26, nullable:false
     * table:CATEGORY, type:TIMESTAMP, size:26, nullable:false
     * table:CITY, type:TIMESTAMP, size:26, nullable:false
     * table:COUNTRY, type:TIMESTAMP, size:26, nullable:false
     * table:CUSTOMER, type:TIMESTAMP, size:26, nullable:false
     * table:FILM, type:TIMESTAMP, size:26, nullable:false
     * table:FILM_ACTOR, type:TIMESTAMP, size:26, nullable:false
     * table:FILM_CATEGORY, type:TIMESTAMP, size:26, nullable:false
     * table:INVENTORY, type:TIMESTAMP, size:26, nullable:false
     * table:LANGUAGE, type:TIMESTAMP, size:26, nullable:false
     * table:PAYMENT, type:TIMESTAMP, size:26, nullable:false
     * table:RENTAL, type:TIMESTAMP, size:26, nullable:false
     * table:STAFF, type:TIMESTAMP, size:26, nullable:false
     * table:STORE, type:TIMESTAMP, size:26, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,LastUpdate> colLastUpdate(){
		return DaobabCache.getColumn("LastUpdate", "LAST_UPDATE", (Table<?>) this, LocalDateTime.class);
	}
}
