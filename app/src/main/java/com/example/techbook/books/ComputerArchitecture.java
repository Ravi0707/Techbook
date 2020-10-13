package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ComputerArchitecture extends AppCompatActivity {

    PDFView book3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_architecture);

        book3 = (PDFView) findViewById(R.id.pdfBook3);

        book3.fromAsset("computerarchitecture.pdf").load();
    }
}