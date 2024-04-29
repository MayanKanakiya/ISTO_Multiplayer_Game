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
        imageView.setImageResource(mImageResources.get(position));
        return imageView;
    }
    // Method to remove image by name from the list
    public void removeImage(String imageName) {
        int index = mImageNames.indexOf(imageName);
        if (index != -1) {
            mImageResources.remove(index);
            mImageNames.remove(index);
        }
    }

    // Method to add image resource to the list
    public void addImageResource(int imageResource) {
        mImageResources.add(imageResource);
        // Get the image name from the resource ID
        String imageName = mContext.getResources().getResourceEntryName(imageResource);
        addImageName(imageName);
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