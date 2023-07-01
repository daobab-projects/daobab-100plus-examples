package io.daobab.demo.dao.table;

import io.daobab.creation.DaobabCache;
import io.daobab.demo.dao.column.CategoryId;
import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.LastUpdate;
import io.daobab.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unused"})
@TableInformation(name = "FILM_CATEGORY")
public class FilmCategory extends Table<FilmCategory> implements
	FilmCategoryKey<FilmCategory>,
	FilmId<FilmCategory>,
	CategoryId<FilmCategory>,
	LastUpdate<FilmCategory>,

	PrimaryCompositeKey<FilmCategory,FilmCategoryKey<FilmCategory>>
	{

	public FilmCategory() {
		super();
	}

		public FilmCategory(Map<String, Object> parameters) {
		super(parameters);
	}

	@Override
	public List<TableColumn> columns() {
		return DaobabCache.getTableColumns(this,
			() -> Arrays.asList(
			new TableColumn(colFilmId()).primaryKey().size(16),
			new TableColumn(colCategoryId()).primaryKey().size(8),
			new TableColumn(colLastUpdate()).size(26).scale(6)

		));
	}

	
	@Override
	public CompositeColumns<FilmCategoryKey<FilmCategory>> colCompositeId() {
		return  compositeFilmCategoryKey();
	}
}
