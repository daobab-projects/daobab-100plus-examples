package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Active<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Boolean getActive(){
		return readParam("Active");
	}

	default E setActive(Boolean val){
		return storeParam("Active",val);
	}

    /**
     * table:CUSTOMER, type:BOOLEAN, size:1, nullable:false
     * table:STAFF, type:BOOLEAN, size:1, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Boolean,Active> colActive(){
		return DaobabCache.getColumn("Active", "ACTIVE", (Table<?>) this, Boolean.class);
	}
}
