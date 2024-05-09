package com.example.highorlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    int numberOfTimesTried = 0;
    boolean hasWon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;//20 is the max and 1 is the min
    }

    public void onClickingBtn(View view){
        EditText editTextNumberSigned = findViewById(R.id.editTextNumberSigned);
        //Let's convert the user input from string to integer
        int userGuess = Integer.parseInt(editTextNumberSigned.getText().toString());


        if(numberOfTimesTried <= 4) { // Allow upto 5 tries
            numberOfTimesTried++;
                if(userGuess == randomNumber) {
                    hasWon = true;
                    Toast.makeText(MainActivity.this,"Congratulations! You have won!!!", Toast.LENGTH_LONG).show();
                }else if(userGuess > randomNumber) {
                    Toast.makeText(MainActivity.this, "Guess Lower", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Guess Higher", Toast.LENGTH_SHORT).show();
                }

            }
            else {
            if (!hasWon) {
                Toast.makeText(MainActivity.this, "Sorry! Better luck next time!", Toast.LENGTH_SHORT).show();
            }
            // Reset the game.
            Random rand = new Random();
            randomNumber = rand.nextInt(20) + 1;
            numberOfTimesTried = 0;
            hasWon = false;
        }


    }
}