package com.jpdacruz.pruebamaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //widgets
    private Animation topAmin, bottomAnim;
    private ImageView image;
    private TextView logo, slogan;

    //vars
    private static final String TAG = "MainActivity";
    private static final int durationAnim = 2000;
    private static final int durationHandler = 4000;
    private Pair[] pairs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        image.setAnimation(animationTop());
        logo.setAnimation(animationButtom());
        slogan.setAnimation(animationButtom());
        iniciarLoginActividad();
    }

    private void iniciarComponentes() {

        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.textViewLogo);
        slogan = findViewById(R.id.textViewSlogan);
    }

    private void iniciarLoginActividad() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent, datosTranscition().toBundle());
                finish();
            }
        },durationHandler);
    }

    private Animation animationButtom() {
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        bottomAnim.setDuration(durationAnim);

        return bottomAnim;
    }

    private Animation animationTop() {

        topAmin = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        topAmin.setDuration(durationAnim);
        return topAmin;
    }

    private ActivityOptions datosTranscition() {

        pairs = new Pair[2];
        pairs[0] = new Pair<View,String>(image, "logo");
        pairs[1] = new Pair<View, String>(logo, "texto");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);

        return options;
    }
}
