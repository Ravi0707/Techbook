package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ComputerNetwork extends AppCompatActivity {

    PDFView book5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_network);

        book5 = (PDFView) findViewById(R.id.pdfBook5);

        book5.fromAsset("computernetwork.pdf").load();
    }
}