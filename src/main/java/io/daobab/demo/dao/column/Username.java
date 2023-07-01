package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;



public interface Username<E extends Entity, F> extends EntityRelationMap<E> {


    default F getUsername() {
        return readParam("Username");
    }

    default E setUsername(F val) {
        return storeParam("Username", val);
    }

    /**
     * table:STAFF,type:VARCHAR,size:16,nullable:false
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, ActorId<E,F>> colUsername() {
        return ColumnCache.INSTANCE.getColumn("Username","USERNAME",(Table<?>)this,String.class);
    }


}
