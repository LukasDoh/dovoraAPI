package com.dovora.dovoraAPI.controller;

import com.dovora.dovoraAPI.exception.ArticleNotFoundException;
import com.dovora.dovoraAPI.model.Article;
import com.dovora.dovoraAPI.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow CORS
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    // Get All Articles
    @GetMapping("/articles")
    public List<Article> getAllNotes() {
        return articleRepository.findAll();
    }

    // Create a new Article
    @PostMapping("/articles")
    public Article createNote(@Valid @RequestBody Article article) {
        return articleRepository.save(article);
    }

    // Get a single Note
    @GetMapping("/articles/{id}")
    public Article getNoteById(@PathVariable(value= "id") Long articleId) throws ArticleNotFoundException {

        return articleRepository.findById(articleId).
                orElseThrow(() -> new ArticleNotFoundException(articleId));
    }

    // Update a Note
    @PutMapping("articles/{id}")
    public Article updateNote(@PathVariable(value = "id") Long articleId,
                              @Valid @RequestBody Article articleDetails) throws ArticleNotFoundException {

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));

        article.setName(articleDetails.getName());
        article.setPrice(articleDetails.getPrice());
        article.setCategory(articleDetails.getCategory());

        Article updatedArticle = articleRepository.save(article);

        return updatedArticle;
    }

    // Delete a Note
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(value = "id") Long articleId) throws ArticleNotFoundException {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));

        articleRepository.delete(article);

        return ResponseEntity.ok().build();
    }
}
