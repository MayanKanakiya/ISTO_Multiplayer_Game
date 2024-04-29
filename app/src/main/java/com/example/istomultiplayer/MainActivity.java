package com.example.istomultiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView getUname;
    List<String> imageNames;
    Button startBtn;
    Button A1Btn;
    Button A2Btn;
    Button A3Btn;
    Button A4Btn;
    private boolean gameStarted = false;
    //    This below three lines of code for shuffling random 8 images(Front-4 and back-4) into 4 imageView
    private List<Integer> allImageResRandom;
    private List<Integer> selectedImageResRandom;
    private List<ImageView> lstImgRandom;
    int frontImageCount = 0;
    private int[] currentPosition = new int[4];
    private int[] nextPosition = new int[4];
    GridView[] ph1arr = new GridView[25];
    GridView[] ph2arr = new GridView[25];
    GridView[] ph3arr = new GridView[25];
    GridView[] ph4arr = new GridView[25];
    int numPlayers = 4;
    int currentPlayerIndexHouse = 0;

    @SuppressLint("CutPasteId")
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
        A1Btn = findViewById(R.id.A1Btn);
        A2Btn = findViewById(R.id.A2Btn);
        A3Btn = findViewById(R.id.A3Btn);
        A4Btn = findViewById(R.id.A4Btn);
        A1Btn.setEnabled(false);
        A2Btn.setEnabled(false);
        A3Btn.setEnabled(false);
        A4Btn.setEnabled(false);

        // Initialize currentPosition and nextPosition arrays to 0
        for (int i = 0; i < 4; i++) {
            currentPosition[i] = 0;
            nextPosition[i] = 0;
        }
//        This below code for arrays for player house(path) and currentPosition and nextPosition of player - start code here
//            Path define for Player house 1
        ph1arr = new GridView[]{
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
        ph2arr = new GridView[]{
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
        ph3arr = new GridView[]{
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
        ph4arr = new GridView[]{
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

        } catch (Exception e) {
            Log.d("MyError", e.toString());
        }

        // This below code for shuffle random images when click the start button - code start here
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameStarted = true;
                onRandomizeButtonClick();
                updateImageViews();
                A1Btn.setEnabled(true);
                A2Btn.setEnabled(true);
                A3Btn.setEnabled(true);
                A4Btn.setEnabled(true);
                startBtn.setEnabled(false);
//                This below code for change A1 to A4 button color and Username when particular chance of each house - code start here
                String[] players = {"Player 1", "Player 2", "Player 3", "Player 4"};

                Log.d("Player", "Current player: " + players[currentPlayerIndexHouse]);

                currentPlayerIndexHouse++;

                if (currentPlayerIndexHouse >= numPlayers) {
                    currentPlayerIndexHouse = 0;
                }
                getUname = findViewById(R.id.getUname);
                Intent intent = getIntent();
                if (currentPlayerIndexHouse == 1) {
                    A1Btn.setBackgroundColor(Color.parseColor("#D2C230"));
                    A2Btn.setBackgroundColor(Color.parseColor("#D2C230"));
                    A3Btn.setBackgroundColor(Color.parseColor("#D2C230"));
                    A4Btn.setBackgroundColor(Color.parseColor("#D2C230"));
                    String ReceivedPlayer1 = intent.getStringExtra("Player1");
                    getUname.setText(ReceivedPlayer1);
                } else if (currentPlayerIndexHouse == 2) {
                    A1Btn.setBackgroundColor(Color.parseColor("#4CAF50"));
                    A2Btn.setBackgroundColor(Color.parseColor("#4CAF50"));
                    A3Btn.setBackgroundColor(Color.parseColor("#4CAF50"));
                    A4Btn.setBackgroundColor(Color.parseColor("#4CAF50"));
                    String ReceivedPlayer2 = intent.getStringExtra("Player2");
                    getUname.setText(ReceivedPlayer2);

                } else if (currentPlayerIndexHouse == 3) {
                    A1Btn.setBackgroundColor(Color.parseColor("#3A90D5"));
                    A2Btn.setBackgroundColor(Color.parseColor("#3A90D5"));
                    A3Btn.setBackgroundColor(Color.parseColor("#3A90D5"));
                    A4Btn.setBackgroundColor(Color.parseColor("#3A90D5"));
                    String ReceivedPlayer3 = intent.getStringExtra("Player3");
                    getUname.setText(ReceivedPlayer3);

                } else {
                    A1Btn.setBackgroundColor(Color.parseColor("#E4635A"));
                    A2Btn.setBackgroundColor(Color.parseColor("#E4635A"));
                    A3Btn.setBackgroundColor(Color.parseColor("#E4635A"));
                    A4Btn.setBackgroundColor(Color.parseColor("#E4635A"));
                    String ReceivedPlayer4 = intent.getStringExtra("Player4");
                    getUname.setText(ReceivedPlayer4);
                }
                // This below code for change A1 to A4 button color and Username when particular chance of each house - code end here
            }
        });
        // This below code for shuffle random images when click the start button - code end here

//        This below code for move paws into one gridView to another - code start here
        A1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBtn.setEnabled(true);
                if (gameStarted) {
                    nextPosition[0] = nextPosition[0] + frontImageCount;
                    pawnMove(currentPlayerIndexHouse, 1, nextPosition[0], currentPosition[0]);
                } else {
                    showToast("Click start button for the start the game");
                }
                frontImageCount = 0;
            }
        });
        A2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBtn.setEnabled(true);
                if (gameStarted) {
//                    Write code here
                } else {
                    showToast("Click start button for the start the game");
                }
                frontImageCount = 0;
            }
        });
        A3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBtn.setEnabled(true);
                if (gameStarted) {
//                    Write code here
                } else {
                    showToast("Click start button for the start the game");
                }
                frontImageCount = 0;
            }
        });
        A4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startBtn.setEnabled(true);
                if (gameStarted) {
//                    Write code here
                } else {
                    showToast("Click start button for the start the game");
                }
                frontImageCount = 0;
            }
        });
//        This below code for move paws into one gridView to another - code end here
    }

    //This below method for moving paws in one gridView to another - code start here
    private void pawnMove(int currentPlayerIndexHouse, int pawIndex, int next_arr, int curr_arr) {
        if (currentPlayerIndexHouse == 1) {
            try {
                GridView sourceGridView = ph1arr[curr_arr];
                GridView destinationGridView = ph1arr[next_arr];
                ImageAdapter imageAdapter = new ImageAdapter(this);
                int numImages = imageAdapter.getCount();
                // Determine the number of columns based on the number of images
                int numColumns = numImages <= 4 ? 2 : 4;

                sourceGridView.setNumColumns(numColumns);

                if (numColumns == 2) {
                    sourceGridView.setHorizontalSpacing(80);
                    sourceGridView.setVerticalSpacing(80);
                    sourceGridView.setColumnWidth(100);
                }

                destinationGridView.setNumColumns(numColumns);

                if (numColumns == 2) {
                    destinationGridView.setHorizontalSpacing(80);
                    destinationGridView.setVerticalSpacing(80);
                    destinationGridView.setColumnWidth(100);
                }

                // Get the adapter of the source GridView
                ImageAdapter sourceAdapter = (ImageAdapter) sourceGridView.getAdapter();
                // Get the adapter of the destination GridView
                ImageAdapter destinationAdapter = (ImageAdapter) destinationGridView.getAdapter();

                // Initialize the destination adapter if it's null
                if (destinationAdapter == null) {
                    destinationAdapter = new ImageAdapter(this);
                    destinationGridView.setAdapter(destinationAdapter);
                }

                // Get the image name to move
                String imageName = "a" + pawIndex + "_h" + currentPlayerIndexHouse + "_p" + pawIndex;

                // Check if the source adapter contains the image name
                if (sourceAdapter != null && sourceAdapter.getImageNames().contains(imageName)) {
                    // Remove the image from the source adapter
                    sourceAdapter.removeImage(imageName);
                    // Add the image to the destination adapter
                    destinationAdapter.addImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));

                    // Notify the adapters of the data changes
                    sourceAdapter.notifyDataSetChanged();
                    destinationAdapter.notifyDataSetChanged();
                    currentPosition[pawIndex - 1] = next_arr;
                    frontImageCount = 0;
                } else {
                    Log.e("MovePawError", "Error moving paw: Image not found - " + imageName);
                }
            } catch (Exception e) {
                Log.e("MovePawError", "Error moving paw: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (currentPlayerIndexHouse == 2) {

        } else if (currentPlayerIndexHouse == 3) {

        } else if (currentPlayerIndexHouse == 0) { // currentPlayerIndexHouse 0 or 4 both are same

        }

        A1Btn.setEnabled(false);
        A2Btn.setEnabled(false);
        A3Btn.setEnabled(false);
        A4Btn.setEnabled(false);
    }

    //This below method for moving paws in one gridView to another - code end here
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

    // Helper method to display a Toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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