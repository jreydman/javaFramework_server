package com.company.article;

import java.time.LocalDate;

public class Article {
    public static final int NOT_ACTIVATED = 0;
    public static final int ACTIVATED = 1;
    public static final int DEACTIVATED = 2;
    public Article(int id,String name,String info,Double price,String hash,String ImgURL,LocalDate reg_date,int status)
    {
        this.id=id;
        this.name=name;
        this.info=info;
        this.price=price;
        this.hash=hash;
        this.ImgURL= ImgURL;
        this.reg_date=reg_date;
        switch (status) {
            case 0 -> this.status = NOT_ACTIVATED;
            case 2 -> this.status = DEACTIVATED;
            default -> this.status = ACTIVATED;
        }
    }
    protected int id;
    protected String name;
    protected String info;
    protected Double price;
    protected String hash;
    protected String ImgURL;
    protected LocalDate reg_date;
    protected int status;

    public int getId() { return this.id; }
    public String getName()
    {
        return this.name;
    }
    public String getInfo()
    {
        return this.info;
    }
    public Double getPrice() {
        return this.price;
    }
    public String getHash() { return this.hash; }
    public String getImgURL() { return this.ImgURL; }
    //public LocalDate getReg_date() { return this.reg_date; }
    public int getStatus() { return this.status; }

    public void setActivated() { this.status=ACTIVATED; }
    public void setNotActivated() { this.status=ACTIVATED; }
    public void setDeactivated() { this.status=DEACTIVATED; }

}
