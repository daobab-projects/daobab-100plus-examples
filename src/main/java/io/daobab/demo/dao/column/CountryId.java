package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface CountryId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getCountryId() {
        return readParam("CountryId");
    }

    default E setCountryId(F val) {
        return storeParam("CountryId", val);
    }


    /**
     * table:CITY,type:SMALLINT,size:16,nullable:false
     * table:COUNTRY,type:SMALLINT,size:16,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, CountryId> colCountryId() {
        return ColumnCache.INSTANCE.getColumn("CountryId", "COUNTRY_ID", (Table<?>) this, Integer.class);
    }

}
