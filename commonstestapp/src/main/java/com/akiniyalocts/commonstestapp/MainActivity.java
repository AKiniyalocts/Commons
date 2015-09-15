package com.akiniyalocts.commonstestapp;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.akiniyalocts.commons.activities.DrawerActivity;

import butterknife.Bind;

public class MainActivity extends DrawerActivity {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.main_toolbar)
    Toolbar mToolbar;

    @Override
    public DrawerLayout getDrawerLayout() {
        return mDrawerLayout;
    }

    @Override
    public Toolbar getToolBar() {
        return mToolbar;
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
