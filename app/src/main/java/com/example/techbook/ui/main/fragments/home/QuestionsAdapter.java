package com.example.techbook.ui.main.fragments.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techbook.R;
import com.example.techbook.data.QuestionDownModel;

import java.util.ArrayList;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder> {
    private final ArrayList<QuestionDownModel> downModels;
    private final QuestionsAdapter.AnswerClickListener listener;

    public QuestionsAdapter(ArrayList<QuestionDownModel> downModels, QuestionsAdapter.AnswerClickListener listener) {
        this.downModels = downModels;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_questions, parent, false);
        return new QuestionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionsViewHolder holder, final int position) {

        holder.questionUploader.setText(String.format("Posted By: %s", downModels.get(position).getUploader()));
        holder.questionDescription.setText(downModels.get(position).getQuestion());
        holder.questionTitle.setText(downModels.get(position).getTitle());


        holder.answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAnswerClick(downModels.get(position).getQuestion());
            }
        });

        holder.seeAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSeeAnswerClick(downModels.get(position).getQuestion());
            }
        });
    }


    @Override
    public int getItemCount() {
        return downModels.size();
    }

    static class QuestionsViewHolder extends RecyclerView.ViewHolder {
        TextView questionDescription, questionTitle, questionUploader, answer, seeAnswer;

        public QuestionsViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTitle = itemView.findViewById(R.id.questionTitle);
            questionDescription = itemView.findViewById(R.id.questionDescription);
            questionUploader = itemView.findViewById(R.id.postedBy);
            answer = itemView.findViewById(R.id.answer);
            seeAnswer = itemView.findViewById(R.id.seeAnswers);
        }
    }

    interface AnswerClickListener {
        void onAnswerClick(String question);

        void onSeeAnswerClick(String question);
    }
}