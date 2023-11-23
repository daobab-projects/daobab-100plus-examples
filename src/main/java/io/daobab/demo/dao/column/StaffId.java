package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface StaffId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getStaffId(){
		return readParam("StaffId");
	}

	default E setStaffId(Integer val){
		return storeParam("StaffId",val);
	}

    /**
     * table:PAYMENT, type:TINYINT, size:8, nullable:false
     * table:RENTAL, type:TINYINT, size:8, nullable:false
     * table:STAFF, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,StaffId> colStaffId(){
		return DaobabCache.getColumn("StaffId", "STAFF_ID", (Table<?>) this, Integer.class);
	}
}
