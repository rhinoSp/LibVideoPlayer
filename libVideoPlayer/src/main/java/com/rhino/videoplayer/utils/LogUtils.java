package com.rhino.videoplayer.utils;

import android.util.Log;

/**
 * @author rhino
 * @since Create on 2018/12/08.
 **/
public class LogUtils {

    private static final String TAG = "NiceVideoPlayer";

    public static void d(String message) {
        Log.d(TAG, message);
    }

    public static void i(String message) {
        Log.i(TAG, message);
    }

    public static void e(String message, Throwable throwable) {
        Log.e(TAG, message, throwable);
    }

}
