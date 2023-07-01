package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface City<E extends Entity, F> extends EntityRelationMap<E> {


    default F getCity() {
        return readParam("City");
    }

    default E setCity(F val) {
        return storeParam("City", val);
    }

    /**
     * table:CITY,type:VARCHAR,size:50,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, City> colCity() {
        return ColumnCache.INSTANCE.getColumn("City","CITY",(Table<?>)this,String.class);
    }


}
