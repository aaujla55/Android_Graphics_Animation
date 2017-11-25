package com.example.amandeepaujla.amandeepaujla_comp304_lab3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Exercise1 extends AppCompatActivity {

    ImageView reusableImageView;
    TextView textView;

    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    int startx = 15;
    int starty = 15;
    int endx= 15;
    int endy=15;
    Spinner spinner;
    Spinner spinnerColor;
    RadioGroup rg;
    Button startButton;
    int width;
    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        spinner = (Spinner) findViewById(R.id.line_thickness_spinner);
        //spinnerColor = (Spinner) findViewById(R.id.color_spinner);
        //Create an array adapter using string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.line_thickness_values, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);



        rg = (RadioGroup) findViewById(R.id.radioGroupColors);
        startButton = (Button) findViewById(R.id.buttonStart);
        //set the paint properties
        paint = new Paint();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                int thickness = Integer.parseInt(spinner.getSelectedItem().toString());
                paint.setStrokeWidth(thickness);
            }
           public void onNothingSelected(AdapterView<?> arg0) { }
       });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId){
                    case R.id.radioButtonred:  paint.setColor(Color.RED);
                        break;
                    case R.id.radioButtonyellow:  paint.setColor(Color.YELLOW);
                        break;
                    case R.id.radioButtoncyan:  paint.setColor(Color.CYAN);
                        break;
                    default: paint.setColor(Color.BLACK);
                        break;
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               width = (int) getResources().getDimension(R.dimen.img_width);
                height = (int) getResources().getDimension(R.dimen.img_height);
                //creating a bitmap as content view for the canvas
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

                canvas = new Canvas(bitmap);
                canvas.drawColor(Color.WHITE);
                paint.setStrokeWidth(40);
                paint.setColor(Color.BLACK);
                reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
                //setting a bitmap as content view for the image
                reusableImageView.setImageBitmap(bitmap);
                reusableImageView.setVisibility(View.VISIBLE);
                //textView = (TextView) findViewById(R.id.textView5);
            }
        }
        );

    }

    public void drawLine(Canvas canvas)
    {
        //textView.setText(String.valueOf(endy));
        //canvas.drawLine(100,100,1000,1000,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }

    public void drawLineDown(View v)
    {
        reusableImageView.setVisibility(View.VISIBLE);
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endy=endy+10;
        drawLine(canvas);
        reusableImageView.invalidate();
    }

    public void drawLineUp(View v)
    {
        reusableImageView.setVisibility(View.VISIBLE);
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endy=endy-10;
        drawLine(canvas);
        reusableImageView.invalidate();
    }

    public void drawLineLeft(View v)
    {
        reusableImageView.setVisibility(View.VISIBLE);
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx-10;
        drawLine(canvas);
        reusableImageView.invalidate();
    }

    public void drawLineRight(View v)
    {
        reusableImageView.setVisibility(View.VISIBLE);
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx+10;
        drawLine(canvas);
        reusableImageView.invalidate();
    }






}
