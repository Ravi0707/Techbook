package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class CompilerDesign extends AppCompatActivity {

    PDFView book21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler_design);

        book21 = (PDFView) findViewById(R.id.pdfBook21);

        book21.fromAsset("compilerdesign.pdf").load();
    }
}