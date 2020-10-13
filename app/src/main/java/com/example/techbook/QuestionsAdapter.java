package com.example.techbook;

import android.content.Intent;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static com.example.techbook.Feed.database;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsViewHolder> {
    private Feed feedFragment;
    private ArrayList<QuestionDownModel> downModels;

    public QuestionsAdapter(Feed feedFragment, ArrayList<QuestionDownModel> downModels) {
        this.feedFragment = feedFragment;
        this.downModels = downModels;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(feedFragment.getContext());
        View view = layoutInflater.inflate(R.layout.questions_view,null,false);

        return new QuestionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionsViewHolder holder, final int position) {

            holder.text_uploader.setText(downModels.get(position).getUploader());
            holder.text_question.setText(downModels.get(position).getQuestion());
            holder.text_topic.setText(downModels.get(position).getTitle());



        holder.card_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedFragment.writeAnswer( downModels.get(position).getQuestion() );
            }
        });

        holder.card_see_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnswerFragment answerFragment = new AnswerFragment();
                ArrayList<ModelAnswer> answerList = new ArrayList<>();
                answerFragment.showAnswer(answerList.get(position).getName(), answerList.get(position).getAnswer());
            }
        });
    }



    @Override
    public int getItemCount() {
        return downModels.size();
    }
}