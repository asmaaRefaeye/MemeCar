package com.inq.eslamwael74.meme.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.R;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Omar on 2/1/2018.
 */

public class SplashActivity extends AppCompatActivity {

      ImageView splashimg;
      TextView splashTxt;
      Button splashLogin;
        private static int SPLASH_TIME_OUT =3000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent m = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(m);
        /*setContentView(R.layout.splash);
        splashimg =findViewById(R.id.splashImg);
        splashTxt =findViewById(R.id.splashttxt);
        splashLogin=findViewById(R.id.Splash_btn);
        splashLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });


        new Handler().postDelayed(new Runnable() {

            *//*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             *//*

            @Override
            public void run() {
                // This method will be executed once the timer is over
                splashTxt.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {

            *//*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             *//*

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        splashTxt.setText(getResources().getString(R.string.thirdSplash));
                        //splashTxt.setText("ضمان أكثر.... ثقة أكثر");
                        new Handler().postDelayed(new Runnable() {

            *//*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             *//*

                            @Override
                            public void run() {
                                // This method will be executed once the timer is over
                                splashLogin.setVisibility(View.VISIBLE);


                            }
                        }, SPLASH_TIME_OUT);


                    }
                }, SPLASH_TIME_OUT);


            }
        }, SPLASH_TIME_OUT);*/
    }


}



