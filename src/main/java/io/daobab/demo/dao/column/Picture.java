package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Picture<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getPicture() {
        return getColumnParam("Picture");
    }

    @SuppressWarnings("unchecked")
    default E setPicture(F val) {
        setColumnParam("Picture", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:STAFF,type:VARBINARY,size:1000000000,nullable:true
     */
    default Column<E, F, Picture> colPicture() {
        return new Column<E, F, Picture>() {

            @Override
            public String getColumnName() {
                return "PICTURE";
            }

            @Override
            public String getFieldName() {
                return "Picture";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return byte[].class;
            }

            @Override
            public F getValue(Picture entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Picture");
                return (F) entity.getPicture();
            }

            @Override
            public void setValue(Picture entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Picture");
                entity.setPicture(param);
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
