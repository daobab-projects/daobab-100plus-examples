package io.daobab.demo.dao.column;

import io.daobab.creation.ColumnCache;
import io.daobab.error.AttemptToReadFromNullEntityException;
import io.daobab.error.AttemptToWriteIntoNullEntityException;
import io.daobab.model.*;

import java.util.Objects;



public interface OriginalLanguageId<E extends Entity, F> extends EntityRelationMap<E> {


    default F getOriginalLanguageId() {
        return readParam("OriginalLanguageId");
    }

    default E setOriginalLanguageId(F val) {
        return storeParam("OriginalLanguageId", val);
    }

    /**
     * table:FILM,type:TINYINT,size:8,nullable:true
     */
    @SuppressWarnings("unchecked")
    default Column<E, F, OriginalLanguageId> colOriginalLanguageId() {
        return ColumnCache.INSTANCE.getColumn("OriginalLanguageId","ORIGINAL_LANGUAGE_ID",(Table<?>)this,Integer.class);
    }
//
//    @SuppressWarnings("rawtypes")
//
//    default Column<E, F, OriginalLanguageId> colOriginalLanguageId() {
//        return new Column<E, F, OriginalLanguageId>() {
//
//            @Override
//            public String getColumnName() {
//                return "ORIGINAL_LANGUAGE_ID";
//            }
//
//            @Override
//            public String getFieldName() {
//                return "OriginalLanguageId";
//            }
//
//            @Override
//            public E getInstance(){
//                return getEntity();
//            }
//
//            @Override
//            public Class getFieldClass() {
//                return Integer.class;
//            }
//
//            @Override
//            public F getValue(OriginalLanguageId entity) {
//                if (entity == null)
//                    throw new AttemptToReadFromNullEntityException(getEntityClass(), "OriginalLanguageId");
//                return (F) entity.getOriginalLanguageId();
//            }
//
//            @Override
//            public OriginalLanguageId setValue(OriginalLanguageId entity, F param) {
//                if (entity == null)
//                    throw new AttemptToWriteIntoNullEntityException(getEntityClass(), "OriginalLanguageId");
//                return (OriginalLanguageId) entity.setOriginalLanguageId(param);
//            }
//
//            @Override
//            public int hashCode() {
//                return toString().hashCode();
//            }
//
//            @Override
//            public String toString(){
//                return getEntityClass().getName()+"."+getFieldName();
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                if (this == obj)return true;
//                if (obj == null)return false;
//                if (getClass() != obj.getClass())return false;
//                Column other = (Column) obj;
//                return Objects.equals(hashCode(), other.hashCode());
//            }
//        };
//    }

}
