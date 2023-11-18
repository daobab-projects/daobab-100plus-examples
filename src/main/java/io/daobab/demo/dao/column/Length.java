package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Length<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getLength(){
		return readParam("Length");
	}

	default E setLength(F val){
		return storeParam("Length",val);
	}
    /**
     * table:FILM, type:SMALLINT, size:16, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,Length> colLength(){
		return DaobabCache.getColumn("Length", "LENGTH", (Table<?>) this, Integer.class);
	}
}
