package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.*;


public interface FilmId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {


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
    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, FilmId> colFilmId() {
        return ColumnCache.INSTANCE.getColumn("FilmId", "FILM_ID", (Table<?>) this, Integer.class);
    }

}
