package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

import java.time.LocalDateTime;

public interface ReturnDate<E extends Entity, F> extends EntityRelationMap<E> {


    default F getReturnDate() {
        return readParam("ReturnDate");
    }

    default E setReturnDate(F val) {
        return storeParam("ReturnDate", val);
    }

    @SuppressWarnings("unchecked")
    /**
     * table:RENTAL,type:TIMESTAMP,size:26,nullable:true
     */
    default Column<E, F, ReturnDate> colReturnDate() {
        return ColumnCache.INSTANCE.getColumn("ReturnDate", "RETURN_DATE", (Table<?>) this, LocalDateTime.class);
    }


}
