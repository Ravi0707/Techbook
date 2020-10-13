package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ArtificialIntelligence extends AppCompatActivity {

    PDFView book13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artificial_intelligence);

        book13 = (PDFView) findViewById(R.id.pdfBook13);

        book13.fromAsset("ai.pdf").load();
    }
}