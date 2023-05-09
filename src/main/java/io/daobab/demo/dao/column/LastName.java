package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface LastName<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getLastName() {
        return getColumnParam("LastName");
    }

    @SuppressWarnings("unchecked")
    default E setLastName(F val) {
        setColumnParam("LastName", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ACTOR,type:VARCHAR,size:45,nullable:false
     * table:CUSTOMER,type:VARCHAR,size:45,nullable:false
     * table:STAFF,type:VARCHAR,size:45,nullable:false
     */
    default Column<E, F, LastName> colLastName() {
        return new Column<E, F, LastName>() {

            @Override
            public String getColumnName() {
                return "LAST_NAME";
            }

            @Override
            public String getFieldName() {
                return "LastName";
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
            public F getValue(LastName entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "LastName");
                return (F) entity.getLastName();
            }

            @Override
            public void setValue(LastName entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "LastName");
                entity.setLastName(param);
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
