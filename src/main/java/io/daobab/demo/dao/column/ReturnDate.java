package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public interface ReturnDate<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default LocalDateTime getReturnDate(){
		return readParam("ReturnDate");
	}

	default E setReturnDate(LocalDateTime val){
		return storeParam("ReturnDate",val);
	}

    /**
     * table:RENTAL, type:TIMESTAMP, size:26, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, LocalDateTime,ReturnDate> colReturnDate(){
		return DaobabCache.getColumn("ReturnDate", "RETURN_DATE", (Table<?>) this, LocalDateTime.class);
	}
}
