package cn.lhj.glidegif.module;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.rastermill.FrameSequence;
import android.support.rastermill.FrameSequenceDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.LibraryGlideModule;

import java.io.InputStream;

import cn.lhj.glidegif.GifDecoder;
import cn.lhj.glidegif.GifDrawableTranscoder;

/**
 * Filedescription.
 *
 * @author lihongjun
 * @date 2018/10/29
 */
@GlideModule
public class GifModule extends AppGlideModule{

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        registry.register(FrameSequence.class,FrameSequenceDrawable.class,new GifDrawableTranscoder()).append(InputStream.class,FrameSequence.class,new GifDecoder());

    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
