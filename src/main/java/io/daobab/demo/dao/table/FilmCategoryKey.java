package io.daobab.demo.dao.table;

import io.daobab.demo.dao.column.FilmId;
import io.daobab.demo.dao.column.CategoryId;
import io.daobab.demo.dao.column.LastUpdate;

import io.daobab.model.CompositeColumns;
import io.daobab.model.Composite;
import io.daobab.model.EntityMap;
import io.daobab.model.TableColumn;

public interface FilmCategoryKey<E extends EntityMap & FilmId<E> & CategoryId<E>>
	extends  FilmId<E>, CategoryId<E>, Composite<E>{

	default CompositeColumns<FilmCategoryKey<E>> compositeFilmCategoryKey() {
	return new CompositeColumns<>(
			new TableColumn(colFilmId()).primaryKey().size(5),
			new TableColumn(colCategoryId()).primaryKey().size(3));
		}


}
