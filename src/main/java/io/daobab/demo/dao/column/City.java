package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface City<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getCity() {
        return getColumnParam("City");
    }

    @SuppressWarnings("unchecked")
    default E setCity(F val) {
        setColumnParam("City", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CITY,type:VARCHAR,size:50,nullable:false
     */
    default Column<E, F, City> colCity() {
        return new Column<E, F, City>() {

            @Override
            public String getColumnName() {
                return "CITY";
            }

            @Override
            public String getFieldName() {
                return "City";
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
            public F getValue(City entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "City");
                return (F) entity.getCity();
            }

            @Override
            public void setValue(City entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "City");
                entity.setCity(param);
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
