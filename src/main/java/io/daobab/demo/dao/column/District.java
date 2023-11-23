package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface District<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default String getDistrict(){
		return readParam("District");
	}

	default E setDistrict(String val){
		return storeParam("District",val);
	}

    /**
     * table:ADDRESS, type:VARCHAR, size:20, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, String,District> colDistrict(){
		return DaobabCache.getColumn("District", "DISTRICT", (Table<?>) this, String.class);
	}
}
