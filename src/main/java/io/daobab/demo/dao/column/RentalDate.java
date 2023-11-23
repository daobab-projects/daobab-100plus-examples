package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public interface RentalDate<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default LocalDateTime getRentalDate(){
		return readParam("RentalDate");
	}

	default E setRentalDate(LocalDateTime val){
		return storeParam("RentalDate",val);
	}

    /**
     * table:RENTAL, type:TIMESTAMP, size:26, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, LocalDateTime,RentalDate> colRentalDate(){
		return DaobabCache.getColumn("RentalDate", "RENTAL_DATE", (Table<?>) this, LocalDateTime.class);
	}
}
