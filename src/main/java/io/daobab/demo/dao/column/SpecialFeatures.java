package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface SpecialFeatures<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getSpecialFeatures(){
		return readParam("SpecialFeatures");
	}

	default E setSpecialFeatures(F val){
		return storeParam("SpecialFeatures",val);
	}
    /**
     * table:FILM, type:VARCHAR, size:54, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,SpecialFeatures> colSpecialFeatures(){
		return DaobabCache.getColumn("SpecialFeatures", "SPECIAL_FEATURES", (Table<?>) this, String.class);
	}
}
