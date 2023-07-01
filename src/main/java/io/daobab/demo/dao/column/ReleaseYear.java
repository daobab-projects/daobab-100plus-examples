package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.time.LocalDate;
import java.util.Objects;

public interface ReleaseYear<E extends Entity, F> extends EntityRelationMap<E> {


    default F getReleaseYear() {
        return getColumnParam("ReleaseYear");
    }

    @SuppressWarnings("unchecked")
    default E setReleaseYear(F val) {
        return setColumnParam("ReleaseYear", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:DATE,size:10,nullable:true
     */
    default Column<E, F, ReleaseYear> colReleaseYear() {
        return new Column<E, F, ReleaseYear>() {

            @Override
            public String getColumnName() {
                return "RELEASE_YEAR";
            }

            @Override
            public String getFieldName() {
                return "ReleaseYear";
            }

            @Override
            public E getInstance(){
                return getEntity();
            }

            @Override
            public Class getFieldClass() {
                return LocalDate.class;
            }

            @Override
            public F getValue(ReleaseYear entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "ReleaseYear");
                return (F) entity.getReleaseYear();
            }

            @Override
            public ReleaseYear setValue(ReleaseYear entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "ReleaseYear");
                return (ReleaseYear) entity.setReleaseYear(param);
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
