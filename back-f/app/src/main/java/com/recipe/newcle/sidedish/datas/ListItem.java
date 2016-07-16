package com.recipe.newcle.sidedish.datas;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hoyun on 2016-03-30.
 */
public class ListItem {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    private String image;
    public String type ;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getImage(){
        return image;
    }
    public void setType(int type){
        this.type = String.valueOf(type);
        this.image = String.format("http://1.230.121.85:8001/back/image.php?type=%s1&id="+id,type);
    }
}