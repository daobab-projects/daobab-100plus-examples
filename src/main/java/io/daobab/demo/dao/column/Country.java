package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



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
    @SuppressWarnings("unchecked")
    default Column<E, F, Country> colCountry() {
        return ColumnCache.INSTANCE.getColumn("Country","COUNTRY",(Table<?>)this,String.class);
    }


}
