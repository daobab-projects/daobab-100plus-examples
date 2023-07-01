package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.Table;


public interface ActorId<E extends Entity, F> extends EntityRelationMap<E> {

    default F getActorId() {
        return readParam("ActorId");
    }

    default E setActorId(F val) {
        return storeParam("ActorId", val);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    default Column<E, F, ActorId> colActorId() {
        return ColumnCache.INSTANCE.getColumn("ActorId", "ACTOR_ID", (Table<?>) this, Integer.class);
    }

}
