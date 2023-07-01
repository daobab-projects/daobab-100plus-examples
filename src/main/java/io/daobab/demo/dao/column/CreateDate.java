package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

import java.time.LocalDateTime;

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
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, CreateDate> colCreateDate() {
        return ColumnCache.INSTANCE.getColumn("CreateDate", "CREATE_DATE", (Table<?>) this, LocalDateTime.class);
    }


}
