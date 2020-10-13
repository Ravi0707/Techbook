package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ComputerGraphics extends AppCompatActivity {

    PDFView book12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_graphics);

        book12 = (PDFView) findViewById(R.id.pdfBook12);

        book12.fromAsset("computergraphics.pdf").load();
    }
}