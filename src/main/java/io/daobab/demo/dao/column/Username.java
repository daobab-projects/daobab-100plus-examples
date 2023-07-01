package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface Username<E extends Entity, F> extends EntityRelationMap<E> {


    default F getUsername() {
        return readParam("Username");
    }

    default E setUsername(F val) {
        return storeParam("Username", val);
    }

    /**
     * table:STAFF,type:VARCHAR,size:16,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, ActorId<E,F>> colUsername() {
        return ColumnCache.INSTANCE.getColumn("Username","USERNAME",(Table<?>)this,String.class);
    }


}
