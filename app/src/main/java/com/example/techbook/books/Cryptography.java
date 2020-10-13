package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Cryptography extends AppCompatActivity {

    PDFView book18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cryptography);

        book18 = (PDFView) findViewById(R.id.pdfBook18);

        book18.fromAsset("cryptography.pdf").load();
    }
}