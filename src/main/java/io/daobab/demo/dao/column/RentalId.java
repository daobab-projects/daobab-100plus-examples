package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.math.BigDecimal;

@SuppressWarnings("unused")
public interface RentalId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default BigDecimal getRentalId(){
		return readParam("RentalId");
	}

	default E setRentalId(BigDecimal val){
		return storeParam("RentalId",val);
	}

    /**
     * table:PAYMENT, type:INTEGER, size:32, nullable:true
     * table:RENTAL, type:INTEGER, size:32, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, BigDecimal,RentalId> colRentalId(){
		return DaobabCache.getColumn("RentalId", "RENTAL_ID", (Table<?>) this, BigDecimal.class);
	}
}
