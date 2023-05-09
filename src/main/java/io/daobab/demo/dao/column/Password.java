package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Password<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getPassword() {
        return getColumnParam("Password");
    }

    @SuppressWarnings("unchecked")
    default E setPassword(F val) {
        setColumnParam("Password", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:STAFF,type:VARCHAR,size:40,nullable:true
     */
    default Column<E, F, Password> colPassword() {
        return new Column<E, F, Password>() {

            @Override
            public String getColumnName() {
                return "PASSWORD";
            }

            @Override
            public String getFieldName() {
                return "Password";
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
            public F getValue(Password entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Password");
                return (F) entity.getPassword();
            }

            @Override
            public void setValue(Password entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Password");
                entity.setPassword(param);
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
