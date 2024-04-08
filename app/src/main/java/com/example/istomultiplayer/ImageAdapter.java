package com.example.istomultiplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 16; // Number of images
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // If it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(40, 40));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(0, 1, 0, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        // Set your image resource here
        // For example:
        switch (position % 16) {
            case 0:
                imageView.setImageResource(R.drawable.a1_h1_p1); // Yellow
                break;
            case 1:
                imageView.setImageResource(R.drawable.a2_h1_p2); // Yellow
                break;
            case 2:
                imageView.setImageResource(R.drawable.a3_h1_p3); // Yellow
                break;
            case 3:
                imageView.setImageResource(R.drawable.a4_h1_p4); // Yellow
                break;
            case 4:
                imageView.setImageResource(R.drawable.a1_h2_p1); // Green
                break;
            case 5:
                imageView.setImageResource(R.drawable.a2_h2_p2); // Green
                break;
            case 6:
                imageView.setImageResource(R.drawable.a3_h2_p3); // Green
                break;
            case 7:
                imageView.setImageResource(R.drawable.a4_h2_p4); // Green
                break;
            case 8:
                imageView.setImageResource(R.drawable.a1_h3_p1); // Blue
                break;
            case 9:
                imageView.setImageResource(R.drawable.a2_h3_p2); // Blue
                break;
            case 10:
                imageView.setImageResource(R.drawable.a3_h3_p3); // Blue
                break;
            case 11:
                imageView.setImageResource(R.drawable.a4_h3_p4); // Blue
                break;
            case 12:
                imageView.setImageResource(R.drawable.a1_h4_p1); // Blue
                break;
            case 13:
                imageView.setImageResource(R.drawable.a2_h4_p2); // Blue
                break;
            case 14:
                imageView.setImageResource(R.drawable.a3_h4_p3); // Blue
                break;
            case 15:
                imageView.setImageResource(R.drawable.a4_h4_p4); // Blue
                break;
        }

        return imageView;
    }
}
