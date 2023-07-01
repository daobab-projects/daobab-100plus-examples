package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;
import java.util.Objects;

public interface ReplacementCost<E extends Entity, F> extends EntityRelationMap<E> {


    default F getReplacementCost() {
        return getColumnParam("ReplacementCost");
    }

    @SuppressWarnings("unchecked")
    default E setReplacementCost(F val) {
        return setColumnParam("ReplacementCost", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:DECIMAL,size:5,nullable:false
     */
    default Column<E, F, ReplacementCost> colReplacementCost() {
        return new Column<E, F, ReplacementCost>() {

            @Override
            public String getColumnName() {
                return "REPLACEMENT_COST";
            }

            @Override
            public String getFieldName() {
                return "ReplacementCost";
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
            public F getValue(ReplacementCost entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "ReplacementCost");
                return (F) entity.getReplacementCost();
            }

            @Override
            public ReplacementCost setValue(ReplacementCost entity, F param) {
                if (entity == null)
                    throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "ReplacementCost");
                return (ReplacementCost) entity.setReplacementCost(param);
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
