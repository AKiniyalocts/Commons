package com.akiniyalocts.commons.logging;

import android.util.Log;

/**
 * Created by AKiniyalocts on 4/6/15.
 */
public class aLog {

  private static boolean isLogging = false;

  public static void w(String TAG, String msg){
    if(TAG != null && msg != null && isLogging){
      Log.w(TAG, msg);
    }
  }

  public static void setLogging(boolean logging){
    isLogging = logging;
  }
}
