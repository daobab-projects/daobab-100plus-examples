package io.daobab.demo.dao.column;

import io.daobab.creation.DaobabCache;
import io.daobab.model.*;


@SuppressWarnings("unused")
public interface ActorId<E extends Entity> extends RelatedTo<E>, MapHandler<E> {

	default Integer getActorId(){
		return readParam("ActorId");
	}

	default E setActorId(Integer val){
		return storeParam("ActorId",val);
	}

    /**
     * table:ACTOR, type:SMALLINT, size:16, nullable:false
     * table:FILM_ACTOR, type:SMALLINT, size:16, nullable:false
     */
	@SuppressWarnings({"rawtypes","unchecked"})
	default Column<E, Integer,ActorId> colActorId(){
		return DaobabCache.getColumn("ActorId", "ACTOR_ID", (Table<?>) this, Integer.class);
	}
}
