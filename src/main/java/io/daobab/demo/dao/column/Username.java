package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Username<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getUsername() {
        return getColumnParam("Username");
    }

    @SuppressWarnings("unchecked")
    default E setUsername(F val) {
        setColumnParam("Username", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:STAFF,type:VARCHAR,size:16,nullable:false
     */
    default Column<E, F, Username> colUsername() {
        return new Column<E, F, Username>() {

            @Override
            public String getColumnName() {
                return "USERNAME";
            }

            @Override
            public String getFieldName() {
                return "Username";
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
            public F getValue(Username entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Username");
                return (F) entity.getUsername();
            }

            @Override
            public void setValue(Username entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Username");
                entity.setUsername(param);
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
