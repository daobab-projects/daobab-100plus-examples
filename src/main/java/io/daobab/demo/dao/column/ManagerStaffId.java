package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface ManagerStaffId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getManagerStaffId(){
		return readParam("ManagerStaffId");
	}

	default E setManagerStaffId(Integer val){
		return storeParam("ManagerStaffId",val);
	}

    /**
     * table:STORE, type:TINYINT, size:8, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,ManagerStaffId> colManagerStaffId(){
		return DaobabCache.getColumn("ManagerStaffId", "MANAGER_STAFF_ID", (Table<?>) this, Integer.class);
	}
}
