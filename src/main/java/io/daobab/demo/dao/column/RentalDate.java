package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.time.LocalDateTime;
import java.util.Objects;

public interface RentalDate<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getRentalDate() {
        return getColumnParam("RentalDate");
    }

    @SuppressWarnings("unchecked")
    default E setRentalDate(F val) {
        setColumnParam("RentalDate", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:RENTAL,type:TIMESTAMP,size:26,nullable:false
     */
    default Column<E, F, RentalDate> colRentalDate() {
        return new Column<E, F, RentalDate>() {

            @Override
            public String getColumnName() {
                return "RENTAL_DATE";
            }

            @Override
            public String getFieldName() {
                return "RentalDate";
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
            public F getValue(RentalDate entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "RentalDate");
                return (F) entity.getRentalDate();
            }

            @Override
            public void setValue(RentalDate entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "RentalDate");
                entity.setRentalDate(param);
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
