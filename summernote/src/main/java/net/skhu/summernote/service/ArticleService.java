package net.skhu.summernote.service;

import net.skhu.summernote.domain.Article;
import net.skhu.summernote.domain.Board;
import net.skhu.summernote.domain.User;
import net.skhu.summernote.model.ArticleModel;
import net.skhu.summernote.model.Option;
import net.skhu.summernote.model.Pagination;
import net.skhu.summernote.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article findOne(int id) {
        return articleRepository.findById(id).get();
    }

    public List<Article> findAll(Pagination pagination) {
        return articleRepository.findAll(pagination);
    }

    public void update(ArticleModel a) {
        articleRepository.update(a.getId(), a.getTitle(), a.getBody());
    }

    public int insertArticle(ArticleModel a, int boardId, int userId) {
        Article last = articleRepository.findTopByBoardIdOrderByNoDesc(boardId);
        int no = (last == null) ? 1 : last.getNo() + 1;
        Article article = new Article();
        article.setBoard(new Board());
        article.getBoard().setId(boardId);
        article.setUser(new User());
        article.getUser().setId(userId);
        article.setWriteTime(new Date());
        article.setNo(no);
        article.setTitle(a.getTitle());
        article.setBody(a.getBody());
        articleRepository.save(article);
        return article.getId();
    }

    public void delete(int id){
        articleRepository.deleteById(id);
    }

    public Option[] getOrderByOptions(){
        return ArticleRepository.orderBy;
    }

    public Option[] getSearchByOptions(){
        return ArticleRepository.searchBy;
    }
}
