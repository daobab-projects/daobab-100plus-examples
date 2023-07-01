package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface LastName<E extends Entity, F> extends EntityRelationMap<E> {


    default F getLastName() {
        return readParam("LastName");
    }

    default E setLastName(F val) {
        return storeParam("LastName", val);
    }

    /**
     * table:ACTOR,type:VARCHAR,size:45,nullable:false
     * table:CUSTOMER,type:VARCHAR,size:45,nullable:false
     * table:STAFF,type:VARCHAR,size:45,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, LastName> colLastName() {
        return ColumnCache.INSTANCE.getColumn("LastName", "LAST_NAME", (Table<?>) this, String.class);
    }

}
