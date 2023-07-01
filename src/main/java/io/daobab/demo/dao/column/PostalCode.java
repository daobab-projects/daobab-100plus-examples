package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface PostalCode<E extends Entity, F> extends EntityRelationMap<E> {


    default F getPostalCode() {
        return getColumnParam("PostalCode");
    }

    @SuppressWarnings("unchecked")
    default E setPostalCode(F val) {
        return setColumnParam("PostalCode", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ADDRESS,type:VARCHAR,size:10,nullable:true
     */
    default Column<E, F, PostalCode> colPostalCode() {
        return new Column<E, F, PostalCode>() {

            @Override
            public String getColumnName() {
                return "POSTAL_CODE";
            }

            @Override
            public String getFieldName() {
                return "PostalCode";
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
            public F getValue(PostalCode entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "PostalCode");
                return (F) entity.getPostalCode();
            }

            @Override
            public PostalCode setValue(PostalCode entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "PostalCode");
                return (PostalCode) entity.setPostalCode(param);
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
