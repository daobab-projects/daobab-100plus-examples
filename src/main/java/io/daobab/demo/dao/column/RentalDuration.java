package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface RentalDuration<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getRentalDuration(){
		return readParam("RentalDuration");
	}

	default E setRentalDuration(Integer val){
		return storeParam("RentalDuration",val);
	}

    /**
     * table:FILM, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,RentalDuration> colRentalDuration(){
		return DaobabCache.getColumn("RentalDuration", "RENTAL_DURATION", (Table<?>) this, Integer.class);
	}
}
