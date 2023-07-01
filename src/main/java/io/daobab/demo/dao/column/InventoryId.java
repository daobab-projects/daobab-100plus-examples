package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.math.BigDecimal;

@SuppressWarnings("unused")
public interface InventoryId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default BigDecimal getInventoryId(){
		return readParam("InventoryId");
	}

	default E setInventoryId(BigDecimal val){
		return storeParam("InventoryId",val);
	}

    /**
     * table:INVENTORY, type:INTEGER, size:32, nullable:false
     * table:RENTAL, type:INTEGER, size:32, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, BigDecimal,InventoryId> colInventoryId(){
		return DaobabCache.getColumn("InventoryId", "INVENTORY_ID", (Table<?>) this, BigDecimal.class);
	}
}
