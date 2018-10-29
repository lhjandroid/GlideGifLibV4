package cn.lhj.glidegif;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.rastermill.FrameSequence;
import android.support.rastermill.FrameSequenceDrawable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

/**
 * File description.
 * 自定义gif变换
 * @author lihongjun
 * @date 2018/4/24
 */

public class GifDrawableTranscoder implements ResourceTranscoder<FrameSequence, FrameSequenceDrawable> {

    @Nullable
    @Override
    public Resource<FrameSequenceDrawable> transcode(@NonNull Resource<FrameSequence> toTranscode, @NonNull Options options) {
        FrameSequenceDrawable drawable = new FrameSequenceDrawable(toTranscode.get());
        return new SimpleResource<>(drawable);
    }
}