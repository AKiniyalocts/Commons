package com.akiniyalocts.commonstestapp;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.akiniyalocts.commons.activities.drawer.DrawerActivity;
import com.akiniyalocts.commons.activities.drawer.DrawerAdapter;
import com.akiniyalocts.commons.activities.drawer.DrawerItem;
import com.akiniyalocts.commons.activities.drawer.DrawerItemBuilder;

import butterknife.Bind;

public class MainActivity extends DrawerActivity implements DrawerAdapter.DrawerItemListener, DrawerAdapter.DrawerHeaderListener{

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.main_toolbar)
    Toolbar mToolbar;

    @Bind(R.id.wall_recycler)
    RecyclerView mRecycler;

    public DrawerAdapter mDrawerAdapter;

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

        initDrawer();
    }

    @Override
    public void onDrawerItemClicked(DrawerItem item) {
        Snackbar.make(mRecycler, item.getTitle(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDrawerHeaderClicked() {
        Snackbar.make(mRecycler, "Header Clicked", Snackbar.LENGTH_LONG).show();

    }

    private void initDrawer(){
        mDrawerAdapter = new DrawerAdapter(this);
        mDrawerAdapter.setDrawerItemListener(this);
        mDrawerAdapter.setDrawerHeaderListener(this);

        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        mDrawerAdapter.addItem(
                new DrawerItemBuilder("Test")
                        .setIsHeader(true)
                        .setHeaderImageDrawable("http://knokfirst.com/thumb/colorgasm1.png")
                        .setHeaderTitle("Awesome Title")
                        .createDrawerItem()
        );

        mDrawerAdapter.addItem(
                new DrawerItemBuilder("Timeline")
                        .setUnicode("\uF262")
                        .createDrawerItem()
        );
        mDrawerAdapter.addItem(
                new DrawerItemBuilder("Timeline")
                        .setUnicode("\uF33B")
                        .createDrawerItem()
        );
        mDrawerAdapter.addItem(
                new DrawerItemBuilder("Timeline")
                        .setUnicode("\uF214")
                        .createDrawerItem()
        );
        mDrawerAdapter.addItem(
                new DrawerItemBuilder("Timeline")
                        .setUnicode("\uF262")
                        .createDrawerItem()
        );
        mDrawerAdapter.addItem(
                new DrawerItemBuilder("")
                        .setIsSeparator(true)
                        .createDrawerItem()
        );
        mDrawerAdapter.addItem(
                new DrawerItemBuilder("About")
                        .createDrawerItem()
        );
        mDrawerAdapter.addItem(
                new DrawerItemBuilder("Settings")
                        .createDrawerItem()
        );


        mRecycler.setAdapter(mDrawerAdapter);
    }


}
