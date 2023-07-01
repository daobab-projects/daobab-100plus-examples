package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface Country<E extends Entity, F> extends EntityRelationMap<E> {


    default F getCountry() {
        return readParam("Country");
    }

    default E setCountry(F val) {
        return storeParam("Country", val);
    }


    /**
     * table:COUNTRY,type:VARCHAR,size:50,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Country> colCountry() {
        return ColumnCache.INSTANCE.getColumn("Country", "COUNTRY", (Table<?>) this, String.class);
    }


}
