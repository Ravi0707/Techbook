package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Python extends AppCompatActivity {

    PDFView book25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);

        book25 = (PDFView) findViewById(R.id.pdfBook25);

        book25.fromAsset("python.pdf").load();
    }
}