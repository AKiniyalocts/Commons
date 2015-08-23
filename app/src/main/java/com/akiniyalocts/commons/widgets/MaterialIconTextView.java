package com.akiniyalocts.commons.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.akiniyalocts.commons.TypefaceHelper;

/**
 * Created by anthony on 8/23/15.
 */
public class MaterialIconTextView extends TextView {

    public MaterialIconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MaterialIconTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            Typeface myTypeface =
                    TypefaceHelper.get(getContext(), "material_design_icon_font");
            setTypeface(myTypeface);
        }
    }
}
