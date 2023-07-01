package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.time.LocalDate;
import java.util.Objects;

public interface ReleaseYear<E extends Entity, F> extends EntityRelationMap<E> {


    default F getReleaseYear() {
        return readParam("ReleaseYear");
    }

    default E setReleaseYear(F val) {
        return storeParam("ReleaseYear", val);
    }

    /**
     * table:FILM,type:DATE,size:10,nullable:true
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, ReleaseYear> colReleaseYear() {
        return ColumnCache.INSTANCE.getColumn("ReleaseYear","RELEASE_YEAR",(Table<?>)this,LocalDate.class);
    }


}
