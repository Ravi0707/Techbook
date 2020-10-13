package com.example.techbook;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AnswerFragment extends Fragment {
    private RecyclerView answerRecyclerView;
    private ArrayList<ModelAnswer> answerDownModels = new ArrayList<>();
    private AdapterAnswer adapterAnswer;
    static Database database;
    static String name;
    static String answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Answers");

        answerRecyclerView = view.findViewById(R.id.answer_recyclerView);
        answerRecyclerView.setHasFixedSize(true);
        answerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        database = new Database();

        database.getDb().collection("Questions")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())){
                            ModelAnswer modelAnswer = new ModelAnswer(
                                    documentSnapshot.getString("Uploader"),
                                    documentSnapshot.getString("answer")
                            );
                            answerDownModels.add(modelAnswer);
                        }
                        adapterAnswer = new AdapterAnswer(AnswerFragment.this, answerDownModels);
                        answerRecyclerView.setAdapter(adapterAnswer);
                        adapterAnswer.notifyDataSetChanged();
                        answerRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    }
                });
    }

    void showAnswer(String name, String answer){
        AnswerFragment.name = name;
        AnswerFragment.answer = answer;
        startActivity(new Intent(this.getActivity(), AnswerFragment.class));
    }
}