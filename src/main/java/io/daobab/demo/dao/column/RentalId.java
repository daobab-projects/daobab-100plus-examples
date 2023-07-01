package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.math.BigDecimal;
import java.util.Objects;

public interface RentalId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getRentalId() {
        return readParam("RentalId");
    }

    default E setRentalId(F val) {
        return storeParam("RentalId", val);
    }

    /**
     * table:PAYMENT,type:INTEGER,size:32,nullable:true
     * table:RENTAL,type:INTEGER,size:32,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, RentalId> colRentalId() {
        return ColumnCache.INSTANCE.getColumn("RentalId","RENTAL_ID",(Table<?>)this,BigDecimal.class);
    }


}
