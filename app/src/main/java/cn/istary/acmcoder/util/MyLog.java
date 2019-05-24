package cn.istary.acmcoder.util;

import android.util.Log;

/**
 * DESCRIPTION:
 *
 * @author Sinry
 * @version 2019/5/9 11:49
 */

public class MyLog {

    private static final boolean DEBUG = true;

    private static final String TAG = "MyDebug";

    public static void d(String text){
        if(DEBUG){
            Log.d(TAG, text);
        }
    }
    public static void i(String text){
        if(DEBUG){
            Log.i(TAG, text);
        }
    }
    public static void w(String text){
        if(DEBUG){
            Log.w(TAG, text);
        }
    }
    public static void e(String text){
        if(DEBUG){
            Log.e(TAG, text);
        }
    }
}
