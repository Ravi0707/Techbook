package com.example.techbook.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ComputerFundamental extends AppCompatActivity {

    PDFView book1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_fundamental);


        book1 = (PDFView) findViewById(R.id.pdfBook1);

        book1.fromAsset("computerfundamentals.pdf").load();
    }
}