package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface PaymentId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getPaymentId() {
        return readParam("PaymentId");
    }

    default E setPaymentId(F val) {
        return storeParam("PaymentId", val);
    }

    /**
     * table:PAYMENT,type:SMALLINT,size:16,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, PaymentId> colPaymentId() {
        return ColumnCache.INSTANCE.getColumn("PaymentId", "PAYMENT_ID", (Table<?>) this, Integer.class);
    }

}
