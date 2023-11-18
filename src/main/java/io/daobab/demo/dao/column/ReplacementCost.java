package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;

import java.math.BigDecimal;
public interface ReplacementCost<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getReplacementCost(){
		return readParam("ReplacementCost");
	}

	default E setReplacementCost(F val){
		return storeParam("ReplacementCost",val);
	}
    /**
     * table:FILM, type:DECIMAL, size:5, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,ReplacementCost> colReplacementCost(){
		return DaobabCache.getColumn("ReplacementCost", "REPLACEMENT_COST", (Table<?>) this, BigDecimal.class);
	}
}
