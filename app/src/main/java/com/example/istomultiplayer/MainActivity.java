package com.example.istomultiplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    private int[] currentPosition1 = new int[4];
    private int[] nextPosition1 = new int[4];

    private int[] currentPosition2 = new int[4];
    private int[] nextPosition2 = new int[4];

    private int[] currentPosition3 = new int[4];
    private int[] nextPosition3 = new int[4];

    private int[] currentPosition4 = new int[4];
    private int[] nextPosition4 = new int[4];


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

        // Initialize currentPosition1 and nextPosition1 arrays to 0
        for (int i = 0; i < 4; i++) {
            currentPosition1[i] = 0;
            nextPosition1[i] = 0;
        }
        for (int i = 0; i < 4; i++) {
            currentPosition2[i] = 0;
            nextPosition2[i] = 0;
        }
        for (int i = 0; i < 4; i++) {
            currentPosition3[i] = 0;
            nextPosition3[i] = 0;
        }
        for (int i = 0; i < 4; i++) {
            currentPosition4[i] = 0;
            nextPosition4[i] = 0;
        }
//        This below code for arrays for player house(path) and currentPosition1 and nextPosition1 of player - start code here
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

//        This below code for arrays for player house(path) and currentPosition1 and nextPosition1 of player - start end here

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
//           Second green(ph2) gridView code for add images into it - code end here

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
//            1. Yellow(ph1) gridView - code start here
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
//
            int numImages1 = imageAdapter1.getCount();
//            // Determine the number of columns based on the number of images
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

                } else if (currentPlayerIndexHouse == 0) {
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
                    if (currentPlayerIndexHouse == 1) {
                        nextPosition1[0] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 1, nextPosition1[0], currentPosition1[0]);
                    } else if (currentPlayerIndexHouse == 2) {
                        nextPosition2[0] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 1, nextPosition2[0], currentPosition2[0]);
                    } else if (currentPlayerIndexHouse == 3) {
                        nextPosition3[0] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 1, nextPosition3[0], currentPosition3[0]);
                    } else if (currentPlayerIndexHouse == 0) {
                        nextPosition4[0] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 1, nextPosition4[0], currentPosition4[0]);
                    }
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
                    if (currentPlayerIndexHouse == 1) {
                        nextPosition1[1] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 2, nextPosition1[1], currentPosition1[1]);
                    } else if (currentPlayerIndexHouse == 2) {
                        nextPosition2[1] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 2, nextPosition2[1], currentPosition2[1]);
                    } else if (currentPlayerIndexHouse == 3) {
                        nextPosition3[1] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 2, nextPosition3[1], currentPosition3[1]);
                    } else if (currentPlayerIndexHouse == 0) {
                        nextPosition4[1] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 2, nextPosition4[1], currentPosition4[1]);
                    }

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
                    if (currentPlayerIndexHouse == 1) {
                        nextPosition1[2] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 3, nextPosition1[2], currentPosition1[2]);
                    } else if (currentPlayerIndexHouse == 2) {
                        nextPosition2[2] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 3, nextPosition2[2], currentPosition2[2]);
                    } else if (currentPlayerIndexHouse == 3) {
                        nextPosition3[2] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 3, nextPosition3[2], currentPosition3[2]);
                    } else if (currentPlayerIndexHouse == 0) {
                        nextPosition4[2] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 3, nextPosition4[2], currentPosition4[2]);
                    }

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
                    if (currentPlayerIndexHouse == 1) {
                        nextPosition1[3] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 4, nextPosition1[3], currentPosition1[3]);
                    } else if (currentPlayerIndexHouse == 2) {
                        nextPosition2[3] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 4, nextPosition2[3], currentPosition2[3]);
                    } else if (currentPlayerIndexHouse == 3) {
                        nextPosition3[3] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 4, nextPosition3[3], currentPosition3[3]);
                    } else if (currentPlayerIndexHouse == 0) {
                        nextPosition4[3] += frontImageCount;
                        pawnMove(currentPlayerIndexHouse, 4, nextPosition4[3], currentPosition4[3]);
                    }
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
        try {
            GridView sourceGridView = null;
            GridView destinationGridView = null;
            if (currentPlayerIndexHouse == 1) {
                sourceGridView = ph1arr[curr_arr];
                destinationGridView = ph1arr[next_arr];
            } else if (currentPlayerIndexHouse == 2) {
                sourceGridView = ph2arr[curr_arr];
                destinationGridView = ph2arr[next_arr];
            } else if (currentPlayerIndexHouse == 3) {
                sourceGridView = ph3arr[curr_arr];
                destinationGridView = ph3arr[next_arr];
            } else if (currentPlayerIndexHouse == 0) {
                sourceGridView = ph4arr[curr_arr];
                destinationGridView = ph4arr[next_arr];
            }
            killPaw(currentPlayerIndexHouse, destinationGridView);
            // Get the adapter of the source GridView
            ImageAdapter sourceAdapter = (ImageAdapter) sourceGridView.getAdapter();
            // Get the adapter of the destination GridView
            ImageAdapter destinationAdapter = (ImageAdapter) destinationGridView.getAdapter();

            // Initialize the destination adapter if it's null
            if (destinationAdapter == null) {
                destinationAdapter = new ImageAdapter(this);
                destinationGridView.setAdapter(destinationAdapter);
            }

            // Get the number of images in the destination grid view
            int numImages = destinationAdapter.getCount();

            // Determine the number of columns based on the number of images
            int numColumns = numImages <= 4 ? 2 : 4;

            // Set the number of columns for source and destination grid views
            sourceGridView.setNumColumns(numColumns);
            destinationGridView.setNumColumns(numColumns);

            // Adjust spacing and column width for 4x4 structure
            if (numColumns == 4) {
                sourceGridView.setHorizontalSpacing(20);
                sourceGridView.setVerticalSpacing(20);
                sourceGridView.setColumnWidth(100);

                destinationGridView.setHorizontalSpacing(20);
                destinationGridView.setVerticalSpacing(20);
                destinationGridView.setColumnWidth(100);
            }

            // Get the image name to move
            int CPIH = 0;
            if (currentPlayerIndexHouse == 1) {
                CPIH = 1;
            } else if (currentPlayerIndexHouse == 2) {
                CPIH = 2;
            } else if (currentPlayerIndexHouse == 3) {
                CPIH = 3;
            } else if (currentPlayerIndexHouse == 0) {
                CPIH = 4;
            }
            String imageName = "a" + pawIndex + "_h" + CPIH + "_p" + pawIndex;

            // Check if the source adapter contains the image name
            if (sourceAdapter != null && sourceAdapter.getImageNames().contains(imageName)) {
                // Remove the image from the source adapter
                sourceAdapter.removeImage(imageName);
                // Add the image to the destination adapter
                destinationAdapter.addImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));

                // Notify the adapters of the data changes
                sourceAdapter.notifyDataSetChanged();
                destinationAdapter.notifyDataSetChanged();

                if (currentPlayerIndexHouse == 1) {
                    currentPosition1[pawIndex - 1] = next_arr;
                } else if (currentPlayerIndexHouse == 2) {
                    currentPosition2[pawIndex - 1] = next_arr;
                } else if (currentPlayerIndexHouse == 3) {
                    currentPosition3[pawIndex - 1] = next_arr;
                } else if (currentPlayerIndexHouse == 0) {
                    currentPosition4[pawIndex - 1] = next_arr;
                }

                A1Btn.setEnabled(false);
                A2Btn.setEnabled(false);
                A3Btn.setEnabled(false);
                A4Btn.setEnabled(false);

                // Update the GridView layouts
                updateGridViewLayout(sourceGridView);
                updateGridViewLayout(destinationGridView);
            } else {
                Log.e("MovePawError", "Error moving paw: Image not found - " + imageName);
            }
        } catch (Exception e) {
            Log.e("MovePawError", "Error moving paw: " + e.getMessage());
            e.printStackTrace();
        }
        frontImageCount = 0;
        checkForWin();
    }

    private void checkForWin() {
        GridView gridView13 = findViewById(R.id.gridView13);
        ImageAdapter adapter = (ImageAdapter) gridView13.getAdapter();

        if (adapter == null || adapter.getImageNames().size() < 4) {
            return;
        }

        // Check if gridView13 contains four specific pawns for any house
        boolean hasAllPawnsHouse1 = adapter.getImageNames().contains("a1_h1_p1") &&
                adapter.getImageNames().contains("a2_h1_p2") &&
                adapter.getImageNames().contains("a3_h1_p3") &&
                adapter.getImageNames().contains("a4_h1_p4");

        boolean hasAllPawnsHouse2 = adapter.getImageNames().contains("a1_h2_p1") &&
                adapter.getImageNames().contains("a2_h2_p2") &&
                adapter.getImageNames().contains("a3_h2_p3") &&
                adapter.getImageNames().contains("a4_h2_p4");

        boolean hasAllPawnsHouse3 = adapter.getImageNames().contains("a1_h3_p1") &&
                adapter.getImageNames().contains("a2_h3_p2") &&
                adapter.getImageNames().contains("a3_h3_p3") &&
                adapter.getImageNames().contains("a4_h3_p4");

        boolean hasAllPawnsHouse4 = adapter.getImageNames().contains("a1_h4_p1") &&
                adapter.getImageNames().contains("a2_h4_p2") &&
                adapter.getImageNames().contains("a3_h4_p3") &&
                adapter.getImageNames().contains("a4_h4_p4");

        Intent intent = getIntent();
        if (hasAllPawnsHouse1) {
            String receivedPlayer1 = intent.getStringExtra("Player1");
            showAlertDialog(receivedPlayer1);
        } else if (hasAllPawnsHouse2) {
            String receivedPlayer2 = intent.getStringExtra("Player2");
            showAlertDialog(receivedPlayer2);
        } else if (hasAllPawnsHouse3) {
            String receivedPlayer3 = intent.getStringExtra("Player3");
            showAlertDialog(receivedPlayer3);
        } else if (hasAllPawnsHouse4) {
            String receivedPlayer4 = intent.getStringExtra("Player4");
            showAlertDialog(receivedPlayer4);
        }
    }

    // Method to show the alert dialog indicating the winner
    private void showAlertDialog(String uname) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over");
        builder.setMessage("Congratulations, " + uname + " won the game!!");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(MainActivity.this, UnameAdd.class);
                startActivity(intent);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    // Helper method to update GridView layout
    private void updateGridViewLayout(GridView gridView) {
        // Get the number of images in the grid view
        int numImages = gridView.getAdapter().getCount();
        // Determine the number of columns based on the number of images
        int numColumns = numImages <= 4 ? 2 : 4;
        // Set the number of columns for the grid view
        gridView.setNumColumns(numColumns);
        // Adjust spacing and column width for 4x4 structure
        if (numColumns == 4) {
            gridView.setHorizontalSpacing(20);
            gridView.setVerticalSpacing(20);
            gridView.setColumnWidth(100);
        }
        if (numColumns == 2) {
            gridView.setHorizontalSpacing(80);
            gridView.setVerticalSpacing(80);
            gridView.setColumnWidth(100);
        }
    }

    // Method to remove the first pawn from another house in the given grid view
    private void killPaw(int currentPlayerIndexHouse, GridView currentGridView) {
        try {
            // Get the adapter of the current GridView
            ImageAdapter currentAdapter = (ImageAdapter) currentGridView.getAdapter();

            // Iterate through the items in the current GridView to find the first pawn belonging to another house
            for (int i = 0; i < currentAdapter.getCount(); i++) {
                String pawnName = currentAdapter.getImageNames().get(i);

                // Check if the pawn belongs to another house
                if (!pawnName.contains("_h" + (currentPlayerIndexHouse == 0 ? 4 : currentPlayerIndexHouse) + "_")) {
                    // Remove the pawn from the current adapter
                    currentAdapter.removeImage(pawnName);

                    // Determine which house the pawn belongs to
                    int houseIndex = Integer.parseInt(pawnName.split("_h")[1].split("_")[0]);

                    // Get the home GridView for this house
                    GridView homeGridView = null;
                    if (houseIndex == 1) {
                        homeGridView = ph1arr[0];
                        resetPawnPosition(currentPosition1, nextPosition1, pawnName);
                    } else if (houseIndex == 2) {
                        homeGridView = ph2arr[0];
                        resetPawnPosition(currentPosition2, nextPosition2, pawnName);
                    } else if (houseIndex == 3) {
                        homeGridView = ph3arr[0];
                        resetPawnPosition(currentPosition3, nextPosition3, pawnName);
                    } else if (houseIndex == 4) {
                        homeGridView = ph4arr[0];
                        resetPawnPosition(currentPosition4, nextPosition4, pawnName);
                    }

                    ImageAdapter homeAdapter = (ImageAdapter) homeGridView.getAdapter();

                    // Initialize the home adapter if it's null
                    if (homeAdapter == null) {
                        homeAdapter = new ImageAdapter(this);
                        homeGridView.setAdapter(homeAdapter);
                    }

                    // Add the pawn to the home adapter
                    homeAdapter.addImageResource(getResources().getIdentifier(pawnName, "drawable", getPackageName()));

                    // Notify the adapters of the data changes
                    homeAdapter.notifyDataSetChanged();
                    break; // Exit after removing the first pawn belonging to another house
                }
            }

            // Notify the current adapter of the data changes
            currentAdapter.notifyDataSetChanged();

            // Update the layout of the current GridView
            updateGridViewLayout(currentGridView);
        } catch (Exception e) {
            Log.e("KillPawError", "Error in killPaw: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method to reset the position of the pawn
    private void resetPawnPosition(int[] currentPosition, int[] nextPosition, String pawnName) {
        int pawIndex = Integer.parseInt(pawnName.split("_p")[1]) - 1;
        currentPosition[pawIndex] = 0; // Resetting the current position to home (index 0)
        nextPosition[pawIndex] = 0; // Resetting the next position to home (index 0)
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
        // Update nextPosition1 based on random moves generated
        for (int imageRes : selectedImageResRandom) {
            if (isFront(imageRes)) {
                frontImageCount++;
            }
        }
    }
}