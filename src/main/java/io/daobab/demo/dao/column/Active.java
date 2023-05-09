package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Active<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getActive() {
        return getColumnParam("Active");
    }

    @SuppressWarnings("unchecked")
    default E setActive(F val) {
        setColumnParam("Active", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CUSTOMER,type:BOOLEAN,size:1,nullable:false
     * table:STAFF,type:BOOLEAN,size:1,nullable:false
     */
    default Column<E, F, Active> colActive() {
        return new Column<E, F, Active>() {

            @Override
            public String getColumnName() {
                return "ACTIVE";
            }

            @Override
            public String getFieldName() {
                return "Active";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return Boolean.class;
            }

            @Override
            public F getValue(Active entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Active");
                return (F) entity.getActive();
            }

            @Override
            public void setValue(Active entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Active");
                entity.setActive(param);
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
