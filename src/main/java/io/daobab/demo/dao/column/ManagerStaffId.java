package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;



public interface ManagerStaffId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getManagerStaffId() {
        return readParam("ManagerStaffId");
    }


    default E setManagerStaffId(F val) {
        return storeParam("ManagerStaffId", val);
    }

    /**
     * table:STORE,type:TINYINT,size:8,nullable:false
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, ManagerStaffId> colManagerStaffId() {
        return ColumnCache.INSTANCE.getColumn("ManagerStaffId","MANAGER_STAFF_ID",(Table<?>)this,Integer.class);
    }


}
