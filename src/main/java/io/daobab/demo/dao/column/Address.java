package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Address<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getAddress() {
        return getColumnParam("Address");
    }

    @SuppressWarnings("unchecked")
    default E setAddress(F val) {
        setColumnParam("Address", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ADDRESS,type:VARCHAR,size:50,nullable:false
     */
    default Column<E, F, Address> colAddress() {
        return new Column<E, F, Address>() {

            @Override
            public String getColumnName() {
                return "ADDRESS";
            }

            @Override
            public String getFieldName() {
                return "Address";
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
            public F getValue(Address entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Address");
                return (F) entity.getAddress();
            }

            @Override
            public void setValue(Address entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Address");
                entity.setAddress(param);
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
