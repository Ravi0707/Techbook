package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Ecommerce extends AppCompatActivity {

    PDFView book22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecommerce);

        book22 = (PDFView) findViewById(R.id.pdfBook22);

        book22.fromAsset("ecommerce.pdf").load();
    }
}