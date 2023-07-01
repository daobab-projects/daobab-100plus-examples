package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface LanguageId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getLanguageId() {
        return readParam("LanguageId");
    }

    default E setLanguageId(F val) {
        return storeParam("LanguageId", val);
    }

    /**
     * table:FILM,type:TINYINT,size:8,nullable:false
     * table:LANGUAGE,type:TINYINT,size:8,nullable:false
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, LanguageId> colLanguageId() {
        return ColumnCache.INSTANCE.getColumn("LanguageId", "LANGUAGE_ID", (Table<?>) this, Integer.class);
    }

}
