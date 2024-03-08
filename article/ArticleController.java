package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    ArticleServiceImpl service;

    public ArticleController() {
        this.service = ArticleServiceImpl.getInstance();
    }


    public List<Article> findAll() throws SQLException {
        return service.findAll();
    }
}
