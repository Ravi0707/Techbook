package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PHP extends AppCompatActivity {

    PDFView book24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_h_p);

        book24 = (PDFView) findViewById(R.id.pdfBook24);

        book24.fromAsset("php.pdf").load();
    }
}