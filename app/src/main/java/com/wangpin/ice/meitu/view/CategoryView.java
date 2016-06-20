package com.wangpin.ice.meitu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;

import com.wangpin.ice.meitu.utils.Category;

/**
 * Created by wangpi on 6/17/2016.
 */
public class CategoryView extends ImageView {

    private String path;
    private int size = 300;
    private Category category;

    public CategoryView(Context cxt, String path){
        super(cxt);
        this.path = path;
        this.category = new Category(path);
        this.setImageBitmap(category.getIcon());
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        adjustSize();
    }

    /**
     * 设置图片大小
     */
    private void adjustSize(){
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = size;
        layoutParams.height = size;
        //layoutParams.width = layoutParams.WRAP_CONTENT;
        //layoutParams.height = layoutParams.WRAP_CONTENT;
        this.setLayoutParams(layoutParams);
    }


}

