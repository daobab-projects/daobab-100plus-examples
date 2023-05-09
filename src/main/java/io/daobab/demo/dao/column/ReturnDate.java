package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.time.LocalDateTime;
import java.util.Objects;

public interface ReturnDate<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getReturnDate() {
        return getColumnParam("ReturnDate");
    }

    @SuppressWarnings("unchecked")
    default E setReturnDate(F val) {
        setColumnParam("ReturnDate", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:RENTAL,type:TIMESTAMP,size:26,nullable:true
     */
    default Column<E, F, ReturnDate> colReturnDate() {
        return new Column<E, F, ReturnDate>() {

            @Override
            public String getColumnName() {
                return "RETURN_DATE";
            }

            @Override
            public String getFieldName() {
                return "ReturnDate";
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
            public F getValue(ReturnDate entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "ReturnDate");
                return (F) entity.getReturnDate();
            }

            @Override
            public void setValue(ReturnDate entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "ReturnDate");
                entity.setReturnDate(param);
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
