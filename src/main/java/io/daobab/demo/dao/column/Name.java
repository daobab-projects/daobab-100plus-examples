package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Name<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getName() {
        return readParam("Name");
    }

    default E setName(F val) {
        return storeParam("Name", val);
    }

    @SuppressWarnings("unchecked")
    /**
     * table:CATEGORY,type:VARCHAR,size:25,nullable:false
     * table:LANGUAGE,type:VARCHAR,size:20,nullable:false
     */
    default Column<E, F, Name> colName() {
        return ColumnCache.INSTANCE.getColumn("Name", "NAME", (Table<?>) this, String.class);
    }


}
