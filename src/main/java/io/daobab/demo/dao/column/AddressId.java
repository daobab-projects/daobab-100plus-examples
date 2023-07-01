package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface AddressId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getAddressId() {
        return readParam("AddressId");
    }

    default E setAddressId(F val) {
        return storeParam("AddressId", val);
    }

    /**
     * table:ADDRESS,type:SMALLINT,size:16,nullable:false
     * table:CUSTOMER,type:SMALLINT,size:16,nullable:false
     * table:STAFF,type:SMALLINT,size:16,nullable:false
     * table:STORE,type:SMALLINT,size:16,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, AddressId> colAddressId() {
        return ColumnCache.INSTANCE.getColumn("AddressId","ADDRESS_ID",(Table<?>)this,Integer.class);
    }


}
