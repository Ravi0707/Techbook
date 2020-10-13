package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class InformationTechnology extends AppCompatActivity {

    PDFView book7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_technology);

        book7 = (PDFView) findViewById(R.id.pdfBook7);

        book7.fromAsset("informationtechnology.pdf").load();
    }
}