package com.recipe.newcle.sidedish;

/**
 * Created by hoyun on 2016-03-30.
 */
public class GridItem {
    private int picutre;
    private String name;
    private String url;
    public String getName() {
        return name;
    }

    public int getPicutre() {
        return picutre;
    }

    public String getUrl(){return url;}

    public GridItem(int picutre, String name, String url) {
        this.name = name;
        this.picutre = picutre;
        this.url = url;
    }



}
