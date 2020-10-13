package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class WebTechnology extends AppCompatActivity {

    PDFView book16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_technology);

        book16 = (PDFView) findViewById(R.id.pdfBook16);

        book16.fromAsset("webtechnology.pdf").load();
    }
}