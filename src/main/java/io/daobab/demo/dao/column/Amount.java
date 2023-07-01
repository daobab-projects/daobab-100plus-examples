package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

import java.math.BigDecimal;

public interface Amount<E extends Entity, F> extends EntityRelationMap<E> {


    default F getAmount() {
        return readParam("Amount");
    }

    default E setAmount(F val) {
        return storeParam("Amount", val);
    }


    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, Amount> colAmount() {
        return ColumnCache.INSTANCE.getColumn("Amount","AMOUNT",(Table<?>)this,BigDecimal.class);
    }


}
