package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface District<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getDistrict() {
        return readParam("District");
    }

    default E setDistrict(F val) {
        return storeParam("District", val);
    }


    /**
     * table:ADDRESS,type:VARCHAR,size:20,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, District> colDistrict() {
        return ColumnCache.INSTANCE.getColumn("District", "DISTRICT", (Table<?>) this, String.class);
    }

}
