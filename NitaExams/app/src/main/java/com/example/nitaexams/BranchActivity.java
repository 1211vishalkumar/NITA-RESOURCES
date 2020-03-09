package com.example.nitaexams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class BranchActivity extends AppCompatActivity {
    ArrayList<String> branches = new ArrayList<>();
    RecyclerView rvBranch;
    ArrayList<String> details = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        rvBranch = findViewById(R.id.rvBranch);
        branches.add("Computer Science and Engineering");
        branches.add("Electronics And Communication Engineering");
        branches.add("Mechanical Engineering");
        branches.add("Electrical Engineering");
        branches.add("Electronics And Instrumentation Engineering");
        branches.add("Civil Engineering");
        branches.add("Chemical Engineering");
        branches.add("Production Engineering");
        branches.add("Bio Engineering");

        Intent intentThatStartedThis = getIntent();
        String result = intentThatStartedThis.getStringExtra("Vishal");
        details.add(result);

        rvBranch.setLayoutManager(new LinearLayoutManager(this));
        BranchAdapter branchAdapter = new BranchAdapter(branches,details);
        rvBranch.setAdapter(branchAdapter);

    }
}
