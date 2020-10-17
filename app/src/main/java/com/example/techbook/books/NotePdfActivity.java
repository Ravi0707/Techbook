package com.example.techbook.books;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.techbook.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.Locale;

public class NotePdfActivity extends AppCompatActivity {

    String bookName;
    PDFView pdfView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_pdf);

        pdfView = findViewById(R.id.pdfView);
        toolbar = findViewById(R.id.pdfToolbar)

        bookName = getIntent().getExtras().getString(getString(R.string.book_name));
        Log.d("BOOKNAME", bookName);
        toolbar.setTitle(bookName.toUpperCase(Locale.ROOT));
        pdfView.fromAsset(bookName + ".pdf").load();

    }
}