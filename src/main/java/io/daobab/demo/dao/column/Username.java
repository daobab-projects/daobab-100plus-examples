package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Username<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getUsername() {
        return readParam("Username");
    }

    default E setUsername(F val) {
        return storeParam("Username", val);
    }

    /**
     * table:STAFF,type:VARCHAR,size:16,nullable:false
     */
    @SuppressWarnings({"unchecked"})
    default Column<E, F, ActorId<E, F>> colUsername() {
        return ColumnCache.INSTANCE.getColumn("Username", "USERNAME", (Table<?>) this, String.class);
    }


}
