package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Active<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getActive() {
        return readParam("Active");
    }

    default E setActive(F val) {
        return storeParam("Active", val);
    }

    /**
     * table:CUSTOMER,type:BOOLEAN,size:1,nullable:false
     * table:STAFF,type:BOOLEAN,size:1,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, Boolean, Active> colActive() {
        return ColumnCache.INSTANCE.getColumn("Active", "ACTIVE", (Table<?>) this, Boolean.class);
    }

}
