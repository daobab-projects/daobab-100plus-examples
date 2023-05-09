package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface CountryId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getCountryId() {
        return getColumnParam("CountryId");
    }

    @SuppressWarnings("unchecked")
    default E setCountryId(F val) {
        setColumnParam("CountryId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:CITY,type:SMALLINT,size:16,nullable:false
     * table:COUNTRY,type:SMALLINT,size:16,nullable:false
     */
    default Column<E, F, CountryId> colCountryId() {
        return new Column<E, F, CountryId>() {

            @Override
            public String getColumnName() {
                return "COUNTRY_ID";
            }

            @Override
            public String getFieldName() {
                return "CountryId";
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
            public F getValue(CountryId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "CountryId");
                return (F) entity.getCountryId();
            }

            @Override
            public void setValue(CountryId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "CountryId");
                entity.setCountryId(param);
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
