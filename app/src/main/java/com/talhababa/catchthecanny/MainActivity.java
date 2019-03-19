package com.talhababa.catchthecanny;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textscore;
    TextView texttime;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    int score;
    ImageView [] imgarray;
    Handler handler;
    Runnable runnable;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageView6);
        img7 = (ImageView) findViewById(R.id.imageView7);
        img8 = (ImageView) findViewById(R.id.imageView8);
        img9 = (ImageView) findViewById(R.id.imageView9);

        imgarray = new ImageView[]{img1,img2,img3,img4,img5,img6,img7,img8,img9};

        score = 0;

        hideimages();

        new CountDownTimer(7000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                texttime = (TextView) findViewById(R.id.textTime);
                texttime.setText("Time : "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                texttime = (TextView) findViewById(R.id.textTime);
                texttime.setText("Time's Off");
                handler.removeCallbacks(runnable);
                imgarray[i].setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    public void increasescore(View view){
        textscore = (TextView) findViewById(R.id.textScore);

        score++;
        textscore.setText("Score : "+score);
    }

    public void hideimages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView imageView:imgarray){
                    imageView.setVisibility(View.INVISIBLE);
                }

                Random random=new Random();
                i = random.nextInt(8-0);
                imgarray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }

        };

        handler.post(runnable);

    }
}
