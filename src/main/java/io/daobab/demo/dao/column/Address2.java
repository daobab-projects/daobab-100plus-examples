package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Address2<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getAddress2() {
        return getColumnParam("Address2");
    }

    @SuppressWarnings("unchecked")
    default E setAddress2(F val) {
        setColumnParam("Address2", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ADDRESS,type:VARCHAR,size:50,nullable:true
     */
    default Column<E, F, Address2> colAddress2() {
        return new Column<E, F, Address2>() {

            @Override
            public String getColumnName() {
                return "ADDRESS2";
            }

            @Override
            public String getFieldName() {
                return "Address2";
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
            public F getValue(Address2 entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Address2");
                return (F) entity.getAddress2();
            }

            @Override
            public void setValue(Address2 entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Address2");
                entity.setAddress2(param);
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
