package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface CityId<E extends EntityMap, F> extends EntityRelationMap<E> {


    default F getCityId() {
        return getColumnParam("CityId");
    }

    @SuppressWarnings("unchecked")
    default E setCityId(F val) {
        setColumnParam("CityId", val);
        return (E) this;
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:ADDRESS,type:SMALLINT,size:16,nullable:false
     * table:CITY,type:SMALLINT,size:16,nullable:false
     */
    default Column<E, F, CityId> colCityId() {
        return new Column<E, F, CityId>() {

            @Override
            public String getColumnName() {
                return "CITY_ID";
            }

            @Override
            public String getFieldName() {
                return "CityId";
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
            public F getValue(CityId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "CityId");
                return (F) entity.getCityId();
            }

            @Override
            public void setValue(CityId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "CityId");
                entity.setCityId(param);
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
