package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



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
    @SuppressWarnings("unchecked")
    default Column<E, F, LastName> colLastName() {
        return ColumnCache.INSTANCE.getColumn("LastName","LAST_NAME",(Table<?>)this,String.class);
    }

}
