package io.daobab.demo.dao.table.enhanced;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.dao.table.Language;
import io.daobab.model.EnhancedEntity;
import io.daobab.query.base.Query;

import static io.daobab.demo.dao.Lang.English;

public class EnglishFilm extends Film implements EnhancedEntity {

    private static final Language tabLanguage = new Language();

    @Override
    public <Q extends Query> Q enhanceQuery(Q query) {
        return (Q) query
                .join(tabLanguage, colLanguageId(), and().equal(tabLanguage.colName(), English));
    }

}
