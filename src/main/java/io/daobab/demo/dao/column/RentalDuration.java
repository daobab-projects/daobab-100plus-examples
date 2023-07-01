package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface RentalDuration<E extends Entity, F> extends EntityRelationMap<E> {


    default F getRentalDuration() {
        return getColumnParam("RentalDuration");
    }

    @SuppressWarnings("unchecked")
    default E setRentalDuration(F val) {
        return setColumnParam("RentalDuration", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:TINYINT,size:8,nullable:false
     */
    default Column<E, F, RentalDuration> colRentalDuration() {
        return new Column<E, F, RentalDuration>() {

            @Override
            public String getColumnName() {
                return "RENTAL_DURATION";
            }

            @Override
            public String getFieldName() {
                return "RentalDuration";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return Integer.class;
            }

            @Override
            public F getValue(RentalDuration entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "RentalDuration");
                return (F) entity.getRentalDuration();
            }

            @Override
            public RentalDuration setValue(RentalDuration entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "RentalDuration");
                return (RentalDuration) entity.setRentalDuration(param);
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
