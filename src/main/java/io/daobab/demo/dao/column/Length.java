package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface Length<E extends Entity, F> extends EntityRelationMap<E> {


    default F getLength() {
        return readParam("Length");
    }

    default E setLength(F val) {
        return storeParam("Length", val);
    }

    /**
     * table:FILM,type:SMALLINT,size:16,nullable:true
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, Length> colLength() {
        return ColumnCache.INSTANCE.getColumn("Length","LENGTH",(Table<?>)this,Integer.class);
    }

}
