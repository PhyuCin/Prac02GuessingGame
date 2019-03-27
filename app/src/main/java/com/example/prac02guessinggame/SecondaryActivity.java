package com.example.prac02guessinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity{
    private SeekBar seekbarMin;
    private SeekBar seekbarMax;
    private TextView progressTextMin;
    private TextView progressTextMax;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        seekbarMin = (SeekBar) findViewById(R.id.simpleSeekBarMin);
        seekbarMax = (SeekBar) findViewById(R.id.simpleSeekBarMax);
        progressTextMin = (TextView) findViewById(R.id.minNum);
        progressTextMax = (TextView) findViewById(R.id.maxNum);

        preferences = getSharedPreferences("value", MODE_PRIVATE);
        Log.i("Secondary", "on create called");
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Secondary", "on start called");

        int progressMin = preferences.getInt("seek bar min", 0);
        seekbarMin.setProgress(progressMin);
        int progressMax = preferences.getInt("seek bar max", 0);
        seekbarMax.setProgress(progressMax);

        progressTextMin.setText("" + preferences.getInt("seek bar min", 0));
        progressTextMax.setText("" + preferences.getInt("seek bar max", 0));
    }


    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Secondary", "on stop called");
        preferences.edit().putInt("seek bar min", seekbarMin.getProgress()).apply();
        preferences.edit().putInt("seek bar max", seekbarMax.getProgress()).apply();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Secondary", "on create called");

    }

    public void handler(View view){
        Intent intent = new Intent(this,MainActivity.class );
        startActivity(intent);}

}
