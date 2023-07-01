package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface AddressId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getAddressId() {
        return getColumnParam("AddressId");
    }

    @SuppressWarnings("unchecked")
    default E setAddressId(F val) {
        return setColumnParam("AddressId", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ADDRESS,type:SMALLINT,size:16,nullable:false
     * table:CUSTOMER,type:SMALLINT,size:16,nullable:false
     * table:STAFF,type:SMALLINT,size:16,nullable:false
     * table:STORE,type:SMALLINT,size:16,nullable:false
     */
    default Column<E, F, AddressId> colAddressId() {
        return new Column<E, F, AddressId>() {

            @Override
            public String getColumnName() {
                return "ADDRESS_ID";
            }

            @Override
            public String getFieldName() {
                return "AddressId";
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
            public F getValue(AddressId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "AddressId");
                return (F) entity.getAddressId();
            }

            @Override
            public AddressId setValue(AddressId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "AddressId");
                return (AddressId) entity.setAddressId(param);
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
