package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService{

    ArticleRepository repository;

    private static ArticleServiceImpl instance = new ArticleServiceImpl();

    private ArticleServiceImpl(){
        this.repository = ArticleRepository.getInstance();
    }

    public static ArticleServiceImpl getInstance() {
        return instance;
    }

    @Override
    public List<Article> getList() throws SQLException {
        return repository.getList();
    }
}
