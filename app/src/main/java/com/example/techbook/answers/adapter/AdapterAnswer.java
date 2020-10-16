package com.example.techbook.answers.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techbook.R;
import com.example.techbook.data.ModelAnswer;

import java.util.ArrayList;

public class AdapterAnswer extends RecyclerView.Adapter<AdapterAnswer.AnswerViewHolder> {
    private final ArrayList<ModelAnswer> answerList;

    public AdapterAnswer(ArrayList<ModelAnswer> answerList) {
        this.answerList = answerList;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_answer, parent, false);

        return new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AnswerViewHolder holder, final int position) {
        Log.d("SIZE", String.valueOf(answerList.size()));
        holder.answer_uploader.setText(answerList.get(position).getName());
        holder.exact_answer.setText(answerList.get(position).getAnswer());
    }


    @Override
    public int getItemCount() {
        return answerList.size();
    }

    static class AnswerViewHolder extends RecyclerView.ViewHolder {
        TextView answer_uploader, exact_answer;

        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);

            answer_uploader = itemView.findViewById(R.id.nameTv);
            exact_answer = itemView.findViewById(R.id.answerTv);
        }
    }
}