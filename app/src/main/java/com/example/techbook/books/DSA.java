package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class DSA extends AppCompatActivity {

    PDFView book11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_s);

        book11 = (PDFView) findViewById(R.id.pdfBook11);

        book11.fromAsset("datastructurealgorithm.pdf").load();
    }
}