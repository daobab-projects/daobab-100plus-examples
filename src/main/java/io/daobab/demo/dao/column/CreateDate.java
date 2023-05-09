package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.time.LocalDateTime;
import java.util.Objects;

public interface CreateDate<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getCreateDate() {
        return getColumnParam("CreateDate");
    }

    @SuppressWarnings("unchecked")
    default E setCreateDate(F val) {
        setColumnParam("CreateDate", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CUSTOMER,type:TIMESTAMP,size:26,nullable:false
     */
    default Column<E, F, CreateDate> colCreateDate() {
        return new Column<E, F, CreateDate>() {

            @Override
            public String getColumnName() {
                return "CREATE_DATE";
            }

            @Override
            public String getFieldName() {
                return "CreateDate";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return LocalDateTime.class;
            }

            @Override
            public F getValue(CreateDate entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "CreateDate");
                return (F) entity.getCreateDate();
            }

            @Override
            public void setValue(CreateDate entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "CreateDate");
                entity.setCreateDate(param);
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
