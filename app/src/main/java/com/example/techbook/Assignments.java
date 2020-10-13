package com.example.techbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.techbook.books.AndroidProgramming;
import com.example.techbook.books.ArtificialIntelligence;
import com.example.techbook.books.CloudComputing;
import com.example.techbook.books.CompilerDesign;
import com.example.techbook.books.ComputerArchitecture;
import com.example.techbook.books.ComputerFundamental;
import com.example.techbook.books.ComputerGraphics;
import com.example.techbook.books.ComputerNetwork;
import com.example.techbook.books.Cpp;
import com.example.techbook.books.Cprogramming;
import com.example.techbook.books.Cryptography;
import com.example.techbook.books.DBMS;
import com.example.techbook.books.DSA;
import com.example.techbook.books.DesignAndAnalysisOfAlgorithm;
import com.example.techbook.books.DigitalLogic;
import com.example.techbook.books.DiscreteStructure;
import com.example.techbook.books.Ecommerce;
import com.example.techbook.books.InformationTechnology;
import com.example.techbook.books.JavaProgramming;
import com.example.techbook.books.MicroProcessor;
import com.example.techbook.books.OperatingSystem;
import com.example.techbook.books.PHP;
import com.example.techbook.books.Python;
import com.example.techbook.books.SAD;
import com.example.techbook.books.WebTechnology;

import java.util.Objects;

public class Assignments extends Fragment {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_assignments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requireActivity().setTitle("Notes");
        DashBoardActivity.navigationView.setCheckedItem(R.id.nav_assignment);

        btn1 = view.findViewById(R.id.button_1);
        btn2 = view.findViewById(R.id.button_2);
        btn3 = view.findViewById(R.id.button_3);
        btn4 = view.findViewById(R.id.button_4);
        btn5 = view.findViewById(R.id.button_5);
        btn6 = view.findViewById(R.id.button_6);
        btn7 = view.findViewById(R.id.button_7);
        btn8 = view.findViewById(R.id.button_8);
        btn9 = view.findViewById(R.id.button_9);
        btn10 = view.findViewById(R.id.button_10);
        btn11 = view.findViewById(R.id.button_11);
        btn12 = view.findViewById(R.id.button_12);
        btn13 = view.findViewById(R.id.button_13);
        btn14 = view.findViewById(R.id.button_14);
        btn15 = view.findViewById(R.id.button_15);
        btn16 = view.findViewById(R.id.button_16);
        btn17 = view.findViewById(R.id.button_17);
        btn18 = view.findViewById(R.id.button_18);
        btn19 = view.findViewById(R.id.button_19);
        btn20 = view.findViewById(R.id.button_20);
        btn21 = view.findViewById(R.id.button_21);
        btn22 = view.findViewById(R.id.button_22);
        btn23 = view.findViewById(R.id.button_23);
        btn24 = view.findViewById(R.id.button_24);
        btn25 = view.findViewById(R.id.button_25);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ComputerFundamental.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Cprogramming.class);
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ComputerArchitecture.class);
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), OperatingSystem.class);
                startActivity(i);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ComputerNetwork.class);
                startActivity(i);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DigitalLogic.class);
                startActivity(i);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), InformationTechnology.class);
                startActivity(i);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Cpp.class);
                startActivity(i);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DiscreteStructure.class);
                startActivity(i);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MicroProcessor.class);
                startActivity(i);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DSA.class);
                startActivity(i);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ComputerGraphics.class);
                startActivity(i);
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ArtificialIntelligence.class);
                startActivity(i);
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DBMS.class);
                startActivity(i);
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SAD.class);
                startActivity(i);
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), WebTechnology.class);
                startActivity(i);
            }
        });

        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DesignAndAnalysisOfAlgorithm.class);
                startActivity(i);
            }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Cryptography.class);
                startActivity(i);
            }
        });

        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AndroidProgramming.class);
                startActivity(i);
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), JavaProgramming.class);
                startActivity(i);
            }
        });

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CompilerDesign.class);
                startActivity(i);
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Ecommerce.class);
                startActivity(i);
            }
        });

        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CloudComputing.class);
                startActivity(i);
            }
        });

        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PHP.class);
                startActivity(i);
            }
        });

        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Python.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        MenuItem item = menu.findItem(R.id.add_pdf);
        item.setVisible(false);
        //super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);
    }

}