package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface FirstName<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getFirstName() {
        return getColumnParam("FirstName");
    }

    @SuppressWarnings("unchecked")
    default E setFirstName(F val) {
        setColumnParam("FirstName", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ACTOR,type:VARCHAR,size:45,nullable:false
     * table:CUSTOMER,type:VARCHAR,size:45,nullable:false
     * table:STAFF,type:VARCHAR,size:45,nullable:false
     */
    default Column<E, F, FirstName> colFirstName() {
        return new Column<E, F, FirstName>() {

            @Override
            public String getColumnName() {
                return "FIRST_NAME";
            }

            @Override
            public String getFieldName() {
                return "FirstName";
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
            public F getValue(FirstName entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "FirstName");
                return (F) entity.getFirstName();
            }

            @Override
            public void setValue(FirstName entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "FirstName");
                entity.setFirstName(param);
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
