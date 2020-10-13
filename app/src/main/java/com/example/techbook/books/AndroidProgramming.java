package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class AndroidProgramming extends AppCompatActivity {

    PDFView book19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_programming);

        book19 = (PDFView) findViewById(R.id.pdfBook19);

        book19.fromAsset("androidprogramming.pdf").load();
    }
}