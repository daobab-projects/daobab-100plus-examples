package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;


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
    @SuppressWarnings("unchecked")
    default Column<E, F, LanguageId> colLanguageId() {
        return ColumnCache.INSTANCE.getColumn("LanguageId", "LANGUAGE_ID", (Table<?>) this, Integer.class);
    }

}
