package com.easefun.polyv.cloudclassdemo;

import android.support.multidex.MultiDexApplication;

import com.easefun.polyv.businesssdk.vodplayer.PolyvVodSDKClient;
import com.easefun.polyv.cloudclass.config.PolyvLiveSDKClient;
import com.easefun.polyv.foundationsdk.log.PolyvCommonLog;

/**
 * @author df
 * @create 2018/8/7
 * @Describe
 */
public class PolyvCloudClassApp extends MultiDexApplication {
    private static final String TAG = "PolyvCloudClassApp";
//加密秘钥和加密向量，在点播后台->设置->API接口中获取，用于解密SDK加密串
    //值修改请参考https://github.com/easefun/polyv-android-sdk-demo/wiki/10.%E5%85%B3%E4%BA%8E-SDK%E5%8A%A0%E5%AF%86%E4%B8%B2-%E4%B8%8E-%E7%94%A8%E6%88%B7%E9%85%8D%E7%BD%AE%E4%BF%A1%E6%81%AF%E5%8A%A0%E5%AF%86%E4%BC%A0%E8%BE%93
    /** 加密秘钥 */
    private String aeskey = "RhyKMPfRMr6W5c79";
    /** 加密向量 */
    private String iv = "Ov66378thHPEdKVT";
    /** SDK加密串，可以在点播后台获取 */
    private String config = "uUPiEFa3WKfASl9dTqP6RIKdyqWQ/1oC7HpMu0+O4yn9WzfL/gUCFFei2PuGKZex8Ifn86s6DWnGFqbI9w4DPVp+/znYFrkRU1uATtCIr1cOm8xkby22kNjCIJXd/FvRNIHOk35UvNWvAhpgK/lbnQ==";

    @Override
    public void onCreate() {
        super.onCreate();
        // Normal app init code...
        PolyvCommonLog.setDebug(true);
        PolyvLiveSDKClient liveSDKClient = PolyvLiveSDKClient.getInstance();
        liveSDKClient.initContext(this);
        //0.16.0 起默认开启 HttpDns
//        liveSDKClient.enableHttpDns(true);
        //如果需要支持 IPV6，请开启enableIPV6=true。默认为false。开启后自动关闭 HttpDns
//        liveSDKClient.enableIPV6(false);

        PolyvVodSDKClient client = PolyvVodSDKClient.getInstance();
        //使用SDK加密串来配置
        client.setConfig(config, aeskey, iv);
    }
}
