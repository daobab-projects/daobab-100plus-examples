package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface SpecialFeatures<E extends Entity, F> extends EntityRelationMap<E> {


    default F getSpecialFeatures() {
        return getColumnParam("SpecialFeatures");
    }

    @SuppressWarnings("unchecked")
    default E setSpecialFeatures(F val) {
        return setColumnParam("SpecialFeatures", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:VARCHAR,size:54,nullable:true
     */
    default Column<E, F, SpecialFeatures> colSpecialFeatures() {
        return new Column<E, F, SpecialFeatures>() {

            @Override
            public String getColumnName() {
                return "SPECIAL_FEATURES";
            }

            @Override
            public String getFieldName() {
                return "SpecialFeatures";
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
            public F getValue(SpecialFeatures entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "SpecialFeatures");
                return (F) entity.getSpecialFeatures();
            }

            @Override
            public SpecialFeatures setValue(SpecialFeatures entity, F param) {
                if (entity == null)
                    throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "SpecialFeatures");
                return (SpecialFeatures) entity.setSpecialFeatures(param);
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
