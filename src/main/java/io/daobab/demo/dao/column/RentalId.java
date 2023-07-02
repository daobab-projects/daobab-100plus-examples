package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;

import java.math.BigDecimal;

public interface RentalId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


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
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, RentalId> colRentalId() {
        return ColumnCache.INSTANCE.getColumn("RentalId", "RENTAL_ID", (Table<?>) this, BigDecimal.class);
    }


}
