package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;



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
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, City> colCity() {
        return ColumnCache.INSTANCE.getColumn("City","CITY",(Table<?>)this,String.class);
    }


}
