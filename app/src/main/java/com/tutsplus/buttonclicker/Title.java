package com.tutsplus.buttonclicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.media.MediaPlayer;

public class Title extends AppCompatActivity {

    Button start;
    TextView welcome;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_title);


        start = (Button) findViewById(R.id.startButton);
        welcome = (TextView) findViewById(R.id.welcomeTextVIew);
        mp = MediaPlayer.create(this, R.raw.piano);

    }

    public void onClick(View view){

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }


}
