package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface StaffId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getStaffId() {
        return readParam("StaffId");
    }


    default E setStaffId(F val) {
        return storeParam("StaffId", val);
    }

    /**
     * table:PAYMENT,type:TINYINT,size:8,nullable:false
     * table:RENTAL,type:TINYINT,size:8,nullable:false
     * table:STAFF,type:TINYINT,size:8,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, StaffId> colStaffId() {
        return ColumnCache.INSTANCE.getColumn("StaffId", "STAFF_ID", (Table<?>) this, Integer.class);
    }


}
