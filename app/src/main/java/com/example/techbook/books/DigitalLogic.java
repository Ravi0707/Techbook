package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class DigitalLogic extends AppCompatActivity {

    PDFView book6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_logic);

        book6 = (PDFView) findViewById(R.id.pdfBook6);

        book6.fromAsset("digitallogic.pdf").load();
    }
}