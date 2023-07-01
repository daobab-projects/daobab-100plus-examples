package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

import java.time.LocalDateTime;

public interface RentalDate<E extends Entity, F> extends EntityRelationMap<E> {


    default F getRentalDate() {
        return readParam("RentalDate");
    }

    default E setRentalDate(F val) {
        return storeParam("RentalDate", val);
    }

    @SuppressWarnings("unchecked")
    /**
     * table:RENTAL,type:TIMESTAMP,size:26,nullable:false
     */
    default Column<E, F, RentalDate> colRentalDate() {
        return ColumnCache.INSTANCE.getColumn("RentalDate", "RENTAL_DATE", (Table<?>) this, LocalDateTime.class);
    }


}
