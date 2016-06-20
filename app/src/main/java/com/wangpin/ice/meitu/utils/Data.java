package com.wangpin.ice.meitu.utils;

import java.util.Collection;
import java.util.Map;
import java.util.Observable;

/**
 * Created by wangpi on 6/17/2016.
 */
public class Data extends Observable{

    private static Data data;



    private Map<String,Collection<String>> categories;

    private Data(){

    }

    public Map<String, Collection<String>> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, Collection<String>> categories) {
        this.categories = categories;
        this.setChanged();
        this.notifyObservers(categories);
    }

    public static Data getInstance(){
        if(data == null){
            data = new Data();
        }
        return data;
    }
}
