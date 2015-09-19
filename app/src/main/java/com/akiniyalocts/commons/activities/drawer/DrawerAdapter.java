package com.akiniyalocts.commons.activities.drawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akiniyalocts.commons.R;
import com.akiniyalocts.commons.widgets.MaterialIconTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 9/15/15.
 */


public class DrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface DrawerItemListener{
        void onDrawerItemClicked(DrawerItem item, int position);
    }

    public interface DrawerHeaderListener{
        void onDrawerHeaderClicked();
    }

    private final static int VIEW_TYPE_HEADER = 001;

    private final static int VIEW_TYPE_ITEM = 002;

    private final static int VIEW_TYPE_SEPARATOR = 003;

    private List<DrawerItem> mItems;

    private DrawerItem selectedItem;

    private LayoutInflater mInflater;

    private Context context;

    private DrawerItemListener mItemListener;

    private DrawerHeaderListener mHeaderListener;

    public DrawerAdapter(List<DrawerItem> mItems, Context context) {
        this.mItems = mItems;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public DrawerAdapter(Context context){
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        mItems = new ArrayList<>();
    }

    public void setDrawerItemListener(DrawerItemListener drawerItemListener){
        mItemListener = drawerItemListener;
    }

    public void setDrawerHeaderListener(DrawerHeaderListener drawerHeaderListener){
        mHeaderListener = drawerHeaderListener;
    }

    public void addItem(int pos, DrawerItem item){
        if(item.isHeader()){
           addHeader(item);
        }
        else {
            mItems.add(pos, item);
            notifyItemInserted(pos);
        }
    }

    public void addItem(DrawerItem item){
        if(item.isHeader()){
            addHeader(item);
        }
        else {
            mItems.add(item);
            notifyItemInserted(mItems.size());
        }

    }

    public void addHeader(DrawerItem item){
        item.setIsHeader(true);
        mItems.add(0, item);
        notifyItemInserted(0);
    }

    public void addSeparator(String separatorTitle){
      mItems.add(
          new DrawerItemBuilder("")
            .setIsSeparator(true)
            .setSeparatorTitle(separatorTitle)
            .build()
      );

      notifyItemInserted(mItems.size());
    }

    public void addSeparator(){
      mItems.add(
          new DrawerItemBuilder("")
            .setIsSeparator(true)
            .build()
      );

      notifyItemInserted(mItems.size());
    }

    public void addUnselectableItem(String title){
      mItems.add(
          new DrawerItemBuilder(title)
            .setIsSelectable(false)
            .build()
      );

      notifyItemInserted(mItems.size());
    }


    public DrawerItem getSelectedItem(){

      if(selectedItem != null){
        return selectedItem;
      }
      else{
        return mItems.get(getFirstSelectableItem());
      }
    }

    private int getFirstSelectableItem(){

      for(int i = 0; i <= mItems.size(); i++){
        if(mItems.get(i).isSelectable())
          return i;
      }

      return getFirstSelectableItem();
    }

    public int getSelectedItemPosition(){

      if(getSelectedItem() != null)
        return mItems.indexOf(getSelectedItem());

      else
        return getFirstSelectableItem();
    }

    private void setSelectedItem(DrawerItem item){
      selectedItem = item;
    }

    public void setSelectedItem(int pos){

      getSelectedItem().setIsSelected(false);
      notifyItemChanged(getSelectedItemPosition());

      selectedItem = mItems.get(pos);
      selectedItem.setIsSelected(true);
      notifyItemChanged(pos);
    }

    private int getAccentColor() {
      TypedValue typedValue = new TypedValue();

      TypedArray a = context.obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorAccent });
      int color = a.getColor(0, 0);

      a.recycle();

      return color;
    }

    private int getPrimaryTextColor() {
      return context.getResources().getColor(R.color.primary_dark_material_dark);

    }



    @Override
    public int getItemViewType(int position) {

        if(mItems.get(position).isHeader()){
            return VIEW_TYPE_HEADER;
        }

        else if(mItems.get(position).isSeparator()){
            return VIEW_TYPE_SEPARATOR;
        }

        return VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        switch (viewType){

            case VIEW_TYPE_SEPARATOR:
                itemView = mInflater.inflate(R.layout.drawer_list_separator, parent, false);
                return new DrawerSeperatorViewHolder(itemView);

            case VIEW_TYPE_HEADER:
                itemView = mInflater.inflate(R.layout.drawer_list_header, parent, false);
                return new DrawerHeaderViewHolder(itemView);

            case VIEW_TYPE_ITEM:
                itemView = mInflater.inflate(R.layout.drawer_list_item, parent, false);
                return new DrawerItemViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        DrawerItem item = mItems.get(position);

        switch (getItemViewType(position)){

            case VIEW_TYPE_ITEM:
                DrawerItemViewHolder drawerItemViewHolder = ((DrawerItemViewHolder) holder);

                drawerItemViewHolder.mTitle.setText(item.getTitle());

                if(item.getItemCount() != -1){
                    drawerItemViewHolder.mCount.setVisibility(View.VISIBLE);
                    drawerItemViewHolder.mCount.setText("" + item.getItemCount());
                }
                else {
                    drawerItemViewHolder.mCount.setVisibility(View.INVISIBLE);
                }

                if (item.getUnicode() != null) {
                    drawerItemViewHolder.mIcon.setVisibility(View.VISIBLE);
                    drawerItemViewHolder.mIcon.setText(item.getUnicode());
                    drawerItemViewHolder.mTitle.setPadding(75, 0, 0, 0);
                }

                else{
                    drawerItemViewHolder.mTitle.setPadding(0, 0, 0, 0);
                    drawerItemViewHolder.mIcon.setVisibility(View.INVISIBLE);
                }


                // change bg and title/icon color
                if(item.isSelected()){

                  if(item.getUnicode() != null) {
                    drawerItemViewHolder.mIcon.setTextColor(getAccentColor());
                  }

                  drawerItemViewHolder.mTitle.setTextColor(getAccentColor());
                    drawerItemViewHolder.mCount.setTextColor(getAccentColor());

                  drawerItemViewHolder.mParent.setBackgroundColor(
                      context.getResources().getColor(R.color.selected));
                }

                // remove bg and icon text color
                else{

                  if(item.getUnicode() != null) {
                    drawerItemViewHolder.mIcon.setTextColor(getPrimaryTextColor());
                  }
                  drawerItemViewHolder.mTitle.setTextColor(getPrimaryTextColor());
                    drawerItemViewHolder.mCount.setTextColor(getPrimaryTextColor());

                  drawerItemViewHolder.mParent.setBackgroundColor(0);
                }

                drawerItemViewHolder = null;

                break;


            case VIEW_TYPE_HEADER:
                DrawerHeaderViewHolder drawerHeaderViewHolder = ((DrawerHeaderViewHolder) holder);

                if(item.hasUrlForHeader()){
                    Picasso.with(context).setLoggingEnabled(true);
                    Picasso.with(context)
                            .load(item.getHeaderImageUrl())
                            .fit()
                            .centerCrop()
                            .into(drawerHeaderViewHolder.mImage);
                }

                else {
                    Picasso.with(context)
                            .load(item.getHeaderDrawable())
                            .fit()
                            .centerCrop()
                            .into(drawerHeaderViewHolder.mImage);
                }

                if(item.getHeaderTitle() != null){
                    drawerHeaderViewHolder.mTitle.setText(item.getHeaderTitle());
                }

                drawerHeaderViewHolder = null;

                break;


            case VIEW_TYPE_SEPARATOR:
                DrawerSeperatorViewHolder drawerSeperatorViewHolder = ((DrawerSeperatorViewHolder) holder);

                if(item.getSeparatorTitle() != null){
                    drawerSeperatorViewHolder.mTitle.setText(item.getSeparatorTitle());
                }

              drawerHeaderViewHolder = null;

        }

      item = null;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class DrawerItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        RelativeLayout mParent;
        MaterialIconTextView mIcon;
        TextView mTitle;
        TextView mCount;

        public DrawerItemViewHolder(View itemView) {
            super(itemView);
            mParent = (RelativeLayout)itemView.findViewById(R.id.drawer_item_parent);
            mTitle = (TextView)itemView.findViewById(R.id.drawer_item_title);
            mCount = (TextView)itemView.findViewById(R.id.drawer_item_count);
            mIcon = (MaterialIconTextView)itemView.findViewById(R.id.drawer_item_icon);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mItemListener != null){
                mItemListener.onDrawerItemClicked(mItems.get(getAdapterPosition()), getAdapterPosition());

                setItemSelected();
            }
        }

        private void setItemSelected(){
          DrawerItem item = mItems.get(getAdapterPosition());

          // check if we can select it
          if(item.isSelectable()){

            // check if its not already selected
            if(!item.isSelected()){

              item.setIsSelected(true);

              notifyItemChanged(getAdapterPosition());

              getSelectedItem().setIsSelected(false);

              notifyItemChanged(mItems.indexOf(getSelectedItem()));

              setSelectedItem(item);

            }
          }
        }
    }

    class DrawerHeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        FrameLayout mParent;
        ImageView mImage;
        TextView mTitle;

        public DrawerHeaderViewHolder(View itemView) {
            super(itemView);
            mParent = (FrameLayout)itemView.findViewById(R.id.drawer_header_parent);
            mImage = (ImageView)itemView.findViewById(R.id.drawer_header_image);
            mTitle = (TextView)itemView.findViewById(R.id.drawer_header_title);

            mParent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mHeaderListener != null){
                mHeaderListener.onDrawerHeaderClicked();
            }
        }
    }

    class DrawerSeperatorViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle;

        public DrawerSeperatorViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView)itemView.findViewById(R.id.drawer_separator_title);
        }
    }
}
