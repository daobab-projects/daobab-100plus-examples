package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Description<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getDescription() {
        return getColumnParam("Description");
    }

    @SuppressWarnings("unchecked")
    default E setDescription(F val) {
        setColumnParam("Description", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:VARCHAR,size:1000000000,nullable:true
     * table:FILM_TEXT,type:VARCHAR,size:1000000000,nullable:true
     */
    default Column<E, F, Description> colDescription() {
        return new Column<E, F, Description>() {

            @Override
            public String getColumnName() {
                return "DESCRIPTION";
            }

            @Override
            public String getFieldName() {
                return "Description";
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
            public F getValue(Description entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Description");
                return (F) entity.getDescription();
            }

            @Override
            public void setValue(Description entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Description");
                entity.setDescription(param);
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
