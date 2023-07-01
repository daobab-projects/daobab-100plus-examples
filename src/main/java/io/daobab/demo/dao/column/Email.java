package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface Email<E extends Entity, F> extends EntityRelationMap<E> {


    default F getEmail() {
        return readParam("Email");
    }

    default E setEmail(F val) {
        return storeParam("Email", val);
    }

    /**
     * table:CUSTOMER,type:VARCHAR,size:50,nullable:true
     * table:STAFF,type:VARCHAR,size:50,nullable:true
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, Email> colEmail() {
        return ColumnCache.INSTANCE.getColumn("Email","EMAIL",(Table<?>)this,String.class);
    }

}
