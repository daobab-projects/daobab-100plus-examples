package io.daobab.demo.dao.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.demo.dao.column.CategoryId;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.model.CompositeColumns;
import io.daobab.model.PrimaryCompositeKey;
import io.daobab.model.Table;
import io.daobab.model.TableColumn;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class FilmCategory extends Table implements
        FilmCategoryKey<FilmCategory>,
        FilmId<FilmCategory, Integer>,
        CategoryId<FilmCategory, Integer>,
        LastUpdate<FilmCategory, LocalDateTime>,

        PrimaryCompositeKey<FilmCategory, FilmCategoryKey<FilmCategory>> {

    @Override
    public String getEntityName() {
        return "FILM_CATEGORY";
    }

    @Override
    public CompositeColumns<FilmCategoryKey<FilmCategory>> colCompositeId() {
        return compositeFilmCategoryKey();
    }

    @Override
    public List<TableColumn> columns() {
        return Arrays.asList(
                new TableColumn(colFilmId()).primaryKey().size(16),
                new TableColumn(colCategoryId()).primaryKey().size(8),
                new TableColumn(colLastUpdate()).size(26).scale(6)
        );
    }

    @Override
    public FilmCategory clone() {
        return EntityDuplicator.cloneEntity(this);
    }


}
