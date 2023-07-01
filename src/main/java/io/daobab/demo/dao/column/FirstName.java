package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface FirstName<E extends Entity, F> extends EntityRelationMap<E> {


    default F getFirstName() {
        return readParam("FirstName");
    }

    default E setFirstName(F val) {
        return storeParam("FirstName", val);
    }

    /**
     * table:ACTOR,type:VARCHAR,size:45,nullable:false
     * table:CUSTOMER,type:VARCHAR,size:45,nullable:false
     * table:STAFF,type:VARCHAR,size:45,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, FirstName> colFirstName() {
        return ColumnCache.INSTANCE.getColumn("FirstName", "FIRST_NAME", (Table<?>) this, String.class);
    }


}
