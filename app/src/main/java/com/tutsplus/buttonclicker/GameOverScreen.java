package com.tutsplus.buttonclicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class GameOverScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_over_screen);



        Bundle passedFinishScore =getIntent().getExtras();
        if(passedFinishScore == null){
            return;
        }
        String finishedScore = passedFinishScore.getString("playerScore");
        final TextView scoreNumberTextView = (TextView) findViewById(R.id.scoreNumberTextView);
        scoreNumberTextView.setText(finishedScore);
    }

    public void onClick(View v){
        restart();
    }

    public void restart(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
