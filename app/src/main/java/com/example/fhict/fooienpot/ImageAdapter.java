package com.example.fhict.fooienpot;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by fhict on 15/11/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] mThumbIds = {
            R.drawable.restaurant1, R.drawable.restaurant2,
            R.drawable.restaurant3, R.drawable.restaurant4,
            R.drawable.restaurant5, R.drawable.restaurant6,
            R.drawable.restaurant7, R.drawable.restaurant8,
            R.drawable.restaurant9, R.drawable.restaurant10,
            R.drawable.restaurant11, R.drawable.restaurant12,
            R.drawable.restaurant13, R.drawable.restaurant14,
            R.drawable.restaurant15, R.drawable.restaurant16,
            R.drawable.restaurant17, R.drawable.restaurant18,
            R.drawable.restaurant19, R.drawable.restaurant20,
            R.drawable.restaurant21, R.drawable.restaurant22,
            R.drawable.restaurant23, R.drawable.restaurant24
    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        //return 0;
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

}
