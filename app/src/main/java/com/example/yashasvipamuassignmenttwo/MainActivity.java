package com.example.yashasvipamuassignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    AnimationDrawable animDrawable;
    Animation Zoom;
    Button one,two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.iv);
        imageView.setBackgroundResource(R.drawable.frameanime);
        animDrawable = (AnimationDrawable) imageView.getBackground();
        one=findViewById(R.id.but3);
        two=findViewById(R.id.but4);
        Zoom= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  imageView.startAnimation(Zoom);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Plain.class));
                overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
            }
        });
    }
    public void doFrameAnimation(View view)
    {
        switch (view.getId())
        {
            case R.id.but1:
                if (!animDrawable.isRunning())
                    animDrawable.start();

                break;
            case R.id.but2:
                if (animDrawable.isRunning())
                    animDrawable.stop();
                break;
        }
    }
}