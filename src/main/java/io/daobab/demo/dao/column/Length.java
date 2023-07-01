package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface Length<E extends Entity, F> extends EntityRelationMap<E> {


    default F getLength() {
        return getColumnParam("Length");
    }

    @SuppressWarnings("unchecked")
    default E setLength(F val) {
        return setColumnParam("Length", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:SMALLINT,size:16,nullable:true
     */
    default Column<E, F, Length> colLength() {
        return new Column<E, F, Length>() {

            @Override
            public String getColumnName() {
                return "LENGTH";
            }

            @Override
            public String getFieldName() {
                return "Length";
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
            public F getValue(Length entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "Length");
                return (F) entity.getLength();
            }

            @Override
            public Length setValue(Length entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "Length");
                return (Length) entity.setLength(param);
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
