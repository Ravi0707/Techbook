package com.example.techbook;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesViewHolder extends RecyclerView.ViewHolder {
    TextView pdf_name;
    TextView uploader;
    Button button_download;


    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);

        pdf_name = itemView.findViewById(R.id.pdf_name);
        uploader  = itemView.findViewById(R.id.pdf_uploader);
        button_download = itemView.findViewById(R.id.button_download);
    }
}