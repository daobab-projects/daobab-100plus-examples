package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Phone<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getPhone() {
        return getColumnParam("Phone");
    }

    @SuppressWarnings("unchecked")
    default E setPhone(F val) {
        setColumnParam("Phone", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ADDRESS,type:VARCHAR,size:20,nullable:false
     */
    default Column<E, F, Phone> colPhone() {
        return new Column<E, F, Phone>() {

            @Override
            public String getColumnName() {
                return "PHONE";
            }

            @Override
            public String getFieldName() {
                return "Phone";
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
            public F getValue(Phone entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Phone");
                return (F) entity.getPhone();
            }

            @Override
            public void setValue(Phone entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Phone");
                entity.setPhone(param);
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
