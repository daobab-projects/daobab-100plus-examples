package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;

import java.time.LocalDateTime;

public interface PaymentDate<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getPaymentDate() {
        return readParam("PaymentDate");
    }

    default E setPaymentDate(F val) {
        return storeParam("PaymentDate", val);
    }

    @SuppressWarnings("unchecked")
    /**
     * table:PAYMENT,type:TIMESTAMP,size:26,nullable:false
     */
    default Column<E, F, PaymentDate> colPaymentDate() {
        return ColumnCache.INSTANCE.getColumn("PaymentDate", "PAYMENT_DATE", (Table<?>) this, LocalDateTime.class);
    }


}
