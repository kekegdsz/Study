package com.kekegdsz.bluecollar;

import android.app.Application;

public class MainApplication extends Application {

    private static final String TAG = "MainApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        initStoreSdk();
    }

    private void initStoreSdk() {
//        String pid = "mm_25717530_2251950174_111232300350"; // 淘宝联盟pid
//        String adzoneid = "111232300350"; // pid最后一段
//        String unionId = ""; // 联盟id（一般传""）
//        String appKey = "32526153"; // 淘宝联盟appKey
//        boolean isRebate = false; // 是否带返利，返利功能需要部署自己的服务器
//        StoreSdk.init(this, pid, adzoneid, unionId, appKey, isRebate);// 初始化sdk
    }
}
