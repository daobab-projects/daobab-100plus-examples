package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

import java.time.LocalDate;

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
    @SuppressWarnings({"unchecked","rawtypes"})
    default Column<E, F, ReleaseYear> colReleaseYear() {
        return ColumnCache.INSTANCE.getColumn("ReleaseYear","RELEASE_YEAR",(Table<?>)this,LocalDate.class);
    }


}
