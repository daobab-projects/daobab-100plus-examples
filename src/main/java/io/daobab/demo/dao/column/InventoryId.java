package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;

import java.math.BigDecimal;
public interface InventoryId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getInventoryId(){
		return readParam("InventoryId");
	}

	default E setInventoryId(F val){
		return storeParam("InventoryId",val);
	}
    /**
     * table:INVENTORY, type:INTEGER, size:32, nullable:false
     * table:RENTAL, type:INTEGER, size:32, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,InventoryId> colInventoryId(){
		return DaobabCache.getColumn("InventoryId", "INVENTORY_ID", (Table<?>) this, BigDecimal.class);
	}
}
