package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Phone<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getPhone() {
        return readParam("Phone");
    }

    default E setPhone(F val) {
        return storeParam("Phone", val);
    }

    /**
     * table:ADDRESS,type:VARCHAR,size:20,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Phone> colPhone() {
        return ColumnCache.INSTANCE.getColumn("Phone", "PHONE", (Table<?>) this, String.class);
    }

}
