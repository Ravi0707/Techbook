package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class JavaProgramming extends AppCompatActivity {

    PDFView book20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_programming);

        book20 = (PDFView) findViewById(R.id.pdfBook20);

        book20.fromAsset("javaprogramming.pdf").load();
    }
}