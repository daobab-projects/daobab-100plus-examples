package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;


public interface CountryId<E extends Entity, F> extends EntityRelationMap<E> {


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
    @SuppressWarnings("unchecked")
    default Column<E, F, CountryId> colCountryId() {
        return ColumnCache.INSTANCE.getColumn("CountryId", "COUNTRY_ID", (Table<?>) this, Integer.class);
    }

}
