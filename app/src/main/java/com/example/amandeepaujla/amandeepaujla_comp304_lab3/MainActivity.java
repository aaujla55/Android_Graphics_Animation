package com.example.amandeepaujla.amandeepaujla_comp304_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Author: Amandeep Aujla
    //November 3, 2017

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //navigate to Exercise 1 activity
    public void openExercise1(View view)
    {
        Intent intent = new Intent(this, Exercise1.class);
        startActivity(intent);
    }

    //navigate to Exercise 2 activity
    public void openExercise2(View view)
    {
        Intent intent = new Intent(this, Exercise2.class);
        startActivity(intent);
    }

    //navigate to Exercise 3 activity
    public void openExercise3(View view)
    {
        Intent intent = new Intent(this, Exercise3.class);
        startActivity(intent);
    }
}
