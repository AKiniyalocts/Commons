package com.akiniyalocts.commons.activities.drawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akiniyalocts.commons.R;
import com.akiniyalocts.commons.widgets.MaterialIconTextView;

import java.util.List;

/**
 * Created by anthony on 9/15/15.
 */


public class DrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DrawerItem> mItems;

    private LayoutInflater mInflater;

    private Context context;

    public DrawerAdapter(List<DrawerItem> mItems, Context context) {
        this.mItems = mItems;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public DrawerAdapter(Context context){
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void addItem(int pos, DrawerItem item){
        mItems.add(pos, item);
        notifyItemInserted(pos);
    }

    public void addItem(DrawerItem item){
        mItems.add(item);
        notifyItemInserted(mItems.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class DrawerItemViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout mParent;
        MaterialIconTextView mIcon;
        TextView mTitle;

        public DrawerItemViewHolder(View itemView) {
            super(itemView);
            mParent = (RelativeLayout)itemView.findViewById(R.id.drawer_item_parent);
            mTitle = (TextView)itemView.findViewById(R.id.drawer_item_title);
            mIcon = (MaterialIconTextView)itemView.findViewById(R.id.drawer_item_icon);

        }
    }

    class DrawerHeaderViewHolder extends RecyclerView.ViewHolder{
        public DrawerHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
