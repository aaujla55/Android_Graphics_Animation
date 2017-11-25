package com.example.amandeepaujla.amandeepaujla_comp304_lab3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Exercise3 extends AppCompatActivity {
    //
    ImageView earth;
    ImageView moon;
    Animation an;
    Animation an2;
    //
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);
        paint = new Paint();
        // Handle Start Button
        final Button onButton = (Button) findViewById(R.id.ButtonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.ButtonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation()
    {
        // We will animate the imageview
        earth = (ImageView)findViewById(R.id.earth);
        moon = (ImageView)findViewById(R.id.moon);
        an =  AnimationUtils.loadAnimation(this, R.anim.rotate);
        an2 = AnimationUtils.loadAnimation(this, R.anim.translate);
        // Start the animation

        earth.startAnimation(an);
        moon.startAnimation(an2);

    }// end of startAnimation

    private void stopAnimation()
    {
        earth.clearAnimation();
        moon.clearAnimation();
    }

}
