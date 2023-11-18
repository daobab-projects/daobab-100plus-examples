package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface Picture<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getPicture(){
		return readParam("Picture");
	}

	default E setPicture(F val){
		return storeParam("Picture",val);
	}
    /**
     * table:STAFF, type:VARBINARY, size:1000000000, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,Picture> colPicture(){
		return DaobabCache.getColumn("Picture", "PICTURE", (Table<?>) this, byte[].class);
	}
}
