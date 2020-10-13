package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class MicroProcessor extends AppCompatActivity {

    PDFView book10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_processor);

        book10 = (PDFView) findViewById(R.id.pdfBook10);

        book10.fromAsset("microprocessor.pdf").load();
    }
}