package com.example.prac02guessinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class SecondaryActivity extends AppCompatActivity{
    private SeekBar seekbar;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        seekbar = (SeekBar) findViewById(R.id.simpleSeekBarMin);
        seekbar = (SeekBar) findViewById(R.id.simpleSeekBarMax);

        preferences = getSharedPreferences("value", MODE_PRIVATE);
        Log.i("Secondary", "on create called");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Secondary", "on start called");
        preferences.edit().putInt("seek bar", seekbar.getProgress()).apply();
    }


    public void handler(View view){
        Intent intent = new Intent(this,MainActivity.class );
        startActivity(intent);}

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Secondary", "on create called");

    }

}
