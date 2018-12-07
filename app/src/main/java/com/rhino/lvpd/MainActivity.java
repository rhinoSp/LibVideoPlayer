package com.rhino.lvpd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rhino.videoplayer.clarity.Clarity;
import com.rhino.videoplayer.view.VideoPlayerView;
import com.rhino.videoplayer.VideoPlayerManager;
import com.rhino.videoplayer.controller.TxVideoPlayerController;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements TxVideoPlayerController.OnShareClickListener{

    private VideoPlayerView mVideoPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoPlayerView = findViewById(R.id.NiceVideoPlayer);

        mVideoPlayerView.setPlayerType(VideoPlayerView.TYPE_IJK); // IjkPlayer or MediaPlayer
//        String videoUrl = "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108065&resourceType=video&editionType=default&source=aliyun";
//        mVideoPlayerView.setUp(videoUrl, null);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setShareClickListener(this);
        controller.setVisible(View.VISIBLE);//设置播放完成后，分享是否显示
        controller.setVisibleLength(true);//设置封面右下角时间是否显示  true  显示，false 不显示  默认是显示的
        controller.setTitle("Beautiful China...");
        controller.setLenght(117000);
        controller.setClarity(getClarityList(), 0);
//        Glide.with(this)
//                .load("http://img.kaiyanapp.com/1db100be73feffd81178b98fb124ed7d.jpeg?imageMogr2/quality/60/format/jpg")
//                .placeholder(R.drawable.videobag)
//                .crossFade()
//                .into(controller.imageView());
        mVideoPlayerView.setController(controller);

    }

    @Override
    public void onBackPressed() {
        if (VideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        VideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onShareClick() {
        Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
    }


    public List<Clarity> getClarityList() {
        List<Clarity> clarityList = new ArrayList<>();
        clarityList.add(new Clarity("标清","270dp","http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108016&resourceType=video&editionType=normal&source=qcloud"));
        clarityList.add(new Clarity("高清","4800dp","http://baobab.kaiyanapp.com/api/v1/playUrl?vid=108016&resourceType=video&editionType=high&source=aliyun"));
        return clarityList;
    }

}
