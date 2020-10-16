package com.example.techbook.answers;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techbook.R;
import com.example.techbook.answers.adapter.AdapterAnswer;
import com.example.techbook.data.ModelAnswer;
import com.example.techbook.database.Database;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class AnswersActivity extends AppCompatActivity {

    private RecyclerView answerRecyclerView;
    private final ArrayList<ModelAnswer> answerDownModels = new ArrayList<>();
    private String question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers2);

        question = getIntent().getExtras().getString("question");

        answerRecyclerView = findViewById(R.id.answer_recyclerView);
        answerRecyclerView.setHasFixedSize(true);
        answerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        answerRecyclerView.setAdapter(new AdapterAnswer(answerDownModels));


        Database database = new Database();

        database.getDb().collection("Answers").whereEqualTo("question", question)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        answerDownModels.clear();
                        for (DocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())) {
                            ModelAnswer modelAnswer = new ModelAnswer(
                                    documentSnapshot.getString("question"),
                                    documentSnapshot.getString("Uploader"),
                                    documentSnapshot.getString("answer")
                            );
                            answerDownModels.add(modelAnswer);
                        }

                        Objects.requireNonNull(answerRecyclerView.getAdapter()).notifyDataSetChanged();
                        answerRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    }
                });
    }
}