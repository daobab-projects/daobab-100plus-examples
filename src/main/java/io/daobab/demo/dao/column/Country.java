package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Country<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getCountry() {
        return getColumnParam("Country");
    }

    @SuppressWarnings("unchecked")
    default E setCountry(F val) {
        setColumnParam("Country", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:COUNTRY,type:VARCHAR,size:50,nullable:false
     */
    default Column<E, F, Country> colCountry() {
        return new Column<E, F, Country>() {

            @Override
            public String getColumnName() {
                return "COUNTRY";
            }

            @Override
            public String getFieldName() {
                return "Country";
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
            public F getValue(Country entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Country");
                return (F) entity.getCountry();
            }

            @Override
            public void setValue(Country entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Country");
                entity.setCountry(param);
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
