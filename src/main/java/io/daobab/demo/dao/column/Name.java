package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Name<E extends Entity, F> extends EntityRelationMap<E> {


    default F getName() {
        return getColumnParam("Name");
    }

    @SuppressWarnings("unchecked")
    default E setName(F val) {
        return setColumnParam("Name", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CATEGORY,type:VARCHAR,size:25,nullable:false
     * table:LANGUAGE,type:VARCHAR,size:20,nullable:false
     */
    default Column<E, F, Name> colName() {
        return new Column<E, F, Name>() {

            @Override
            public String getColumnName() {
                return "NAME";
            }

            @Override
            public String getFieldName() {
                return "Name";
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
            public F getValue(Name entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Name");
                return (F) entity.getName();
            }

            @Override
            public Name setValue(Name entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Name");
                return (Name) entity.setName(param);
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
