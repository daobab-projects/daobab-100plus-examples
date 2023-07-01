package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface Length<E extends Entity, F> extends EntityRelationMap<E> {


    default F getLength() {
        return readParam("Length");
    }

    default E setLength(F val) {
        return storeParam("Length", val);
    }

    /**
     * table:FILM,type:SMALLINT,size:16,nullable:true
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Length> colLength() {
        return ColumnCache.INSTANCE.getColumn("Length", "LENGTH", (Table<?>) this, Integer.class);
    }

}
