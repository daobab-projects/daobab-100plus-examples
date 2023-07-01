package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

import java.math.BigDecimal;

public interface ReplacementCost<E extends Entity, F> extends EntityRelationMap<E> {


    default F getReplacementCost() {
        return readParam("ReplacementCost");
    }

    default E setReplacementCost(F val) {
        return storeParam("ReplacementCost", val);
    }

    /**
     * table:FILM,type:DECIMAL,size:5,nullable:false
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, ReplacementCost> colReplacementCost() {
        return ColumnCache.INSTANCE.getColumn("ReplacementCost","REPLACEMENT_COST",(Table<?>)this,BigDecimal.class);
    }



}
