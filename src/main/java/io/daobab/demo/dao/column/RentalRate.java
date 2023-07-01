package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.math.BigDecimal;
import java.util.Objects;

public interface RentalRate<E extends Entity, F> extends EntityRelationMap<E> {


    default F getRentalRate() {
        return readParam("RentalRate");
    }


    default E setRentalRate(F val) {
        return storeParam("RentalRate", val);
    }

    /**
     * table:FILM,type:DECIMAL,size:4,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, RentalRate> colRentalRate() {
        return ColumnCache.INSTANCE.getColumn("RentalRate","RENTAL_RATE",(Table<?>)this,BigDecimal.class);
    }


}
