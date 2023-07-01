package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;
import java.util.Objects;

public interface RentalId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getRentalId() {
        return getColumnParam("RentalId");
    }

    @SuppressWarnings("unchecked")
    default E setRentalId(F val) {
        return setColumnParam("RentalId", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:PAYMENT,type:INTEGER,size:32,nullable:true
     * table:RENTAL,type:INTEGER,size:32,nullable:false
     */
    default Column<E, F, RentalId> colRentalId() {
        return new Column<E, F, RentalId>() {

            @Override
            public String getColumnName() {
                return "RENTAL_ID";
            }

            @Override
            public String getFieldName() {
                return "RentalId";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return BigDecimal.class;
            }

            @Override
            public F getValue(RentalId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "RentalId");
                return (F) entity.getRentalId();
            }

            @Override
            public RentalId setValue(RentalId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "RentalId");
                return (RentalId) entity.setRentalId(param);
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
