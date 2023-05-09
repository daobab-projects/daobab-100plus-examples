package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface StoreId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getStoreId() {
        return getColumnParam("StoreId");
    }

    @SuppressWarnings("unchecked")
    default E setStoreId(F val) {
        setColumnParam("StoreId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CUSTOMER,type:TINYINT,size:8,nullable:false
     * table:INVENTORY,type:TINYINT,size:8,nullable:false
     * table:STAFF,type:TINYINT,size:8,nullable:false
     * table:STORE,type:TINYINT,size:8,nullable:false
     */
    default Column<E, F, StoreId> colStoreId() {
        return new Column<E, F, StoreId>() {

            @Override
            public String getColumnName() {
                return "STORE_ID";
            }

            @Override
            public String getFieldName() {
                return "StoreId";
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
            public F getValue(StoreId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "StoreId");
                return (F) entity.getStoreId();
            }

            @Override
            public void setValue(StoreId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "StoreId");
                entity.setStoreId(param);
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
