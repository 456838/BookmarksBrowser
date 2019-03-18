package com.salton123.floatplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;

import com.salton123.bookmarksbrowser.R;

import java.io.File;

/**
 * User: newSalton@outlook.com
 * Date: 2019/3/4 9:53
 * ModifyTime: 9:53
 * Description:
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class FloatPlayer extends FrameLayout implements TextureView.SurfaceTextureListener {
    private TextureView mVideoTexture;
    private MediaPlayer mMediaPlayer;
    private Surface mSurface;

    public FloatPlayer(Context context) {
        super(context, null);
    }

    public FloatPlayer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatPlayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewData();
    }

    private void initViewData() {
        View.inflate(getContext(), R.layout.view_float_player, this);
        mVideoTexture = findViewById(R.id.textureView);
        mVideoTexture.setOpaque(true);
        mVideoTexture.setSurfaceTextureListener(this);
    }


    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        System.out.println("onSurfaceTextureAvailable onSurfaceTextureAvailable");
        mSurface = new Surface(surfaceTexture);
        surfaceTexture.setDefaultBufferSize(720,1280);
        new PlayerVideo().start();//开启一个线程去播放视频

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        System.out.println("onSurfaceTextureSizeChanged onSurfaceTextureSizeChanged");
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        System.out.println("onSurfaceTextureDestroyed onSurfaceTextureDestroyed");
        surfaceTexture = null;
        mSurface = null;
        mMediaPlayer.stop();
        mMediaPlayer.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
//   System.out.println("onSurfaceTextureUpdated onSurfaceTextureUpdated");
    }

    private class PlayerVideo extends Thread {
        @Override
        public void run() {
            try {
                File file = new File(Environment.getExternalStorageDirectory() + "/test.mp4");
                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.setDataSource(file.getAbsolutePath());
                mMediaPlayer.setSurface(mSurface);
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mMediaPlayer.setOnPreparedListener(mp -> mMediaPlayer.start());
                mMediaPlayer.setOnCompletionListener(mp -> {
                    removeAllViews();
                });
                mMediaPlayer.prepare();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface PlayerController {
        public void play();
    }
}
