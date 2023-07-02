package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Address2<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getAddress2() {
        return readParam("Address2");
    }

    default E setAddress2(F val) {
        return storeParam("Address2", val);
    }

    /**
     * table:ADDRESS,type:VARCHAR,size:50,nullable:true
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Address2> colAddress2() {
        return ColumnCache.INSTANCE.getColumn("Address2", "ADDRESS2", (Table<?>) this, String.class);
    }

}
