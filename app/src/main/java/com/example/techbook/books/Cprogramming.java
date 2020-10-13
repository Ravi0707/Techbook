package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Cprogramming extends AppCompatActivity {

    PDFView book2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cprogramming);

        book2 = (PDFView) findViewById(R.id.pdfBook2);

        book2.fromAsset("cprogramming.pdf").load();
    }
}