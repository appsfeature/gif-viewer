package com.gifviewer.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gifviewer.GifViewer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void loadGif() {
        GifViewer gifViewer = findViewById(R.id.gif_view);
        gifViewer.setImageResource(R.drawable.hour_glass);
    }
}
