package com.example.istomultiplayer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mImageResources;
    private List<String> mImageNames;

    public ImageAdapter(Context context) {
        mContext = context;
        mImageResources = new ArrayList<>();
        mImageNames = new ArrayList<>();
    }

    @Override
    public int getCount() {
        // Always return 4 for the 2x2 grid layout
        return mImageResources.size();
    }

    @Override
    public Object getItem(int position) {
        return mImageResources.get(position % mImageResources.size()); // Ensure circular indexing
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
        switch (position) {
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
            case 4:
                imageView.setImageResource(R.drawable.a4_h2_p4); // Yellow
                addImageName("a4_h2_p4");
                break;
        }
        return imageView;
    }

    // Method to add image resource to the list
    public void addImageResource(int imageResource) {
            mImageResources.add(imageResource);
            notifyDataSetChanged();
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