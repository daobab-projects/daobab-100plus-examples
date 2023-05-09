package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;
import java.util.Objects;

public interface Amount<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getAmount() {
        return getColumnParam("Amount");
    }

    @SuppressWarnings("unchecked")
    default E setAmount(F val) {
        setColumnParam("Amount", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:PAYMENT,type:DECIMAL,size:5,nullable:false
     */
    default Column<E, F, Amount> colAmount() {
        return new Column<E, F, Amount>() {

            @Override
            public String getColumnName() {
                return "AMOUNT";
            }

            @Override
            public String getFieldName() {
                return "Amount";
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
            public F getValue(Amount entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Amount");
                return (F) entity.getAmount();
            }

            @Override
            public void setValue(Amount entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Amount");
                entity.setAmount(param);
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
