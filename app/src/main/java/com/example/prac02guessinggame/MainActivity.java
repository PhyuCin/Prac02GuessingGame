package com.example.prac02guessinggame;

import android.content.Intent;
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
    private EditText guessNum;

    private int secretNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        secretNumber = 1 + random.nextInt(100);

        statusText = (TextView) findViewById(R.id.statusText);
        guessNum = (EditText) findViewById(R.id.guessNum);

        statusText.setText("Guess the number:");
        guessNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence string, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {

                int value = Integer.parseInt(string.toString());

                    if (secretNumber == value){
                        statusText.setText("You won!");
                }
                    else if (secretNumber > value){
                        statusText.setText("Try bigger");
                    }
                    else {
                        statusText.setText("Try smaller");
                    }
                    
            }

            @Override
            public void afterTextChanged(Editable string) {

            }
        });
    }

    public void handler(View view){
        Intent intent = new Intent(this,SecondaryActivity.class );
        startActivity(intent);
    }
}
