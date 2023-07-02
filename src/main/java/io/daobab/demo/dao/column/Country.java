package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Country<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


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
