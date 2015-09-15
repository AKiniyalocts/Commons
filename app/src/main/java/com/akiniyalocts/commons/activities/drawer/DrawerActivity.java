package com.akiniyalocts.commons.activities.drawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;

import com.akiniyalocts.commons.R;
import com.akiniyalocts.commons.activities.ToolbarActivity;

/**
 * Created by anthony on 9/15/15.
 */
public abstract class DrawerActivity extends ToolbarActivity {

    public abstract DrawerLayout getDrawerLayout();

    protected ActionBarDrawerToggle mDrawerToggle;

    protected DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDrawer();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void initDrawer(){

        setupHomeSupportActionBar(getString(R.string.app_name));

        mDrawerLayout = getDrawerLayout();

        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, R.string.app_name, R.string.app_name
        );

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    protected void closeDrawer(){
        if(getDrawerLayout() != null){
            getDrawerLayout().closeDrawers();
        }
    }

    protected void openDrawer(){
        if(getDrawerLayout() != null){
            getDrawerLayout().openDrawer(Gravity.LEFT);
        }
    }


}
