package com.example.nitaexams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    TextView tvSem,tvBranch;
    ArrayList<String> finalDetails = new ArrayList<>();
    Button btnMid,btnEnd;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference sRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        tvSem = findViewById(R.id.tvSem);
        tvBranch = findViewById(R.id.tvBranch);
        btnMid = findViewById(R.id.btnMid);
        btnEnd = findViewById(R.id.btnEnd);

        Intent intentThatStartedThis = getIntent();
        finalDetails = intentThatStartedThis.getStringArrayListExtra("Anshu");

        tvSem.setText(finalDetails.get(0));
        tvBranch.setText(finalDetails.get(1));

        btnMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFile("/Mid Term/mid.pdf");
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFile("/End Term/end.pdf");
            }
        });


    }

    public void openFile(String s){

        storageReference = firebaseStorage.getInstance().getReference();
        String s1 =finalDetails.get(0);
        String s2 = finalDetails.get(1);
        sRef = storageReference.child(s1+"/"+s2+s);
        sRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(url), "application/pdf");
                startActivity(Intent.createChooser(intent, "Choose an Application:"));

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FinalActivity.this,"nahi hua hai abhi tak upload",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
