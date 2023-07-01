package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Name<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getName(){
		return readParam("Name");
	}

	default E setName(String val){
		return storeParam("Name",val);
	}

    /**
     * table:CATEGORY, type:VARCHAR, size:25, nullable:false
     * table:LANGUAGE, type:VARCHAR, size:20, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,Name> colName(){
		return DaobabCache.getColumn("Name", "NAME", (Table<?>) this, String.class);
	}
}
