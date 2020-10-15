package com.example.techbook.books;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.Objects;

public class NotePdfActivity extends AppCompatActivity {

    String bookName;
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_pdf);

        pdfView = findViewById(R.id.pdfView);

        bookName = getIntent().getExtras().getString(getString(R.string.book_name));
        Log.d("BOOKNAME", bookName);
        pdfView.fromAsset(bookName + ".pdf").load();

    }
}