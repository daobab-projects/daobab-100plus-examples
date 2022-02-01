package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface ActorId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * ACTOR: SMALLINT
     * FILM_ACTOR: SMALLINT
     */
    default Integer getActorId(){return getColumnParam("ActorId");}
    @SuppressWarnings("unchecked")
    default E setActorId(Integer val){setColumnParam("ActorId",val); return (E)this;}

    @SuppressWarnings("rawtypes")
    default Column<E,Integer,ActorId> colActorId(){
        return new Column<E,Integer,ActorId>() {

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
            public Class<Integer> getFieldClass(){
                return  Integer.class;
            }

            @Override
            public Integer getValue(ActorId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"ActorId");
                return  entity.getActorId();
            }

            @Override
            public void setValue(ActorId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"ActorId");
                entity.setActorId(param);
            }

            @Override
            public int hashCode() {
                return toString().hashCode();
            }

            @Override
            public String toString(){
                return getEntityName()+"."+getFieldName();
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
