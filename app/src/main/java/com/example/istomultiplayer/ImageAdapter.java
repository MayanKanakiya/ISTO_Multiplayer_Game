package com.example.istomultiplayer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mImageNames;

    public ImageAdapter(Context context) {
        mContext = context;
        mImageNames = new ArrayList<>();
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
//            imageView.setLayoutParams(new GridView.LayoutParams(40, 40));
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
                addImageName("a1_h1_p1");
                break;
            case 1:
                imageView.setImageResource(R.drawable.a2_h1_p2); // Yellow
                addImageName("a2_h1_p2");
                break;
            case 2:
                imageView.setImageResource(R.drawable.a3_h1_p3); // Yellow
                addImageName("a3_h1_p3");
                break;
            case 3:
                imageView.setImageResource(R.drawable.a4_h1_p4); // Yellow
                addImageName("a4_h1_p4");
                break;
//            case 4:
//                imageView.setImageResource(R.drawable.a1_h2_p1); // Green
//                addImageName("a1_h2_p1");
//                break;
//            case 5:
//                imageView.setImageResource(R.drawable.a2_h2_p2); // Green
//                addImageName("a2_h2_p2");
//                break;
//            case 6:
//                imageView.setImageResource(R.drawable.a3_h2_p3); // Green
//                addImageName("a3_h2_p3");
//                break;
//            case 7:
//                imageView.setImageResource(R.drawable.a4_h2_p4); // Green
//                addImageName("a4_h2_p4");
//                break;
//            case 8:
//                imageView.setImageResource(R.drawable.a1_h3_p1); // Blue
//                addImageName("a1_h3_p1");
//                break;
//            case 9:
//                imageView.setImageResource(R.drawable.a2_h3_p2); // Blue
//                addImageName("a2_h3_p2");
//                break;
//            case 10:
//                imageView.setImageResource(R.drawable.a3_h3_p3); // Blue
//                addImageName("a3_h3_p3");
//                break;
//            case 11:
//                imageView.setImageResource(R.drawable.a4_h3_p4); // Blue
//                addImageName("a4_h3_p4");
//                break;
//            case 12:
//                imageView.setImageResource(R.drawable.a1_h4_p1); // Red
//                addImageName("a1_h4_p1");
//                break;
//            case 13:
//                imageView.setImageResource(R.drawable.a2_h4_p2); // Red
//                addImageName("a2_h4_p2");
//                break;
//            case 14:
//                imageView.setImageResource(R.drawable.a3_h4_p3); // Red
//                addImageName("a3_h4_p3");
//                break;
//            case 15:
//                imageView.setImageResource(R.drawable.a4_h4_p4); // Red
//                addImageName("a4_h4_p4");
//                break;
        }
        return imageView;
    }
    // Method to add image name to the list
    private void addImageName(String imageName) {
        if (!mImageNames.contains(imageName)) {
            mImageNames.add(imageName);
        }
    }

    // Method to get the list of image names
    public List<String> getImageNames() {
        return mImageNames;
    }
}
