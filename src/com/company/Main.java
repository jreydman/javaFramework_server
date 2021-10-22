package com.company;

import com.company.article.ArticleService;
import com.company.config.Config;

public class Main {

    public static void main(String[] args) {
        //  ACTIVATORS.........
        Config config = new Config();
        config.setReader("com");
        Reader reader = new Reader(config);
        ArticleService articleService = new ArticleService();

        // WORK.................
        boolean exist=true;
        while (exist)
        {
            try {
                String hash = reader.ScanHash();
                articleService.findOneByHash(hash);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("################################");
        }

    }
}
