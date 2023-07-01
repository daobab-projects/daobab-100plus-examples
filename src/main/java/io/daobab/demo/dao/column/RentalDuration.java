package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface RentalDuration<E extends Entity, F> extends EntityRelationMap<E> {


    default F getRentalDuration() {
        return readParam("RentalDuration");
    }

    default E setRentalDuration(F val) {
        return storeParam("RentalDuration", val);
    }

    /**
     * table:FILM,type:TINYINT,size:8,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, RentalDuration> colRentalDuration() {
        return ColumnCache.INSTANCE.getColumn("RentalDuration","RENTAL_DURATION",(Table<?>)this,Integer.class);
    }


}
