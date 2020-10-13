package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class DesignAndAnalysisOfAlgorithm extends AppCompatActivity {

    PDFView book17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_and_analysis_of_algorithm);

        book17 = (PDFView) findViewById(R.id.pdfBook17);

        book17.fromAsset("designandanalysisofalgorithms.pdf").load();
    }
}