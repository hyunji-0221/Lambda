package article;

import common.AbstractService;
import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService{

    ArticleRepository repository;

    private final static ArticleServiceImpl instance = new ArticleServiceImpl();

    private ArticleServiceImpl(){
        this.repository = ArticleRepository.getInstance();
    }

    public static ArticleServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Messenger save(Article article) {
        return null;
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Article> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Article article) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
