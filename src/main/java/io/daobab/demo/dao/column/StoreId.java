package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.lang.Integer;

public interface StoreId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * CUSTOMER: TINYINT
     * INVENTORY: TINYINT
     * STAFF: TINYINT
     * STORE: TINYINT
     */
    default Integer getStoreId(){return getColumnParam("StoreId");}
    @SuppressWarnings("unchecked")
    default E setStoreId(Integer val){setColumnParam("StoreId",val); return (E)this;}

    @SuppressWarnings("rawtypes")
    default Column<E,Integer,StoreId> colStoreId(){
        return new Column<E,Integer,StoreId>() {

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
            public Class<Integer> getFieldClass(){
                return  Integer.class;
            }

            @Override
            public Integer getValue(StoreId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"StoreId");
                return  entity.getStoreId();
            }

            @Override
            public void setValue(StoreId entity, Integer param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"StoreId");
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
