package com.wangpin.ice.meitu.utils;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Created by wangpi on 6/16/2016.
 */
public class Imgs{

    private final String DEFAULT_PATH = "/";
    private File root;

    private Imgs(){
        this.root = Environment.getRootDirectory();
    }

    public Imgs(String path){
        this.root = new File(path);
    }

    public Imgs(File root){
        this.root = root;
    }

    public List<String> list(){
        String[] exts = {"gif","jpg","jpeg","png"};
        Collection<File> files =  FileUtils.listFiles(root, exts, true);
        Iterator<File> fileIter = files.iterator();
        List<String> imgPathes = new ArrayList<String>();
        while(fileIter.hasNext()){
            File f = fileIter.next();
            imgPathes.add(f.getAbsolutePath());
        }
        return imgPathes;
    }

}
