package com.salton123.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import com.salton123.base.BaseActivity;
import com.salton123.bean.LiveAssetCategoryList;
import com.salton123.bean.LiveChannelInfo;
import com.salton123.bean.LivePlayUrlM3u8;
import com.salton123.bean.VodInfo;
import com.salton123.bookmarksbrowser.R;
import com.salton123.view.ShowListWheelView;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * User: newSalton@outlook.com
 * Date: 2019/2/27 14:15
 * ModifyTime: 14:15
 * Description:
 */
public class VideoPlayActivity extends BaseActivity implements RequestUtil.HttpResponseCallback {
    private VideoView videoPlayer;
    private String liveAssetCategoryListUrl = "http://ott.liveapi.mgtv.com/v1/epg/turnplay/getLiveAssetCategoryList?mac_id=F4-60-E2-AE-B8-92&net_id=&device_id=71f110234939485693ecdef05cf7f2a93ddaaa6b&uuid=mgtvmacF460E2AEB892&license=ZgOOgo5MjkyOTAUOvw4OBkuqtA2qDbR8hyANqnY7e3a%2FBoc7vwW%2FS5UNqnt7lZWVIJmqjkyOTI5MZgOOgg%3D%3D&ticket=&buss_id=1000014&version=5.6.307.200.2.DBEI.0.0_Release&platform=3&type=3&mf=Xiaomi&mode=Redmi+6+Pro&_support=00100000011&media_asset_id=RollingBroadcast&pre=0";
    private String livePlayUrlM3u8 = "http://ott.liveapi.mgtv.com/v1/epg/turnplay/getLivePlayUrlM3u8?mac_id=F4-60-E2-AE-B8-92&net_id=&device_id=71f110234939485693ecdef05cf7f2a93ddaaa6b&uuid=mgtvmacF460E2AEB892&license=ZgOOgo5MjkyOTAUOvw4OBkuqtA2qDbR8hyANqnY7e3a%2FBoc7vwW%2FS5UNqnt7lZWVIJmqjkyOTI5MZgOOgg%3D%3D&ticket=&buss_id=1000014&version=5.6.307.200.2.DBEI.0.0_Release&platform=3&type=3&mf=Xiaomi&mode=Redmi+6+Pro&_support=00100000011&definition=2&after_day=1&channel_id=";
    String playUrl = "http://pcvideoyf.titan.mgtv.com/c1/internettv/2018/06/01_0/3C0E524CE4465F21D2B87A50B661B3F2_20180601_1_1_1054_ts/8335782949040B522AAC3E60DF1E849F.m3u8?arange=0&pm=bHPPxWH8IRTLwxd_ZiIuu7prj_NjA4dHlSgrz7RHgwdIoqQgfyxuTiUsts6~MCVXInYL79e~LLEtH_kXA_f0yvr96lwxGApMxREn_hjRv9to9bjS7g4llGTq04rLP5twypI~HtxKmAh2GR~yPIZyT3R545zbvDV2LVSGiA1wiYbgU_3jeEk7JzNbjHua3gJ_IgtsB_3PATrTXe1asvVMNVtX2Snx~zyuYRIenlx8gf7jfOOcdWerVE_g3If7T3J08Lpv17zHQ6MzjU2~sy~hl8x_brU2cYyiq5LZGioa3scS~tEkFNSG~1p3Gi8rBfhI7j7ovoaEULNFPcMpaUzYR6Pswhix2qB77dQM2DljJ8YcJZAarlOZSc4dYSk2xxQ_KEDWs4X69DtDWN_mMTgVmxx8WrDIIVKGF1momRk6vM1tNKKNeNv9B8ichT1r948EQl5tk4PwG7wNWT03Szj0OA--&mac_id=F4-60-E2-AE-B8-92&version=5.6.307.200.2.DBEI.0.0_Release&mf=Xiaomi&mod=&vcdn=0&scid=25022";

    private LivePlayUrlM3u8 mLivePlayUrlM3u8;
    private ShowListWheelView mShowListWheelView;
    private LinearLayout llRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_video_play);
        videoPlayer = findViewById(R.id.videoPlayer);
        videoPlayer.setVideoURI(Uri.parse("http://pcvideoyf.titan.mgtv.com/c1/internettv/2018/06/01_0/3C0E524CE4465F21D2B87A50B661B3F2_20180601_1_1_1054_ts/8335782949040B522AAC3E60DF1E849F.m3u8?arange=0&pm=bHPPxWH8IRTLwxd_ZiIuu7prj_NjA4dHlSgrz7RHgwdIoqQgfyxuTiUsts6~MCVXInYL79e~LLEtH_kXA_f0yvr96lwxGApMxREn_hjRv9to9bjS7g4llGTq04rLP5twypI~HtxKmAh2GR~yPIZyT3R545zbvDV2LVSGiA1wiYbgU_3jeEk7JzNbjHua3gJ_IgtsB_3PATrTXe1asvVMNVtX2Snx~zyuYRIenlx8gf7jfOOcdWerVE_g3If7T3J08Lpv17zHQ6MzjU2~sy~hl8x_brU2cYyiq5LZGioa3scS~tEkFNSG~1p3Gi8rBfhI7j7ovoaEULNFPcMpaUzYR6Pswhix2qB77dQM2DljJ8YcJZAarlOZSc4dYSk2xxQ_KEDWs4X69DtDWN_mMTgVmxx8WrDIIVKGF1momRk6vM1tNKKNeNv9B8ichT1r948EQl5tk4PwG7wNWT03Szj0OA--&mac_id=F4-60-E2-AE-B8-92&version=5.6.307.200.2.DBEI.0.0_Release&mf=Xiaomi&mod=&vcdn=0&scid=25022"));
        videoPlayer.start();
        videoPlayer.setOnPreparedListener(mp -> {
            System.out.println("prepare");
        });
        videoPlayer.setOnCompletionListener(mp ->
                Toast.makeText(getApplicationContext(), "播放完成了", Toast.LENGTH_SHORT).show());
        // videoPlayer.setUp(playUrl, "", Jzvd.SCREEN_WINDOW_FULLSCREEN);
        RequestUtil.get(liveAssetCategoryListUrl, LiveAssetCategoryList.class, this);
        mShowListWheelView = findViewById(R.id.showListWheelView);
        llRoot = findViewById(R.id.llRoot);
        llRoot.setOnClickListener(v -> {
            if (mShowListWheelView.getVisibility() == View.VISIBLE) {
                mShowListWheelView.setVisibility(View.GONE);
            } else {
                mShowListWheelView.setVisibility(View.VISIBLE);
            }
        });
        mShowListWheelView.setPlayListCallback(item -> {
            RequestUtil.get(livePlayUrlM3u8 + item.getId(), LivePlayUrlM3u8.class, this);
        });
    }

    @Override
    public void onSuccess(Object responseData) {
        if (responseData instanceof LiveAssetCategoryList) {
            mShowListWheelView.updateWheelView((LiveAssetCategoryList) responseData);
        } else if (responseData instanceof LiveChannelInfo) {

        } else if (responseData instanceof LivePlayUrlM3u8) {
            mLivePlayUrlM3u8 = (LivePlayUrlM3u8) responseData;
            // updatePlayer((LivePlayUrlM3u8) responseData);
            String text = mLivePlayUrlM3u8.getData().getPlay_list().get(0).getUrl();
            RequestUtil.get(text, VodInfo.class, this);
        } else if (responseData instanceof VodInfo) {
            VodInfo info = (VodInfo) responseData;
            String text = mLivePlayUrlM3u8.getData().getPlay_list().get(0).getText();
            // videoPlayer.setVideoURI(Uri.parse(info.getInfo()));
            // videoPlayer.start();
            // videoPlayer.setUp(info.getInfo(), text, Jzvd.SCREEN_WINDOW_FULLSCREEN);
        }
    }

    @Override
    public void onFailure(String failedReason) {

    }
}
