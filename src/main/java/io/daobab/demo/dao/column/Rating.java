package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Rating<E extends Entity, F> extends EntityRelationMap<E> {


    default F getRating() {
        return getColumnParam("Rating");
    }

    @SuppressWarnings("unchecked")
    default E setRating(F val) {
        return setColumnParam("Rating", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:VARCHAR,size:5,nullable:true
     */
    default Column<E, F, Rating> colRating() {
        return new Column<E, F, Rating>() {

            @Override
            public String getColumnName() {
                return "RATING";
            }

            @Override
            public String getFieldName() {
                return "Rating";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return String.class;
            }

            @Override
            public F getValue(Rating entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Rating");
                return (F) entity.getRating();
            }

            @Override
            public Rating setValue(Rating entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Rating");
                return (Rating) entity.setRating(param);
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
