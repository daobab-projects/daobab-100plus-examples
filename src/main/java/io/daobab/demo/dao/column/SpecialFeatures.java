package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface SpecialFeatures<E extends Entity, F> extends EntityRelationMap<E> {


    default F getSpecialFeatures() {
        return readParam("SpecialFeatures");
    }

    default E setSpecialFeatures(F val) {
        return storeParam("SpecialFeatures", val);
    }

    @SuppressWarnings("unchecked")
    /**
     * table:FILM,type:VARCHAR,size:54,nullable:true
     */
    default Column<E, F, SpecialFeatures> colSpecialFeatures() {
        return ColumnCache.INSTANCE.getColumn("SpecialFeatures","SPECIAL_FEATURES",(Table<?>)this,String.class);
    }


}
