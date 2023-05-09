package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Email<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getEmail() {
        return getColumnParam("Email");
    }

    @SuppressWarnings("unchecked")
    default E setEmail(F val) {
        setColumnParam("Email", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CUSTOMER,type:VARCHAR,size:50,nullable:true
     * table:STAFF,type:VARCHAR,size:50,nullable:true
     */
    default Column<E, F, Email> colEmail() {
        return new Column<E, F, Email>() {

            @Override
            public String getColumnName() {
                return "EMAIL";
            }

            @Override
            public String getFieldName() {
                return "Email";
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
            public F getValue(Email entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Email");
                return (F) entity.getEmail();
            }

            @Override
            public void setValue(Email entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Email");
                entity.setEmail(param);
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
