package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;

import java.time.LocalDateTime;

public interface RentalDate<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


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
