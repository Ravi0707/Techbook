package com.example.techbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterAnswer extends RecyclerView.Adapter<AnswerViewHolder> {
    private AnswerFragment answerFragment;
    private ArrayList<ModelAnswer> answerList;

    public AdapterAnswer(AnswerFragment answerFragment, ArrayList<ModelAnswer> answerList) {
        this.answerFragment = answerFragment;
        this.answerList = answerList;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(answerFragment.getContext());
        View view = layoutInflater.inflate(R.layout.row_answer,null,false);

        return new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AnswerViewHolder holder, final int position) {

        holder.answer_uploader.setText(answerList.get(position).getName());
        holder.exact_answer.setText(answerList.get(position).getAnswer());
    }



    @Override
    public int getItemCount() {
        return answerList.size();
    }
}