package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class OperatingSystem extends AppCompatActivity {

    PDFView book4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operating_system);

        book4 = (PDFView) findViewById(R.id.pdfBook4);

        book4.fromAsset("operatingsystem.pdf").load();
    }
}