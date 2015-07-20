package org.androidtown.brian.yesorno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by brian on 15. 7. 19..
 */

//http://stackoverflow.com/questions/11029192/inflating-a-xml-layout-in-a-custom-view-class

public class CustomLayoutinflater extends View {

    View view;

    public CustomLayoutinflater(Context context, View view, int layoutId) {
        super(context);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(layoutId, (ViewGroup) view, true);
    }

}
