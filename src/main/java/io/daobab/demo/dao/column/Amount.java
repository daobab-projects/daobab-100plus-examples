package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;

import java.math.BigDecimal;
public interface Amount<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getAmount(){
		return readParam("Amount");
	}

	default E setAmount(F val){
		return storeParam("Amount",val);
	}
    /**
     * table:PAYMENT, type:DECIMAL, size:5, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,Amount> colAmount(){
		return DaobabCache.getColumn("Amount", "AMOUNT", (Table<?>) this, BigDecimal.class);
	}
}
