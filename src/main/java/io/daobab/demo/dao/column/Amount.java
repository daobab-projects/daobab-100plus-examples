package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.math.BigDecimal;
import java.util.Objects;

public interface Amount<E extends Entity, F> extends EntityRelationMap<E> {


    default F getAmount() {
        return readParam("Amount");
    }

    default E setAmount(F val) {
        return storeParam("Amount", val);
    }


    @SuppressWarnings("unchecked")
    default Column<E, F, Amount> colAmount() {
        return ColumnCache.INSTANCE.getColumn("Amount","AMOUNT",(Table<?>)this,BigDecimal.class);
    }


}
