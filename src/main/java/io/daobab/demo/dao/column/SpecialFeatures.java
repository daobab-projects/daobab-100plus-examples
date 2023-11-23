package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface SpecialFeatures<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getSpecialFeatures(){
		return readParam("SpecialFeatures");
	}

	default E setSpecialFeatures(String val){
		return storeParam("SpecialFeatures",val);
	}

    /**
     * table:FILM, type:VARCHAR, size:54, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,SpecialFeatures> colSpecialFeatures(){
		return DaobabCache.getColumn("SpecialFeatures", "SPECIAL_FEATURES", (Table<?>) this, String.class);
	}
}
