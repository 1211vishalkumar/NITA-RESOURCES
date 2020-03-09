package com.example.nitaexams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> semesters = new ArrayList<>();
    RecyclerView rvSem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSem = findViewById(R.id.rvSem);
        semesters.add("1st Semester");
        semesters.add("2nd Semester");
        semesters.add("3rd Semester");
        semesters.add("4th Semester");
        semesters.add("5th Semester");
        semesters.add("6th Semester");
        semesters.add("7th Semester");
        semesters.add("8th Semester");

        rvSem.setLayoutManager(new LinearLayoutManager(this));
        SemAdapter semAdapter = new SemAdapter(semesters);
        rvSem.setAdapter(semAdapter);





    }



}
