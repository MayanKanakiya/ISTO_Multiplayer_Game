package com.example.istomultiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.istomultiplayer.ImageAdapter;

public class MainActivity extends AppCompatActivity {
    TextView getUname;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            GridView gridView = findViewById(R.id.gridView23);
            gridView.setAdapter(new ImageAdapter(this));
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
        }catch (Exception e){
            Log.d("ReceviedUnameError",e.toString());
        }
        //This below code get set username - End here
    }
}