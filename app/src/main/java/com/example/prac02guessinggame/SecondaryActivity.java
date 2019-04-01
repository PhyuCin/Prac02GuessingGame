package com.example.prac02guessinggame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    private TextView progressMin;
    private TextView progressMax;
    private SharedPreferences preferences;
    private SeekBar seekBarMin;
    private SeekBar seekBarMax;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        preferences = getSharedPreferences("value", MODE_PRIVATE);

        progressMin = (TextView) findViewById(R.id.progressMin);
        seekBarMin = (SeekBar) findViewById(R.id.seekBarMin);

        progressMax = (TextView) findViewById(R.id.progressMax);
        seekBarMax = (SeekBar) findViewById(R.id.seekBarMax);

        Log.i("Secondary", "on create called");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Secondary", "on start called");

        seekBarMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressMin.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressMax.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        int min = preferences.getInt("seek bar min", 0);
        seekBarMin.setProgress(min);
        int max = preferences.getInt("seek bar max", 0);
        seekBarMax.setProgress(max);

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Secondary", "on stop called");
        preferences.edit().putInt("seek bar min", seekBarMin.getProgress()).apply();
        preferences.edit().putInt("seek bar max", seekBarMax.getProgress()).apply();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Secondary", "on destroy called");

    }

    public void toMain(View view){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }

}
