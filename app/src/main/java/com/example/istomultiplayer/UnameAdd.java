package com.example.istomultiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UnameAdd extends AppCompatActivity {

    EditText Player1EditText;
    EditText Player2EditText;
    EditText Player3EditText;
    EditText Player4EditText;
    Button startGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_uname_add);
        Player1EditText = findViewById(R.id.Player1EditText);
        Player2EditText = findViewById(R.id.Player2EditText);
        Player3EditText = findViewById(R.id.Player3EditText);
        Player4EditText = findViewById(R.id.Player4EditText);
        startGameBtn = findViewById(R.id.startGameBtn);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Player1EditText.getText().toString().equals("")){
                    Toast.makeText(UnameAdd.this, "Enter Player 1 Username.", Toast.LENGTH_SHORT).show();
                }else if(Player2EditText.getText().toString().equals("")){
                    Toast.makeText(UnameAdd.this, "Enter Player 2 Username.", Toast.LENGTH_SHORT).show();
                }else if(Player3EditText.getText().toString().equals("")){
                    Toast.makeText(UnameAdd.this, "Enter Player 3 Username.", Toast.LENGTH_SHORT).show();
                }else if(Player4EditText.getText().toString().equals("")){
                    Toast.makeText(UnameAdd.this, "Enter Player 4 Username.", Toast.LENGTH_SHORT).show();
                }else{
                    String TextSendPlayer1 = Player1EditText.getText().toString();
                    String TextSendPlayer2 = Player2EditText.getText().toString();
                    String TextSendPlayer3 = Player3EditText.getText().toString();
                    String TextSendPlayer4 = Player4EditText.getText().toString();
                    Intent intent = new Intent(UnameAdd.this, MainActivity.class);
                    intent.putExtra("Player1", TextSendPlayer1);
                    intent.putExtra("Player2", TextSendPlayer2);
                    intent.putExtra("Player3", TextSendPlayer3);
                    intent.putExtra("Player4", TextSendPlayer4);
                    startActivity(intent);
                }
            }
        });
    }
}