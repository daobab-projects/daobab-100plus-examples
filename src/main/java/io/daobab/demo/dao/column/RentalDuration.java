package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface RentalDuration<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getRentalDuration(){
		return readParam("RentalDuration");
	}

	default E setRentalDuration(F val){
		return storeParam("RentalDuration",val);
	}
    /**
     * table:FILM, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,RentalDuration> colRentalDuration(){
		return DaobabCache.getColumn("RentalDuration", "RENTAL_DURATION", (Table<?>) this, Integer.class);
	}
}
