package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public interface PaymentDate<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default LocalDateTime getPaymentDate(){
		return readParam("PaymentDate");
	}

	default E setPaymentDate(LocalDateTime val){
		return storeParam("PaymentDate",val);
	}

    /**
     * table:PAYMENT, type:TIMESTAMP, size:26, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, LocalDateTime,PaymentDate> colPaymentDate(){
		return DaobabCache.getColumn("PaymentDate", "PAYMENT_DATE", (Table<?>) this, LocalDateTime.class);
	}
}
