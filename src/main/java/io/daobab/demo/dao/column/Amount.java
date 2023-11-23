package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.math.BigDecimal;

@SuppressWarnings("unused")
public interface Amount<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default BigDecimal getAmount(){
		return readParam("Amount");
	}

	default E setAmount(BigDecimal val){
		return storeParam("Amount",val);
	}

    /**
     * table:PAYMENT, type:DECIMAL, size:5, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, BigDecimal,Amount> colAmount(){
		return DaobabCache.getColumn("Amount", "AMOUNT", (Table<?>) this, BigDecimal.class);
	}
}
