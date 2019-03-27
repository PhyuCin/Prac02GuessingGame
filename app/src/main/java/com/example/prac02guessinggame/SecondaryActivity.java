package com.example.prac02guessinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class SecondaryActivity extends AppCompatActivity{
    private SeekBar seekbarMin;
    private SeekBar seekbarMax;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        seekbarMin = (SeekBar) findViewById(R.id.simpleSeekBarMin);
        seekbarMax = (SeekBar) findViewById(R.id.simpleSeekBarMax);

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
