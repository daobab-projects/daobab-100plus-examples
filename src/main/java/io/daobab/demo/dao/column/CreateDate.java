package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;

import java.time.LocalDateTime;

public interface CreateDate<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getCreateDate() {
        return readParam("CreateDate");
    }

    default E setCreateDate(F val) {
        return storeParam("CreateDate", val);
    }

    /**
     * table:CUSTOMER,type:TIMESTAMP,size:26,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, CreateDate> colCreateDate() {
        return ColumnCache.INSTANCE.getColumn("CreateDate", "CREATE_DATE", (Table<?>) this, LocalDateTime.class);
    }


}
