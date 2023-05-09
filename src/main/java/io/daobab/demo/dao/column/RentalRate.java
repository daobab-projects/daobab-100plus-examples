package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;
import java.util.Objects;

public interface RentalRate<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getRentalRate() {
        return getColumnParam("RentalRate");
    }

    @SuppressWarnings("unchecked")
    default E setRentalRate(F val) {
        setColumnParam("RentalRate", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:DECIMAL,size:4,nullable:false
     */
    default Column<E, F, RentalRate> colRentalRate() {
        return new Column<E, F, RentalRate>() {

            @Override
            public String getColumnName() {
                return "RENTAL_RATE";
            }

            @Override
            public String getFieldName() {
                return "RentalRate";
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
            public F getValue(RentalRate entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "RentalRate");
                return (F) entity.getRentalRate();
            }

            @Override
            public void setValue(RentalRate entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "RentalRate");
                entity.setRentalRate(param);
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
