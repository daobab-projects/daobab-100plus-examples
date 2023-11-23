package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public interface ReleaseYear<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default LocalDateTime getReleaseYear(){
		return readParam("ReleaseYear");
	}

	default E setReleaseYear(LocalDateTime val){
		return storeParam("ReleaseYear",val);
	}

    /**
     * table:FILM, type:DATE, size:10, nullable:true
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, LocalDate,ReleaseYear> colReleaseYear(){
		return DaobabCache.getColumn("ReleaseYear", "RELEASE_YEAR", (Table<?>) this, LocalDate.class);
	}
}
