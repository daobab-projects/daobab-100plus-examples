package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;

import java.math.BigDecimal;

public interface Amount<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getAmount() {
        return readParam("Amount");
    }

    default E setAmount(F val) {
        return storeParam("Amount", val);
    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Amount> colAmount() {
        return ColumnCache.INSTANCE.getColumn("Amount", "AMOUNT", (Table<?>) this, BigDecimal.class);
    }


}
