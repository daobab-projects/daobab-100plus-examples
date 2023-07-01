package io.daobab.demo.dao.column;

import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.Column;
import io.daobab.model.Entity;
import io.daobab.model.EntityMap;
import io.daobab.model.EntityRelationMap;

import java.util.Objects;



public interface LanguageId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getLanguageId() {
        return getColumnParam("LanguageId");
    }

    @SuppressWarnings("unchecked")
    default E setLanguageId(F val) {
        return setColumnParam("LanguageId", val);
    }

    @SuppressWarnings("rawtypes")
    /**
     * table:FILM,type:TINYINT,size:8,nullable:false
     * table:LANGUAGE,type:TINYINT,size:8,nullable:false
     */
    default Column<E, F, LanguageId> colLanguageId() {
        return new Column<E, F, LanguageId>() {

            @Override
            public String getColumnName() {
                return "LANGUAGE_ID";
            }

            @Override
            public String getFieldName() {
                return "LanguageId";
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
            public F getValue(LanguageId entity) {
                if (entity == null) throw new AttemptToReadFromNullEntityException(getEntityClass(), "LanguageId");
                return (F) entity.getLanguageId();
            }

            @Override
            public LanguageId setValue(LanguageId entity, F param) {
                if (entity == null) throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "LanguageId");
                return (LanguageId) entity.setLanguageId(param);
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
