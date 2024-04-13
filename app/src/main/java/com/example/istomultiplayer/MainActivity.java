package com.example.istomultiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.istomultiplayer.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView getUname;
    List<String> imageNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            GridView gridView = findViewById(R.id.gridView23);
            ImageAdapter imageAdapter = new ImageAdapter(this);
            gridView.setAdapter(imageAdapter);

            // Wait for the GridView to finish setting up its child views
            gridView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    // Remove the listener to avoid multiple calls
                    gridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                    // Get the list of image names from the adapter
                    imageNames = imageAdapter.getImageNames();
                        for (String name : imageNames) {
                            Log.d("Image Name", name);
                    }
                }
            });
        } catch (Exception e) {
            Log.d("MyError", e.toString());
        }
        //This below code get set username - start here
        try {
            getUname = findViewById(R.id.getUname);
            Intent intent = getIntent();
            String ReceivedPlayer1 = intent.getStringExtra("Player1");
            Log.d("Player1", ReceivedPlayer1);
            getUname.setText(ReceivedPlayer1);
        } catch (Exception e) {
            Log.d("ReceviedUnameError", e.toString());
        }
        //This below code get set username - End here
    }
}