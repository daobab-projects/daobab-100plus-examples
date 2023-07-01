package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.math.BigDecimal;

@SuppressWarnings("unused")
public interface RentalRate<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default BigDecimal getRentalRate(){
		return readParam("RentalRate");
	}

	default E setRentalRate(BigDecimal val){
		return storeParam("RentalRate",val);
	}

    /**
     * table:FILM, type:DECIMAL, size:4, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, BigDecimal,RentalRate> colRentalRate(){
		return DaobabCache.getColumn("RentalRate", "RENTAL_RATE", (Table<?>) this, BigDecimal.class);
	}
}
