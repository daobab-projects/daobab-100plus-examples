package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;

import java.time.LocalDateTime;
public interface RentalDate<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getRentalDate(){
		return readParam("RentalDate");
	}

	default E setRentalDate(F val){
		return storeParam("RentalDate",val);
	}
    /**
     * table:RENTAL, type:TIMESTAMP, size:26, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,RentalDate> colRentalDate(){
		return DaobabCache.getColumn("RentalDate", "RENTAL_DATE", (Table<?>) this, LocalDateTime.class);
	}
}
