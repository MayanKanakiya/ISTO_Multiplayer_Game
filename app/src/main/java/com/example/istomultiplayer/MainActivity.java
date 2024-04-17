package com.example.istomultiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView getUname;
    List<String> imageNames;
    Button startBtn;
    //    This below three lines of code for shuffling random 8 images(Front-4 and back-4) into 4 imageView
    private List<Integer> allImageResRandom;
    private List<Integer> selectedImageResRandom;
    private List<ImageView> lstImgRandom;
    int frontImageCount=0;
    private int[] currentPosition = new int[4];
    private int[] nextPosition = new int[4];
    GridView[] ph1arr = new GridView[24];
    GridView[] ph2arr = new GridView[24];
    GridView[] ph3arr = new GridView[24];
    GridView[] ph4arr = new GridView[24];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Random image shuffling
        allImageResRandom = new ArrayList<>();
        allImageResRandom.add(R.drawable.back1);
        allImageResRandom.add(R.drawable.back2);
        allImageResRandom.add(R.drawable.back3);
        allImageResRandom.add(R.drawable.back4);
        allImageResRandom.add(R.drawable.front1);
        allImageResRandom.add(R.drawable.front2);
        allImageResRandom.add(R.drawable.front3);
        allImageResRandom.add(R.drawable.front4);

        selectedImageResRandom = new ArrayList<>();
        lstImgRandom = new ArrayList<>();
        lstImgRandom.add(findViewById(R.id.imageView1));
        lstImgRandom.add(findViewById(R.id.imageView2));
        lstImgRandom.add(findViewById(R.id.imageView3));
        lstImgRandom.add(findViewById(R.id.imageView4));

        startBtn = findViewById(R.id.startBtn);

        // Initialize currentPosition and nextPosition arrays to 0
        for (int i = 0; i < 4; i++) {
            currentPosition[i] = 0;
            nextPosition[i] = 0;
        }
//        This below code for arrays for player house(path) and currentPosition and nextPosition of player - start code here
//            Path define for Player house 1
        @SuppressLint("CutPasteId") GridView[] ph1arr = {
                findViewById(R.id.gridView24),
                findViewById(R.id.gridView25),
                findViewById(R.id.gridView20),
                findViewById(R.id.gridView15),
                findViewById(R.id.gridView10),
                findViewById(R.id.gridView4),
                findViewById(R.id.gridView3),
                findViewById(R.id.gridView2),
                findViewById(R.id.gridView1),
                findViewById(R.id.gridView0),
                findViewById(R.id.gridView5),
                findViewById(R.id.gridView11),
                findViewById(R.id.gridView16),
                findViewById(R.id.gridView21),
                findViewById(R.id.gridView22),
                findViewById(R.id.gridView17),
                findViewById(R.id.gridView12),
                findViewById(R.id.gridView6),
                findViewById(R.id.gridView7),
                findViewById(R.id.gridView8),
                findViewById(R.id.gridView14),
                findViewById(R.id.gridView19),
                findViewById(R.id.gridView18),
                findViewById(R.id.gridView13)
            };
        //            Path define for Player house 2
        @SuppressLint("CutPasteId") GridView[] ph2arr = {
                findViewById(R.id.gridView10),
                findViewById(R.id.gridView4),
                findViewById(R.id.gridView3),
                findViewById(R.id.gridView2),
                findViewById(R.id.gridView1),
                findViewById(R.id.gridView0),
                findViewById(R.id.gridView5),
                findViewById(R.id.gridView11),
                findViewById(R.id.gridView16),
                findViewById(R.id.gridView21),
                findViewById(R.id.gridView22),
                findViewById(R.id.gridView23),
                findViewById(R.id.gridView24),
                findViewById(R.id.gridView25),
                findViewById(R.id.gridView20),
                findViewById(R.id.gridView19),
                findViewById(R.id.gridView18),
                findViewById(R.id.gridView17),
                findViewById(R.id.gridView12),
                findViewById(R.id.gridView6),
                findViewById(R.id.gridView7),
                findViewById(R.id.gridView8),
                findViewById(R.id.gridView14),
                findViewById(R.id.gridView13)
        };
        //            Path define for Player house 3
        @SuppressLint("CutPasteId") GridView[] ph3arr = {
                findViewById(R.id.gridView1),
                findViewById(R.id.gridView0),
                findViewById(R.id.gridView5),
                findViewById(R.id.gridView11),
                findViewById(R.id.gridView16),
                findViewById(R.id.gridView21),
                findViewById(R.id.gridView22),
                findViewById(R.id.gridView23),
                findViewById(R.id.gridView24),
                findViewById(R.id.gridView25),
                findViewById(R.id.gridView20),
                findViewById(R.id.gridView15),
                findViewById(R.id.gridView10),
                findViewById(R.id.gridView4),
                findViewById(R.id.gridView3),
                findViewById(R.id.gridView8),
                findViewById(R.id.gridView14),
                findViewById(R.id.gridView19),
                findViewById(R.id.gridView18),
                findViewById(R.id.gridView17),
                findViewById(R.id.gridView12),
                findViewById(R.id.gridView6),
                findViewById(R.id.gridView7),
                findViewById(R.id.gridView13)
        };
        //            Path define for Player house 4
        @SuppressLint("CutPasteId") GridView[] ph4arr = {
                findViewById(R.id.gridView16),
                findViewById(R.id.gridView21),
                findViewById(R.id.gridView22),
                findViewById(R.id.gridView23),
                findViewById(R.id.gridView24),
                findViewById(R.id.gridView25),
                findViewById(R.id.gridView20),
                findViewById(R.id.gridView15),
                findViewById(R.id.gridView10),
                findViewById(R.id.gridView4),
                findViewById(R.id.gridView3),
                findViewById(R.id.gridView2),
                findViewById(R.id.gridView1),
                findViewById(R.id.gridView0),
                findViewById(R.id.gridView5),
                findViewById(R.id.gridView6),
                findViewById(R.id.gridView7),
                findViewById(R.id.gridView8),
                findViewById(R.id.gridView14),
                findViewById(R.id.gridView19),
                findViewById(R.id.gridView18),
                findViewById(R.id.gridView17),
                findViewById(R.id.gridView12),
                findViewById(R.id.gridView13)
        };

//        This below code for arrays for player house(path) and currentPosition and nextPosition of player - start end here

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

        // This below code for shuffle random images when click the start button - code start here
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRandomizeButtonClick();
                updateImageViews();
                frontImageCount=0;
            }
        });
        // This below code for shuffle random images when click the start button - code end here
    }
    private void updateImageViews() {
        for (int i = 0; i < selectedImageResRandom.size() && i < lstImgRandom.size(); i++) {
            lstImgRandom.get(i).setImageResource(selectedImageResRandom.get(i));
        }
    }
    // Check if the image resource represents a front image
    private boolean isFront(int imageRes) {
        return imageRes == R.drawable.front1 || imageRes == R.drawable.front2 ||
                imageRes == R.drawable.front3 || imageRes == R.drawable.front4;
    }

    public void onRandomizeButtonClick() {
        Collections.shuffle(allImageResRandom);
        selectedImageResRandom.clear();
        selectedImageResRandom.addAll(allImageResRandom.subList(0, 4));

        // Update nextPosition based on random moves generated
        for (int imageRes : selectedImageResRandom) {
            if (isFront(imageRes)) {
                frontImageCount++;
            }
        }
    }
}