package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class CloudComputing extends AppCompatActivity {

    PDFView book23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_computing);

        book23 = (PDFView) findViewById(R.id.pdfBook23);

        book23.fromAsset("cloudcomputing.pdf").load();
    }
}