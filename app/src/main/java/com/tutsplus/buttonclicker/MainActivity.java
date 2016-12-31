package com.tutsplus.buttonclicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.MotionEvent; //for movement
import android.view.ViewGroup; //for referencing the layout
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.CountDownTimer;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ViewGroup myLayout;
    Button initialButton;
    TextView score;
    TextView timeCountdown;

    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        score = (TextView) findViewById(R.id.scoreNumberTextView);
        initialButton = (Button) findViewById(R.id.initialButton);

        myLayout = (ViewGroup) findViewById(R.id.myLayout);
        myLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        resetScore();
                        return true;
                    }
                });
        initialButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveButton();
            }
        });
        startTimer();


    }

    public void startTimer(){
        timeCountdown = (TextView) findViewById(R.id.timeCountdown);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timeCountdown.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timeCountdown.setText("done!");
                Intent nextScreen = new Intent(MainActivity.this, GameOverScreen.class);
                final TextView scoreNumerTextView = (TextView) findViewById(R.id.scoreNumberTextView);
                String finishedScore = scoreNumerTextView.getText().toString();
                nextScreen.putExtra("playerScore",finishedScore);
                startActivity(nextScreen);
            }
        }.start();

    }

    public void resetScore() {
        points = 0;
        score.setText("" + 0);
    }

    public void moveButton() {
        Random random = new Random();
        int rand = random.nextInt(5);


        if (rand == 0) {
            //bottom right
            RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            initialButton.setLayoutParams(positionRules);
        } else if (rand == 1) {
            //bottom left
            RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            initialButton.setLayoutParams(positionRules);
        } else if (rand == 2) {
            //top right
            RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
            initialButton.setLayoutParams(positionRules);
        } else if (rand == 3) {
            //top left
            RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
            initialButton.setLayoutParams(positionRules);
        } else if (rand == 4) {
            //center
            RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            positionRules.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);

            initialButton.setLayoutParams(positionRules);
        }

        points++;
        score.setText("" + points);
    }
}
