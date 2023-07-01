package io.daobab.demo.model;

import io.daobab.demo.dao.table.Actor;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;

public interface ActorLazy<E extends Entity> extends EntityRelationMap<E> {


    /**
     * db name: ACTOR_ID,
     * db type: SMALLINT
     */
    default Actor getActor() {
        return getColumnParam("Actor");
    }

    default E setActor(Actor val) {
        setColumnParam("Actor", val);
        return (E) this;
    }


}
