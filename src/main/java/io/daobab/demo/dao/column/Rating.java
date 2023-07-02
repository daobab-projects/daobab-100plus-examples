package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Rating<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getRating() {
        return readParam("Rating");
    }

    default E setRating(F val) {
        return storeParam("Rating", val);
    }

    /**
     * table:FILM,type:VARCHAR,size:5,nullable:true
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Rating> colRating() {
        return ColumnCache.INSTANCE.getColumn("Rating", "RATING", (Table<?>) this, String.class);
    }

}
