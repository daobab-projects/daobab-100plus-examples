package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


public interface ActorId<E extends Entity, F> extends RelatedTo<E>, MapHandler<E> {

	default F getActorId(){
		return readParam("ActorId");
	}

	default E setActorId(F val){
		return storeParam("ActorId",val);
	}
    /**
     * table:ACTOR, type:SMALLINT, size:16, nullable:false
     * table:FILM_ACTOR, type:SMALLINT, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, F,ActorId> colActorId(){
		return DaobabCache.getColumn("ActorId", "ACTOR_ID", (Table<?>) this, Integer.class);
	}
}
