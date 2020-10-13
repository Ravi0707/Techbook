package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Cpp extends AppCompatActivity {

    PDFView book8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);

        book8 = (PDFView) findViewById(R.id.pdfBook8);

        book8.fromAsset("cpp.pdf").load();
    }
}