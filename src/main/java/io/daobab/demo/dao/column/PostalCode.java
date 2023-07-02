package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface PostalCode<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getPostalCode() {
        return readParam("PostalCode");
    }

    default E setPostalCode(F val) {
        return storeParam("PostalCode", val);
    }

    /**
     * table:ADDRESS,type:VARCHAR,size:10,nullable:true
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, PostalCode> colPostalCode() {
        return ColumnCache.INSTANCE.getColumn("PostalCode", "POSTAL_CODE", (Table<?>) this, String.class);
    }

}
