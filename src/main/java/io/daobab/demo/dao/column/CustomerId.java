package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;

public interface CustomerId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * db name: CUSTOMER_ID,
     * db type: SMALLINT
     */
    default Integer getCustomerId() {
        return getColumnParam("CustomerId");
    }

    default E setCustomerId(Integer val) {
        setColumnParam("CustomerId", val);
        return (E) this;
    }

    default Column<E, Integer, CustomerId> colCustomerId() {
        return new Column<E, Integer, CustomerId>() {

            @Override
            public String getColumnName() {
                return "CUSTOMER_ID";
            }

            @Override
            public String getFieldName() {
                return "CustomerId";
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
            public Integer getValue(CustomerId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "CustomerId");
                return entity.getCustomerId();
            }

            @Override
            public void setValue(CustomerId entity, Integer param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "CustomerId");
                entity.setCustomerId(param);
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