package com.wangpin.ice.meitu.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wangpin.ice.meitu.view.CategoryView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by wangpi on 6/16/2016.
 */
public class ImgDirs extends AsyncTask<String, Integer, Map<String,List<String>>> {
    private Context context;
    private ViewGroup categorysGroup;
    public ImgDirs(Context context, ViewGroup categorysGroup){
        this.context = context;
        this.categorysGroup = categorysGroup;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Map<String,List<String>> doInBackground(String... params) {
        Imgs imgs = new Imgs(params[0]);
        return init(imgs.list());
    }

    @Override
    protected void onPostExecute( Map<String,List<String>> categories){

        Iterator<String> iterDirs = categories.keySet().iterator();
        ImageView categoryView = null;
        while(iterDirs.hasNext()){
            String categoryPath = iterDirs.next();
            System.out.println("category Dir:" + categoryPath);
            Collection<String> categoryImgs = categories.get(categoryPath);
            categoryView = new CategoryView(context, categoryPath);
            categorysGroup.addView(categoryView);
        }
        System.out.println("线程执行完毕");
    }

    /**
     * 将遍历得到的图片文件列表转化为map结构 {folder, files}
     * @param imgs
     * @return
     */
    private Map<String,List<String>> init(List<String> imgs){

        Map<String,List<String>> collection = new HashMap<String,List<String>>();

        Iterator<String> iter = imgs.iterator();

        while(iter.hasNext()){
            String path = iter.next();
            String folder = (new File(path)).getParent();
            if(collection.containsKey(folder)){
                List<String> files = collection.get(folder);
                files.add(path);
            }else {
                List<String> files = new ArrayList<String>();
                files.add(path);
                collection.put(folder, files);
            }
        }

        return collection;
    }


}
