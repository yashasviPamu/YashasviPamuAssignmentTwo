package com.example.yashasvipamuassignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Plain extends AppCompatActivity {
drawing d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d=new drawing(this);
        setContentView(d);
    }
}