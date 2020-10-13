package com.example.techbook;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionsViewHolder extends RecyclerView.ViewHolder {
    TextView text_question;
    TextView text_topic;
    TextView text_uploader;
    Button card_answer, card_see_answer;

    public QuestionsViewHolder(@NonNull View itemView) {
        super(itemView);

        text_topic = itemView.findViewById(R.id.title);
        text_question = itemView.findViewById(R.id.question);
        text_uploader = itemView.findViewById(R.id.text_uploader);
        card_answer  =  (Button) itemView.findViewById(R.id.card_answer);
        card_see_answer = (Button) itemView.findViewById(R.id.card_see_answer);
    }
}

