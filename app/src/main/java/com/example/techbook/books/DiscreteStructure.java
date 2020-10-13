package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class DiscreteStructure extends AppCompatActivity {
    PDFView book9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discrete_structure);

        book9 = (PDFView) findViewById(R.id.pdfBook9);

        book9.fromAsset("discretestructure.pdf").load();
    }
}