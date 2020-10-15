package com.example.techbook.ui.main.fragments.notes.adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techbook.R;
import com.example.techbook.data.NotesDownModel;

import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    ArrayList<NotesDownModel> downModels;

    public NotesAdapter(ArrayList<NotesDownModel> downModels) {
        this.downModels = downModels;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.notes_view, parent, false);

        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NotesViewHolder holder, final int position) {

        holder.pdf_name.setText(downModels.get(position).getPdfName());
        holder.uploader.setText(downModels.get(position).getUploader());
        holder.button_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFiles(holder.pdf_name.getContext(), downModels.get(position).getPdfName(), ".pdf",
                        DIRECTORY_DOWNLOADS, downModels.get(position).getLink());
            }
        });

    }

    private void downloadFiles(Context context, String filename, String fileExtension
            , String destinationDirectory, String url) {

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, filename + fileExtension);

        assert downloadManager != null;
        downloadManager.enqueue(request);

    }

    @Override
    public int getItemCount() {
        return downModels.size();
    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView pdf_name;
        TextView uploader;
        Button button_download;


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            pdf_name = itemView.findViewById(R.id.pdf_name);
            uploader = itemView.findViewById(R.id.pdf_uploader);
            button_download = itemView.findViewById(R.id.button_download);
        }
    }
}
