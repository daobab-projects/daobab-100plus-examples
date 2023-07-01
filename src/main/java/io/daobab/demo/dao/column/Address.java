package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface Address<E extends Entity, F> extends EntityRelationMap<E> {


    default F getAddress() {
        return readParam("Address");
    }

    default E setAddress(F val) {
        return storeParam("Address", val);
    }


    /**
     * table:ADDRESS,type:VARCHAR,size:50,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, Address> colAddress() {
        return ColumnCache.INSTANCE.getColumn("Address","ADDRESS",(Table<?>)this,String.class);
    }

}
