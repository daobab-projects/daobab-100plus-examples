package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.time.LocalDateTime;
import java.util.Objects;

public interface CreateDate<E extends Entity, F> extends EntityRelationMap<E> {


    default F getCreateDate() {
        return readParam("CreateDate");
    }

    default E setCreateDate(F val) {
        return storeParam("CreateDate", val);
    }

    /**
     * table:CUSTOMER,type:TIMESTAMP,size:26,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, CreateDate> colCreateDate() {
        return ColumnCache.INSTANCE.getColumn("CreateDate", "CREATE_DATE", (Table<?>) this, LocalDateTime.class);
    }


}
