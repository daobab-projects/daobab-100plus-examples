package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Length<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getLength(){
		return readParam("Length");
	}

	default E setLength(Integer val){
		return storeParam("Length",val);
	}

    /**
     * table:FILM, type:SMALLINT, size:16, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,Length> colLength(){
		return DaobabCache.getColumn("Length", "LENGTH", (Table<?>) this, Integer.class);
	}
}
