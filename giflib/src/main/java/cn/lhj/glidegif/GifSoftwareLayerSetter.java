package cn.lhj.glidegif;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.rastermill.FrameSequenceDrawable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.Target;

/**
 * File description.
 *
 * @author lihongjun
 * @date 2018/4/24
 */

public class GifSoftwareLayerSetter implements RequestListener<FrameSequenceDrawable> {

    private int mLoopCount = FrameSequenceDrawable.LOOP_DEFAULT; // gif播放次数

    /**
     * LOOP_ONCE LOOP_INF LOOP_DEFAULT具体含义查看FrameSequenceDrawable
     * @param loopCount
     */
    public GifSoftwareLayerSetter(int loopCount) {
        mLoopCount = loopCount;
    }

    @Override
    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<FrameSequenceDrawable> target, boolean isFirstResource) {
        ImageView view = ((ImageViewTarget<?>) target).getView();
        if (Build.VERSION_CODES.HONEYCOMB <= Build.VERSION.SDK_INT) {
            view.setLayerType(ImageView.LAYER_TYPE_NONE, null);
        }
        return false;
    }

    @Override
    public boolean onResourceReady(FrameSequenceDrawable resource, Object model, Target<FrameSequenceDrawable> target, DataSource dataSource, boolean isFirstResource) {
        ImageView view = ((ImageViewTarget<?>) target).getView();
        if (Build.VERSION_CODES.HONEYCOMB <= Build.VERSION.SDK_INT) {
            view.setLayerType(ImageView.LAYER_TYPE_SOFTWARE, null);
        }
        FrameSequenceDrawable drawable = new FrameSequenceDrawable(resource.getFramSequence());
        drawable.setLoopBehavior(mLoopCount);
        view.setImageDrawable(drawable);
        return true;
    }
}
