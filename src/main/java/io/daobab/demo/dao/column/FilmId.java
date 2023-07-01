package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;

import java.util.Objects;



public interface FilmId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getFilmId() {
        return readParam("FilmId");
    }

    default E setFilmId(F val) {
        return storeParam("FilmId", val);
    }

    /**
     * table:FILM,type:SMALLINT,size:16,nullable:false
     * table:FILM_ACTOR,type:SMALLINT,size:16,nullable:false
     * table:FILM_CATEGORY,type:SMALLINT,size:16,nullable:false
     * table:FILM_TEXT,type:SMALLINT,size:16,nullable:false
     * table:INVENTORY,type:SMALLINT,size:16,nullable:false
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, FilmId> colFilmId() {
        return ColumnCache.INSTANCE.getColumn("FilmId","FILMID",(Table<?>)this,Integer.class);
    }

}
