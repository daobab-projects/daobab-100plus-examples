package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface Description<E extends Entity, F> extends EntityRelationMap<E> {


    default F getDescription() {
        return readParam("Description");
    }

    default E setDescription(F val) {
        return storeParam("Description", val);
    }

    /**
     * table:FILM,type:VARCHAR,size:1000000000,nullable:true
     * table:FILM_TEXT,type:VARCHAR,size:1000000000,nullable:true
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Description> colDescription() {
        return ColumnCache.INSTANCE.getColumn("Description", "DESCRIPTION", (Table<?>) this, String.class);
    }

}
