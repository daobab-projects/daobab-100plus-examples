package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Title<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getTitle() {
        return getColumnParam("Title");
    }

    @SuppressWarnings("unchecked")
    default E setTitle(F val) {
        setColumnParam("Title", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:VARCHAR,size:255,nullable:false
     * table:FILM_TEXT,type:VARCHAR,size:255,nullable:false
     */
    default Column<E, F, Title> colTitle() {
        return new Column<E, F, Title>() {

            @Override
            public String getColumnName() {
                return "TITLE";
            }

            @Override
            public String getFieldName() {
                return "Title";
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
            public F getValue(Title entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Title");
                return (F) entity.getTitle();
            }

            @Override
            public void setValue(Title entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Title");
                entity.setTitle(param);
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
