package io.daobab.demo.dao.table;

import io.daobab.creation.DaobabCache;
import io.daobab.demo.dao.column.LanguageId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.demo.dao.column.NameLang;
import io.daobab.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "LANGUAGE")
public class Language extends Table<Language> implements
        LanguageId<Language>,
        NameLang<Language>,
        LastUpdate<Language>,

        PrimaryKey<Language, Integer, LanguageId> {

    public Language() {
        super();
    }

    public Language(Map<String, Object> parameters) {
        super(parameters);
    }

    @Override
    public List<TableColumn> columns() {
        return DaobabCache.getTableColumns(this,
                () -> Arrays.asList(
                        new TableColumn(colLanguageId()).primaryKey().size(8),
                        new TableColumn(colName()).size(20),
                        new TableColumn(colLastUpdate()).size(26).scale(6)

                ));
    }


    @Override
    public Column<Language, Integer, LanguageId> colID() {
        return colLanguageId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PrimaryKey<?, ?, ?> other = (PrimaryKey<?, ?, ?>) obj;
        return Objects.equals(getId(), other.getId());
    }


}
