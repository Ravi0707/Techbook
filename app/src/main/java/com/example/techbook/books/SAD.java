package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class SAD extends AppCompatActivity {

    PDFView book15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_a_d);

        book15 = (PDFView) findViewById(R.id.pdfBook15);

        book15.fromAsset("systemanalysisanddesign.pdf").load();
    }
}