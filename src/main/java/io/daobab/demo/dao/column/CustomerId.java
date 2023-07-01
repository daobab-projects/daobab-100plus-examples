package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


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
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, CustomerId> colCustomerId() {
        return ColumnCache.INSTANCE.getColumn("CustomerId", "CUSTOMER_ID", (Table<?>) this, Integer.class);
    }


}
