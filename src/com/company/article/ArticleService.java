package com.company.article;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ArticleService implements ArticleServiceInterface{
    protected ArticleRepository manager;
    public ArticleService() {
        this.manager = new ArticleRepository();
    }

    @Override
    public void findOneByHash(String Hash)
    {
    /*    try {
            Article article = manager.one(Hash);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(article);
            System.out.println("ARTICLE: " + json);
        } catch (JsonProcessingException | RuntimeException ejs) {
            System.out.println(ejs.getMessage());
        }
*/
    }

}
