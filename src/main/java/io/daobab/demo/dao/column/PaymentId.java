package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface PaymentId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getPaymentId(){
		return readParam("PaymentId");
	}

	default E setPaymentId(Integer val){
		return storeParam("PaymentId",val);
	}

    /**
     * table:PAYMENT, type:SMALLINT, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,PaymentId> colPaymentId(){
		return DaobabCache.getColumn("PaymentId", "PAYMENT_ID", (Table<?>) this, Integer.class);
	}
}
