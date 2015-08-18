package com.akiniyalocts.commons.logging;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by AKiniyalocts on 4/6/15.
 */
public class aLog {

  private static boolean isLogging = false;

  public static void w(@NonNull String TAG, @NonNull String msg){
    if(isLogging){
      Log.w(TAG, msg);
    }
  }

  public static void setLogging(boolean logging){
    isLogging = logging;
  }
}
