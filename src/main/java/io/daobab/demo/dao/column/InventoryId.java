package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityRelationMap;
import io.daobab.model.EntityMap;
import java.util.Objects;

import java.math.BigDecimal;

public interface InventoryId<E extends EntityMap> extends EntityRelationMap<E> {


    /**
     * INVENTORY: INTEGER
     * RENTAL: INTEGER
     */
    default BigDecimal getInventoryId(){return getColumnParam("InventoryId");}
    @SuppressWarnings("unchecked")
    default E setInventoryId(BigDecimal val){setColumnParam("InventoryId",val); return (E)this;}

    @SuppressWarnings("rawtypes")
    default Column<E,BigDecimal,InventoryId> colInventoryId(){
        return new Column<E,BigDecimal,InventoryId>() {

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
            public Class<BigDecimal> getFieldClass(){
                return  BigDecimal.class;
            }

            @Override
            public BigDecimal getValue(InventoryId entity){
                if (entity==null) throw new AttemptToReadFromNullEntityException(getEntityClass(),"InventoryId");
                return  entity.getInventoryId();
            }

            @Override
            public void setValue(InventoryId entity, BigDecimal param){
                if (entity==null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(),"InventoryId");
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
