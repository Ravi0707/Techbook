package com.example.techbook;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnswerViewHolder extends RecyclerView.ViewHolder {
    TextView answer_uploader, exact_answer;

    public AnswerViewHolder(@NonNull View itemView) {
        super(itemView);

        answer_uploader = itemView.findViewById(R.id.nameTv);
        exact_answer = itemView.findViewById(R.id.answerTv);
    }
}
