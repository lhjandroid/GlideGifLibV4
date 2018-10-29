package cn.lhj.glidegif.util;

import android.content.Context;
import android.net.Uri;
import android.support.rastermill.FrameSequenceDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import cn.lhj.glidegif.GifSoftwareLayerSetter;
import cn.lhj.glidegif.module.GlideApp;

/**
 * File description.
 * 自定义gif加载工具
 * @author lihongjun
 * @date 2018/4/24
 */

public class ImageGifLoader {

    /**
     *
     * @param context
     * @param url
     * @param targeView
     * @param loopCount 必须传LOOP_ONCE LOOP_INF LOOP_DEFAULT具体含义查看FrameSequenceDrawable
     */
    public static void display(Context context, String url, final ImageView targeView,int loopCount) {
        display(context,url,targeView,loopCount,-1,-1);
    }

    public static void display(Context context,String url,final ImageView targeView,int loopCount,int placeHolder,int errorHolder) {
        Uri uri = Uri.parse(url);
        // holder
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(errorHolder);
//        Glide.with(context)
//                .as(FrameSequenceDrawable.class)
//                .listener(new GifSoftwareLayerSetter(loopCount))
//                .apply(options)
//                .load(uri)
//                .into(targeView);
        GlideApp.with(context)
                .as(FrameSequenceDrawable.class)
                .listener(new GifSoftwareLayerSetter(loopCount))
                .apply(options)
                .load(uri)
                .into(targeView);

    }
}
