package com.example.istomultiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.example.istomultiplayer.ImageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            GridView gridView = findViewById(R.id.gridView0);
            gridView.setAdapter(new ImageAdapter(this));
        } catch (Exception e) {
            Log.d("MyError", e.toString());
        }
    }
}