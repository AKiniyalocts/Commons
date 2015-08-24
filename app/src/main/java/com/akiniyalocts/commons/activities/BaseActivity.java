package com.akiniyalocts.commons.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by anthony on 7/18/15.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Quicker way to start a new activity.
     *
     * @param context parent context
     * @param clazz activity to start
     * @param finishCurrent clears your current activity stack. Useful for authentication UI's
     */
    public static void start(Context context, Class clazz, boolean finishCurrent){
        Intent start  = new Intent(context, clazz);

        if(finishCurrent)
            start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        else
            start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        context.startActivity(start);
    }

    protected void safeSetSupportActionBarTitle(@NonNull int resId){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(resId);
        }
    }

    public void setToolbarAsActionbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
    }

}
