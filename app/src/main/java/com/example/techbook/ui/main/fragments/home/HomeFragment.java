package com.example.techbook.ui.main.fragments.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techbook.R;
import com.example.techbook.answers.AnswersActivity;
import com.example.techbook.data.QuestionDownModel;
import com.example.techbook.database.Database;
import com.example.techbook.ui.askQuestion.AskQuestionActivity;
import com.example.techbook.ui.writeAnswer.WriteAnswersActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class HomeFragment extends Fragment implements QuestionsAdapter.AnswerClickListener {
    private RecyclerView questionsRecyclerView;
    private final ArrayList<QuestionDownModel> questionDownModels = new ArrayList<>();
    private Database database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionsRecyclerView = view.findViewById(R.id.recycler_questions);
        FloatingActionButton actionButton = view.findViewById(R.id.addQuestion);

        questionsRecyclerView.setHasFixedSize(true);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        questionsRecyclerView.setAdapter(new QuestionsAdapter(questionDownModels, this));

        database = new Database();

        database.getDb().collection("Questions")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())) {
                            QuestionDownModel downModel = new QuestionDownModel(
                                    documentSnapshot.getString("Uploader"),
                                    documentSnapshot.getString("question"),
                                    documentSnapshot.getString("title"),
                                    documentSnapshot.getString("date")
                            );
                            questionDownModels.add(downModel);
                        }

                        Collections.sort(questionDownModels, new Comparator<QuestionDownModel>() {
                            @Override
                            public int compare(QuestionDownModel o1, QuestionDownModel o2) {
                                return o1.getTimestamp().compareTo(o2.getTimestamp());
                            }
                        });


                        Objects.requireNonNull(questionsRecyclerView.getAdapter()).notifyDataSetChanged();
                        questionsRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    }
                });

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), AskQuestionActivity.class));
            }
        });
    }

    @Override
    public void onAnswerClick(String question) {
        Intent intent = new Intent(requireActivity(), WriteAnswersActivity.class);
        intent.putExtra("question", question);
        startActivity(intent);
    }

    @Override
    public void onSeeAnswerClick(String question) {
        Intent intent = new Intent(requireActivity(), AnswersActivity.class);
        intent.putExtra("question", question);
        startActivity(intent);
    }
}