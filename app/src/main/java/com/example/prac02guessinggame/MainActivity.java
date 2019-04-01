package com.example.prac02guessinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView statusText;
    private TextView minNum;
    private TextView maxNum;
    private TextView secretNum;
    private SharedPreferences preferences;

    private int secretNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minNum = findViewById(R.id.minNum);
        maxNum = findViewById((R.id.maxNum));
        secretNum = findViewById(R.id.secretNum);


        preferences = getSharedPreferences("value", MODE_PRIVATE);
        statusText = findViewById(R.id.statusText);
        EditText guessNum = findViewById(R.id.guessNum);

        statusText.setText(getString(R.string.initialStatus));
        guessNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {

                int value = Integer.parseInt(string.toString());

                if (secretNumber == value){
                    statusText.setText(getString(R.string.statusCorrect));
                }
                else if (secretNumber > value){
                    statusText.setText(getString(R.string.statusBigger));
                }
                else {
                    statusText.setText(getString(R.string.statusSmaller));
                }

            }

            @Override
            public void afterTextChanged(Editable string) {
            }
        });
    }

    public void onStart(){
        super.onStart();
        int min = preferences.getInt("seek bar min", 0);
        int max = preferences.getInt("seek bar max", 0);

        Random random = new Random();
        secretNumber = random.nextInt((max - min) + 1) + min;

        minNum.setText("" + min);
        maxNum.setText(" " + max);
        secretNum.setText(" " + secretNumber);

    }

    public void toEdit(View view){
        Intent intent = new Intent(this,SecondaryActivity.class );
        startActivity(intent);
    }
}