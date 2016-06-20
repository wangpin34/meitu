package com.wangpin.ice.meitu.com.wangpin.ice.meitu.utils;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by wangpi on 6/16/2016.
 */
public class ImgDirs {

    private Collection<File> imgs;
    private ImgDirs(){}
    public ImgDirs(Collection<File> imgs){
        this.imgs = imgs;
    }

    public Map<String,Collection<String>> init(){
        Map<String,Collection<String>> collection = new HashMap<String,Collection<String>>();

        Iterator<File> iter = imgs.iterator();

        while(iter.hasNext()){
            File img = iter.next();
            String path = img.getAbsolutePath();
            String folder = img.getParent();
            if(collection.containsKey(folder)){
                Collection<String> files = collection.get(folder);
                files.add(path);
            }else {
                Collection<String> files = new LinkedList<String>();
                files.add(path);
                collection.put(folder, files);
            }
        }

        return collection;
    }



}
