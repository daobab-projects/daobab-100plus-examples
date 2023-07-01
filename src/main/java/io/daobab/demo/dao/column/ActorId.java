package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface ActorId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getActorId() {
        return getColumnParam("ActorId");
    }

    @SuppressWarnings("unchecked")
    default E setActorId(F val) {
        return setColumnParam("ActorId", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ACTOR,type:SMALLINT,size:16,nullable:false
     * table:FILM_ACTOR,type:SMALLINT,size:16,nullable:false
     */
    default Column<E, F, ActorId> colActorId() {
        return new Column<E, F, ActorId>() {

            @Override
            public String getColumnName() {
                return "ACTOR_ID";
            }

            @Override
            public String getFieldName() {
                return "ActorId";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return Integer.class;
            }

            @Override
            public F getValue(ActorId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "ActorId");
                return (F) entity.getActorId();
            }

            @Override
            public ActorId setValue(ActorId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "ActorId");
                return (ActorId) entity.setActorId(param);
            }

            @Override
            public int hashCode() {
                return toString().hashCode();
            }

            @Override
            public String toString(){
                return getEntityClass().getName()+"."+getFieldName();
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)return true;
                if (obj == null)return false;
                if (getClass() != obj.getClass())return false;
                Column other = (Column) obj;
                return Objects.equals(hashCode(), other.hashCode());
            }
        };
    }

}
