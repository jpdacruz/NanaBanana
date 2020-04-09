package com.jpdacruz.pruebamaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    private ImageView nanaCatton;
    private Animation topAnimation;
    private static final int durationAnim = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        nanaCatton = findViewById(R.id.imageViewNanaCartoon);
        nanaCatton.setAnimation(animationTop());
    }

    private Animation animationTop() {
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.nanaloginanimation);
        topAnimation.setDuration(durationAnim);
        return  topAnimation;
    }
}
