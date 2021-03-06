package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;

public interface RentalDuration<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: RENTAL_DURATION,
     * db type: TINYINT
     */
    default Integer getRentalDuration() {
        return getColumnParam("RentalDuration");
    }

    default E setRentalDuration(Integer val) {
        setColumnParam("RentalDuration", val);
        return (E) this;
    }

    default Column<E, Integer, RentalDuration> colRentalDuration() {
        return new Column<E, Integer, RentalDuration>() {

            @Override
            public String getColumnName() {
                return "RENTAL_DURATION";
            }

            @Override
            public String getFieldName() {
                return "RentalDuration";
            }

            @Override
            public E getInstance() {
                return getEntity();
            }

            @Override
            public Class<Integer> getFieldClass() {
                return Integer.class;
            }

            @Override
            public Integer getValue(RentalDuration entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "RentalDuration");
                return entity.getRentalDuration();
            }

            @Override
            public void setValue(RentalDuration entity, Integer param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "RentalDuration");
                entity.setRentalDuration(param);
            }

            @Override
            public int hashCode() {
                return toString().hashCode();
            }

            @Override
            public String toString() {
                return getEntityName() + "." + getFieldName();
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null) return false;
                if (getClass() != obj.getClass()) return false;
                Column other = (Column) obj;
                return Objects.equals(hashCode(), other.hashCode());
            }
        };
    }

}