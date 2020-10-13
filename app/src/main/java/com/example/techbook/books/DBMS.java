package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class DBMS extends AppCompatActivity {

    PDFView book14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b_m_s);

        book14 = (PDFView) findViewById(R.id.pdfBook14);

        book14.fromAsset("dbms.pdf").load();
    }
}