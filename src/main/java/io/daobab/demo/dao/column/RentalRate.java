package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;

import java.math.BigDecimal;

public interface RentalRate<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getRentalRate() {
        return readParam("RentalRate");
    }


    default E setRentalRate(F val) {
        return storeParam("RentalRate", val);
    }

    /**
     * table:FILM,type:DECIMAL,size:4,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, RentalRate> colRentalRate() {
        return ColumnCache.INSTANCE.getColumn("RentalRate", "RENTAL_RATE", (Table<?>) this, BigDecimal.class);
    }


}
