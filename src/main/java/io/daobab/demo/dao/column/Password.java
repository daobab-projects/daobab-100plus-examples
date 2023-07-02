package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Password<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getPassword() {
        return readParam("Password");
    }

    default E setPassword(F val) {
        return storeParam("Password", val);
    }

    /**
     * table:STAFF,type:VARCHAR,size:40,nullable:true
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Password> colPassword() {
        return ColumnCache.INSTANCE.getColumn("Password", "PASSWORD", (Table<?>) this, String.class);
    }

}
