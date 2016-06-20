package com.wangpin.ice.meitu.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by wangpi on 6/17/2016.
 */
public class Data {

    private static Data data;

    public Map<String, Collection<String>> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, Collection<String>> categories) {
        this.categories = categories;
    }

    private Map<String,Collection<String>> categories;

    private Data(){

    }

    public static Data getInstance(){
        if(data == null){
            data = new Data();
        }
        return data;
    }
}
