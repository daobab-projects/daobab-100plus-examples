package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;



public interface Email<E extends Entity, F> extends EntityRelationMap<E> {


    default F getEmail() {
        return readParam("Email");
    }

    default E setEmail(F val) {
        return storeParam("Email", val);
    }

    /**
     * table:CUSTOMER,type:VARCHAR,size:50,nullable:true
     * table:STAFF,type:VARCHAR,size:50,nullable:true
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, Email> colEmail() {
        return ColumnCache.INSTANCE.getColumn("Email","EMAIL",(Table<?>)this,String.class);
    }

}
