package cn.lhj.glidegiflibsv4;

import android.support.rastermill.FrameSequenceDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import cn.lhj.glidegif.util.ImageGifLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView iv,iv1,iv2,iv3,iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadImage();
    }

    private void initView() {
        iv = findViewById(R.id.iv);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);
    }

    private void loadImage() {
        String url = "http://hiphotos.baidu.com/feed/pic/item/71cf3bc79f3df8dc41ae9d2dc611728b461028fe.jpg";
        String url1 = "https://img.zcool.cn/community/01644a5a177ed0a8012051873fd06a.gif";
        String url2 = "http://n.sinaimg.cn/games/crawl/20160921/Pol--fxvyqwa3680622.gif";
        String url3 = "http://n.sinaimg.cn/games/crawl/20160921/j3Vi-fxvyzus2219268.gif";
        String url4 = "http://n.sinaimg.cn/games/crawl/20160921/-9ps-fxvyqwe0343025.gif";
        ImageGifLoader.display(this,url,iv, FrameSequenceDrawable.LOOP_INF);
        ImageGifLoader.display(this,url1,iv1, FrameSequenceDrawable.LOOP_INF);
        ImageGifLoader.display(this,url2,iv2, FrameSequenceDrawable.LOOP_INF);
        ImageGifLoader.display(this,url3,iv3, FrameSequenceDrawable.LOOP_INF);
        ImageGifLoader.display(this,url4,iv4, FrameSequenceDrawable.LOOP_INF);
    }
}
