package com.wangpin.ice.meitu.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * Created by wangpi on 6/20/2016.
 */
public class Category {
    private String name;
    private Bitmap icon;

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    private String path;
    private List<String> imgs;

    public Category(File file){
        this(file.getAbsolutePath());
    }

    public Category(String path){
        this.path = path;
        this.name = path.substring(path.indexOf(File.pathSeparator) + 1);
        List<String> files = (new Imgs(path)).list();
        int randomPos = ( (int)Math.ceil(Math.random() * 100) ) % files.size();
        this.icon = createBitMap(files.get(randomPos), 300);
        this.imgs = files;
    }

    public Category(String path, String name, Bitmap icon, List<String> imgs){
        this.path = path;
        this.name = name;
        this.icon = icon;
        this.imgs = imgs;
    }

    /**
     * 绘制缩略图
     */
    private Bitmap createBitMap(String iconPath, int size){
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(iconPath, opts);
        opts.inSampleSize = (int)(opts.outWidth * 1.0/size);
        opts.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(iconPath, opts);
    }
}
