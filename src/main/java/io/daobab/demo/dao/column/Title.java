package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface Title<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


    default F getTitle() {
        return readParam("Title");
    }

    default E setTitle(F val) {
        return storeParam("Title", val);
    }

    /**
     * table:FILM,type:VARCHAR,size:255,nullable:false
     * table:FILM_TEXT,type:VARCHAR,size:255,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, Title> colTitle() {
        return ColumnCache.INSTANCE.getColumn("Title", "TITLE", (Table<?>) this, String.class);
    }

}
