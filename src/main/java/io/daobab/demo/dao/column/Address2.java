package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;



public interface Address2<E extends Entity, F> extends EntityRelationMap<E> {


    default F getAddress2() {
        return readParam("Address2");
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    default E setAddress2(F val) {
        return storeParam("Address2", val);
    }

    /**
     * table:ADDRESS,type:VARCHAR,size:50,nullable:true
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, Address2> colAddress2() {
        return ColumnCache.INSTANCE.getColumn("Address2","ADDRESS2",(Table<?>)this,String.class);
    }

}
