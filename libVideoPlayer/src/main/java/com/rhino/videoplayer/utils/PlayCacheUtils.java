package com.rhino.videoplayer.utils;

import android.content.Context;

/**
 * @author rhino
 * @since Create on 2018/12/8.
 **/
public class PlayCacheUtils {

    /**
     * 保存播放位置，以便下次播放时接着上次的位置继续播放.
     *
     * @param context context
     * @param url     视频链接url
     * @param position     position
     */
    public static void savePlayPosition(Context context, String url, long position) {
        context.getSharedPreferences("NICE_VIDEO_PALYER_PLAY_POSITION",
                Context.MODE_PRIVATE)
                .edit()
                .putLong(url, position)
                .apply();
    }

    /**
     * 取出上次保存的播放位置
     *
     * @param context context
     * @param url     视频链接url
     * @return 上次保存的播放位置
     */
    public static long getSavedPlayPosition(Context context, String url) {
        return context.getSharedPreferences("NICE_VIDEO_PALYER_PLAY_POSITION",
                Context.MODE_PRIVATE)
                .getLong(url, 0);
    }

}
