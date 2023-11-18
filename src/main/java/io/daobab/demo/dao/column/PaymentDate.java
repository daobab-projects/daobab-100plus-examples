package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;

import java.time.LocalDateTime;
public interface PaymentDate<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getPaymentDate(){
		return readParam("PaymentDate");
	}

	default E setPaymentDate(F val){
		return storeParam("PaymentDate",val);
	}
    /**
     * table:PAYMENT, type:TIMESTAMP, size:26, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,PaymentDate> colPaymentDate(){
		return DaobabCache.getColumn("PaymentDate", "PAYMENT_DATE", (Table<?>) this, LocalDateTime.class);
	}
}
