package com.example.istomultiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
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
    int frontImageCount = 0;
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
//          First Yellow(ph1) gridView code for add images into it - code start here
            GridView gridView = findViewById(R.id.gridView23);
            ImageAdapter imageAdapter = new ImageAdapter(this);
            // Add 4 image resources
            imageAdapter.addImageResource(R.drawable.a1_h1_p1);
            imageAdapter.addImageResource(R.drawable.a2_h1_p2);
            imageAdapter.addImageResource(R.drawable.a3_h1_p3);
            imageAdapter.addImageResource(R.drawable.a4_h1_p4);
//            imageAdapter.addImageResource(R.drawable.a4_h2_p4);
            gridView.setAdapter(imageAdapter);
//           First Yellow(ph1) gridView code for add images into it - code end here

//           Second green(ph2) gridView code for add images into it - code start here
            GridView gridView1 = findViewById(R.id.gridView15);
            ImageAdapter imageAdapter1 = new ImageAdapter(this);
            // Add 4 image resources
            imageAdapter1.addImageResource(R.drawable.a1_h2_p1);
            imageAdapter1.addImageResource(R.drawable.a2_h2_p2);
            imageAdapter1.addImageResource(R.drawable.a3_h2_p3);
            imageAdapter1.addImageResource(R.drawable.a4_h2_p4);
//            imageAdapter1.addImageResource(R.drawable.a4_h3_p4);
            gridView1.setAdapter(imageAdapter1);
//           Second green(ph2) gridView code for dd images into it - code end here

//            Third Blue(ph3) gridView code for add images into it - code start here
            GridView gridView2 = findViewById(R.id.gridView2);
            ImageAdapter imageAdapter2 = new ImageAdapter(this);
            // Add 4 image resources
            imageAdapter2.addImageResource(R.drawable.a1_h3_p1);
            imageAdapter2.addImageResource(R.drawable.a2_h3_p2);
            imageAdapter2.addImageResource(R.drawable.a3_h3_p3);
            imageAdapter2.addImageResource(R.drawable.a4_h3_p4);
//            imageAdapter2.addImageResource(R.drawable.a4_h4_p4);
            gridView2.setAdapter(imageAdapter2);
//            Third Blue(ph3) gridView code for add images into it - code end here

//            Fourth Red(ph4) gridView code for add images into it - code start here
            GridView gridView3 = findViewById(R.id.gridView11);
            ImageAdapter imageAdapter3 = new ImageAdapter(this);
            // Add 4 image resources
            imageAdapter3.addImageResource(R.drawable.a1_h4_p1);
            imageAdapter3.addImageResource(R.drawable.a2_h4_p2);
            imageAdapter3.addImageResource(R.drawable.a3_h4_p3);
            imageAdapter3.addImageResource(R.drawable.a4_h4_p4);
//            imageAdapter3.addImageResource(R.drawable.a4_h1_p4);
            gridView3.setAdapter(imageAdapter3);
//            Fourth Red(ph4) gridView code for add images into it - code end here

//            This below code for add particular gridView columnWidth, Horizontal and vertical spacing, and numColumn dynamically and adjust 2 x 2 and 4 x 4 images dynamically - code start here
//      1. Yellow(ph1) gridView - code start here
            int numImages = imageAdapter.getCount();
            // Determine the number of columns based on the number of images
            int numColumns = numImages <= 4 ? 2 : 4;

            gridView.setNumColumns(numColumns);

            if (numColumns == 2) {
                gridView.setHorizontalSpacing(80);
                gridView.setVerticalSpacing(80);
                gridView.setColumnWidth(100);
            }
        //Yellow(ph1) gridView - code end here

//      2. Green(ph2) gridView - code start here

            int numImages1 = imageAdapter1.getCount();
            // Determine the number of columns based on the number of images
            int numColumns1 = numImages1 <= 4 ? 2 : 4;
            gridView1.setNumColumns(numColumns1);

            if (numColumns1 == 2) {
                gridView1.setHorizontalSpacing(80);
                gridView1.setVerticalSpacing(80);
                gridView1.setColumnWidth(100);
            }
        //Green(ph2) gridView - code end here
//      3. Blue(ph3) gridView  - code start here
            int numImages2 = imageAdapter3.getCount();
            // Determine the number of columns based on the number of images
            int numColumns2 = numImages2 <= 4 ? 2 : 4;
            gridView2.setNumColumns(numColumns2);

            if (numColumns2 == 2) {
                gridView2.setHorizontalSpacing(80);
                gridView2.setVerticalSpacing(80);
                gridView2.setColumnWidth(100);
            }
//      Blue(ph3) gridView  - code end  here

//      4. Red(ph4) gridView - code start here
            int numImages3 = imageAdapter3.getCount();
            // Determine the number of columns based on the number of images
            int numColumns3 = numImages3 <= 4 ? 2 : 4;
            gridView3.setNumColumns(numColumns3);

            if (numColumns3 == 2) {
                gridView3.setHorizontalSpacing(80);
                gridView3.setVerticalSpacing(80);
                gridView3.setColumnWidth(100);
            }
//      4Red(ph4) gridView - code end here

            // This below code for add particular gridView columnWidth, Horizontal and vertical spacing, and numColumn dynamically and adjust 2 x 2 and 4 x 4 images dynamically - code end here

            // After setting adapter, retrieve the image names - first Yellow(ph1) - code start here
            List<String> imageNamesInGridView = imageAdapter.getImageNames();
            for (String imageName : imageNamesInGridView) {
                Log.d("YellowPh1", imageName);
            }
            // After setting adapter, retrieve the image names - first Yellow(ph2) - code end here

            // After setting adapter, retrieve the image names - second green(ph2) - code start here
            List<String> imageNamesInGridView1 = imageAdapter1.getImageNames();
            for (String imageName : imageNamesInGridView1) {
                Log.d("GreenPh2", imageName);
            }
            // After setting adapter, retrieve the image names - second green(ph2) - code end here

            // After setting adapter, retrieve the image names - Third Blue(ph3) - code start here
            List<String> imageNamesInGridView2 = imageAdapter2.getImageNames();
            for (String imageName : imageNamesInGridView2) {
                Log.d("BluePh3", imageName);
            }
            // After setting adapter, retrieve the image names - Third Blue(ph3) - code end here

            // After setting adapter, retrieve the image names - Red(ph4) - code start here
            List<String> imageNamesInGridView3 = imageAdapter3.getImageNames();
            for (String imageName : imageNamesInGridView3) {
                Log.d("RedPh4", imageName);
            }
            // After setting adapter, retrieve the image names - Red(ph4) - code end here

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
                frontImageCount = 0;
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