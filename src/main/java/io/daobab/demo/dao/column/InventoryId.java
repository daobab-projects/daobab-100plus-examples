package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.math.BigDecimal;
import java.util.Objects;

public interface InventoryId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getInventoryId() {
        return getColumnParam("InventoryId");
    }

    @SuppressWarnings("unchecked")
    default E setInventoryId(F val) {
        setColumnParam("InventoryId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:INVENTORY,type:INTEGER,size:32,nullable:false
     * table:RENTAL,type:INTEGER,size:32,nullable:false
     */
    default Column<E, F, InventoryId> colInventoryId() {
        return new Column<E, F, InventoryId>() {

            @Override
            public String getColumnName() {
                return "INVENTORY_ID";
            }

            @Override
            public String getFieldName() {
                return "InventoryId";
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
            public F getValue(InventoryId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "InventoryId");
                return (F) entity.getInventoryId();
            }

            @Override
            public void setValue(InventoryId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "InventoryId");
                entity.setInventoryId(param);
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
