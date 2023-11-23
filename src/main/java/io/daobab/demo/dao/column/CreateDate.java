package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public interface CreateDate<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default LocalDateTime getCreateDate(){
		return readParam("CreateDate");
	}

	default E setCreateDate(LocalDateTime val){
		return storeParam("CreateDate",val);
	}

    /**
     * table:CUSTOMER, type:TIMESTAMP, size:26, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, LocalDateTime,CreateDate> colCreateDate(){
		return DaobabCache.getColumn("CreateDate", "CREATE_DATE", (Table<?>) this, LocalDateTime.class);
	}
}
