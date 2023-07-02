package io.daobab.demo.dao.table.enhanced;

import io.daobab.demo.dao.table.Film;
import io.daobab.demo.dao.table.Language;
import io.daobab.model.EnhancedEntity;
import io.daobab.model.TableName;
import io.daobab.query.base.Query;
import io.daobab.query.base.QueryJoin;

import java.util.Map;

import static io.daobab.demo.dao.Lang.English;
@TableName(value = "FILM")
public class EnglishFilm extends Film implements EnhancedEntity {

    private static final Language tabLanguage = new Language();

    @Override
    public <Q extends Query & QueryJoin<Q>> Q enhanceQuery(Q query) {
        return query.join(tabLanguage, colLanguageId(), and().equal(tabLanguage.colName(), English));
    }

    public EnglishFilm() {
        super();
    }

    public EnglishFilm(Map<String, Object> parameters) {
        super(parameters);
    }

}
