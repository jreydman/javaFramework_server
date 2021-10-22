package com.company.article;

import com.company.dk.DK_Repository;

import java.time.LocalDate;
import java.util.*;

public class ArticleRepository {
   /* public Article one(String hash) throws RuntimeException
    {

        //CREATE ARGS.........
        HashMap<String,String> args = new HashMap<String,String>();
        args.put("hash",hash);

        List<HashMap<String, Object>> result_rows;
        result_rows = find("Articles",args);
        args=null;

        if(result_rows.isEmpty()) {
            throw new RuntimeException("Article not found");
        }

        HashMap<String, Object> art_map = result_rows.get(0);
        return new Article(
                (int) art_map.get("id"),
                (String) art_map.get("name"),
                (String) art_map.get("info"),
                (Double) art_map.get("price"),
                (String) art_map.get("hash"),
                (String) art_map.get("ImgURL"),
                LocalDate.parse(art_map.get("reg_date").toString()),
                (int) (Short) art_map.get("status") );
    } */
}
