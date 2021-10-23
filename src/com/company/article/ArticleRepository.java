package com.company.article;

import com.company.dk.DK_Repository;

import java.time.LocalDate;
import java.util.*;

public class ArticleRepository extends DK_Repository implements ArticleRepositoryInterface {

    @Override
    public Article get(String Hash) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Hash", Hash);
        try {
            var art_map = one("Article", hashMap);
            return new Article(
                (int) art_map.get("id"),
                (String) art_map.get("name"),
                (String) art_map.get("info"),
                (Double) art_map.get("price"),
                (String) art_map.get("hash"),
                (String) art_map.get("ImgURL"),
                LocalDate.parse(art_map.get("reg_date").toString()),
                (int) (Short) art_map.get("status") );
        } catch(RuntimeException re) {
            re.printStackTrace();
            return null;
        }
    }
}