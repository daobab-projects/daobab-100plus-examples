package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface Picture<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default byte[] getPicture(){
		return readParam("Picture");
	}

	default E setPicture(byte[] val){
		return storeParam("Picture",val);
	}

    /**
     * table:STAFF, type:VARBINARY, size:1000000000, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, byte[],Picture> colPicture(){
		return DaobabCache.getColumn("Picture", "PICTURE", (Table<?>) this, byte[].class);
	}
}
