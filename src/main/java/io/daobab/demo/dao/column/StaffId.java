package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface StaffId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getStaffId() {
        return getColumnParam("StaffId");
    }

    @SuppressWarnings("unchecked")
    default E setStaffId(F val) {
        return setColumnParam("StaffId", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:PAYMENT,type:TINYINT,size:8,nullable:false
     * table:RENTAL,type:TINYINT,size:8,nullable:false
     * table:STAFF,type:TINYINT,size:8,nullable:false
     */
    default Column<E, F, StaffId> colStaffId() {
        return new Column<E, F, StaffId>() {

            @Override
            public String getColumnName() {
                return "STAFF_ID";
            }

            @Override
            public String getFieldName() {
                return "StaffId";
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
            public F getValue(StaffId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "StaffId");
                return (F) entity.getStaffId();
            }

            @Override
            public StaffId setValue(StaffId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "StaffId");
                return (StaffId) entity.setStaffId(param);
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
