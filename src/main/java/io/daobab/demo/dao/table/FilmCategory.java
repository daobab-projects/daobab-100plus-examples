package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.CategoryId;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.model.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@TableName(value = "FILM_CATEGORY")
public class FilmCategory extends Table<FilmCategory> implements
        FilmCategoryKey<FilmCategory>,
        FilmId<FilmCategory, Integer>,
        CategoryId<FilmCategory, Integer>,
        LastUpdate<FilmCategory, LocalDateTime>,

        PrimaryCompositeKey<FilmCategory, FilmCategoryKey<FilmCategory>> {


    public FilmCategory() {
        super();
    }

    public FilmCategory(Map<String, Object> parameters) {
        super(parameters);
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

}
