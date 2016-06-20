package com.wangpin.ice.meitu.com.wangpin.ice.meitu.utils;

import android.os.Environment;

import java.io.File;
import java.util.Collection;
import org.apache.commons.io.FileUtils;

/**
 * Created by wangpi on 6/16/2016.
 */
public class Imgs {

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


    public Collection<File> list(){
        String[] exts = {"gif","jpg","jpeg","png"};
        return FileUtils.listFiles(root, exts, true);
    }

}
