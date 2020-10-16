package com.example.techbook.ui.main.fragments.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.techbook.R;
import com.example.techbook.books.NotePdfActivity;

public class NotesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button btn1 = view.findViewById(R.id.button_1);
        Button btn2 = view.findViewById(R.id.button_2);
        Button btn3 = view.findViewById(R.id.button_3);
        Button btn4 = view.findViewById(R.id.button_4);
        Button btn5 = view.findViewById(R.id.button_5);
        Button btn6 = view.findViewById(R.id.button_6);
        Button btn7 = view.findViewById(R.id.button_7);
        Button btn8 = view.findViewById(R.id.button_8);
        Button btn9 = view.findViewById(R.id.button_9);
        Button btn10 = view.findViewById(R.id.button_10);
        Button btn11 = view.findViewById(R.id.button_11);
        Button btn12 = view.findViewById(R.id.button_12);
        Button btn13 = view.findViewById(R.id.button_13);
        Button btn14 = view.findViewById(R.id.button_14);
        Button btn15 = view.findViewById(R.id.button_15);
        Button btn16 = view.findViewById(R.id.button_16);
        Button btn17 = view.findViewById(R.id.button_17);
        Button btn18 = view.findViewById(R.id.button_18);
        Button btn19 = view.findViewById(R.id.button_19);
        Button btn20 = view.findViewById(R.id.button_20);
        Button btn21 = view.findViewById(R.id.button_21);
        Button btn22 = view.findViewById(R.id.button_22);
        Button btn23 = view.findViewById(R.id.button_23);
        Button btn24 = view.findViewById(R.id.button_24);
        Button btn25 = view.findViewById(R.id.button_25);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "computerfundamentals");
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "cprogramming");
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "computerarchitecture");
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "operatingsystem");
                startActivity(i);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "computernetwork");
                startActivity(i);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "digitallogic");
                startActivity(i);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "informationtechnology");
                startActivity(i);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "cpp");
                startActivity(i);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "discretestructure");
                startActivity(i);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "microprocessor");
                startActivity(i);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "datastructurealgorithm");
                startActivity(i);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "computergraphics");
                startActivity(i);
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "ai");
                startActivity(i);
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "dbms");
                startActivity(i);
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "systemanalysisanddesign");
                startActivity(i);
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "webtechnology");
                startActivity(i);
            }
        });

        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "designandanalysisofalgorithms");
                startActivity(i);
            }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "cryptography");
                startActivity(i);
            }
        });

        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "androidprogramming");
                startActivity(i);
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "javaprogramming");
                startActivity(i);
            }
        });

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "compilerdesign");
                startActivity(i);
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "ecommerce");
                startActivity(i);
            }
        });

        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "cloudcomputing");
                startActivity(i);
            }
        });

        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "php");
                startActivity(i);
            }
        });

        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(requireActivity(), NotePdfActivity.class);
                i.putExtra(getString(R.string.book_name), "python");
                startActivity(i);
            }
        });


    }

}