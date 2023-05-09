package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface ManagerStaffId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getManagerStaffId() {
        return getColumnParam("ManagerStaffId");
    }

    @SuppressWarnings("unchecked")
    default E setManagerStaffId(F val) {
        setColumnParam("ManagerStaffId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:STORE,type:TINYINT,size:8,nullable:false
     */
    default Column<E, F, ManagerStaffId> colManagerStaffId() {
        return new Column<E, F, ManagerStaffId>() {

            @Override
            public String getColumnName() {
                return "MANAGER_STAFF_ID";
            }

            @Override
            public String getFieldName() {
                return "ManagerStaffId";
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
            public F getValue(ManagerStaffId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "ManagerStaffId");
                return (F) entity.getManagerStaffId();
            }

            @Override
            public void setValue(ManagerStaffId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "ManagerStaffId");
                entity.setManagerStaffId(param);
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
