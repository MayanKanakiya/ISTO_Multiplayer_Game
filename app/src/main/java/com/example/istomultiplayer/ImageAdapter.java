package com.example.istomultiplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

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
        return mImageResources.size();
    }

    @Override
    public Object getItem(int position) {
        return mImageResources.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(40, 40));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(0, 1, 0, 1);
        } else {
            imageView = (ImageView) convertView;
        }

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
    } // Method to remove image by name from the list

    // Method to add image resource to the list
    public void addImageResource(int imageResource) {
        mImageResources.add(imageResource);
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