package com.akiniyalocts.commons.activities.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by AKiniyalocts on 8/11/15.
 */
public abstract class ButterKnifeFragment extends Fragment {

  /**
   *
   * @return layout resource file for fragment
   */
  public abstract int getContentView();

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(getContentView(), container, false);
    ButterKnife.bind(this, view);
    return view;
  }
}
