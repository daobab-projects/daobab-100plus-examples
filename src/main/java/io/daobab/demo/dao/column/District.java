package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface District<E extends Entity, F> extends EntityRelationMap<E> {


    default F getDistrict() {
        return getColumnParam("District");
    }

    @SuppressWarnings("unchecked")
    default E setDistrict(F val) {
        return setColumnParam("District", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ADDRESS,type:VARCHAR,size:20,nullable:false
     */
    default Column<E, F, District> colDistrict() {
        return new Column<E, F, District>() {

            @Override
            public String getColumnName() {
                return "DISTRICT";
            }

            @Override
            public String getFieldName() {
                return "District";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return String.class;
            }

            @Override
            public F getValue(District entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "District");
                return (F) entity.getDistrict();
            }

            @Override
            public District setValue(District entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "District");
                return (District) entity.setDistrict(param);
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
