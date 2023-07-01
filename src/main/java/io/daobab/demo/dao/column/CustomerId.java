package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface CustomerId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getCustomerId() {
        return readParam("CustomerId");
    }

    default E setCustomerId(F val) {
        return storeParam("CustomerId", val);
    }


    /**
     * table:CUSTOMER,type:SMALLINT,size:16,nullable:false
     * table:PAYMENT,type:SMALLINT,size:16,nullable:false
     * table:RENTAL,type:SMALLINT,size:16,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, CustomerId> colCustomerId() {
        return ColumnCache.INSTANCE.getColumn("CustomerId","CUSTOMER_ID",(Table<?>)this,Integer.class);
    }


}
