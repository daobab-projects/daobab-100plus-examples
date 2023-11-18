package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface StaffId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getStaffId(){
		return readParam("StaffId");
	}

	default E setStaffId(F val){
		return storeParam("StaffId",val);
	}
    /**
     * table:PAYMENT, type:TINYINT, size:8, nullable:false
     * table:RENTAL, type:TINYINT, size:8, nullable:false
     * table:STAFF, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,StaffId> colStaffId(){
		return DaobabCache.getColumn("StaffId", "STAFF_ID", (Table<?>) this, Integer.class);
	}
}
