package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface CustomerId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getCustomerId() {
        return getColumnParam("CustomerId");
    }

    @SuppressWarnings("unchecked")
    default E setCustomerId(F val) {
        setColumnParam("CustomerId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CUSTOMER,type:SMALLINT,size:16,nullable:false
     * table:PAYMENT,type:SMALLINT,size:16,nullable:false
     * table:RENTAL,type:SMALLINT,size:16,nullable:false
     */
    default Column<E, F, CustomerId> colCustomerId() {
        return new Column<E, F, CustomerId>() {

            @Override
            public String getColumnName() {
                return "CUSTOMER_ID";
            }

            @Override
            public String getFieldName() {
                return "CustomerId";
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
            public F getValue(CustomerId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "CustomerId");
                return (F) entity.getCustomerId();
            }

            @Override
            public void setValue(CustomerId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "CustomerId");
                entity.setCustomerId(param);
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
