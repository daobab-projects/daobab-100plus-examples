package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.math.BigDecimal;

@SuppressWarnings("unused")
public interface ReplacementCost<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default BigDecimal getReplacementCost(){
		return readParam("ReplacementCost");
	}

	default E setReplacementCost(BigDecimal val){
		return storeParam("ReplacementCost",val);
	}

    /**
     * table:FILM, type:DECIMAL, size:5, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, BigDecimal,ReplacementCost> colReplacementCost(){
		return DaobabCache.getColumn("ReplacementCost", "REPLACEMENT_COST", (Table<?>) this, BigDecimal.class);
	}
}
