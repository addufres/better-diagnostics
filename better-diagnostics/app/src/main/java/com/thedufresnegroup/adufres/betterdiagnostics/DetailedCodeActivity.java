package com.thedufresnegroup.adufres.betterdiagnostics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailedCodeActivity extends AppCompatActivity {
    private DatabaseReference dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_code);

        dbRef = FirebaseDatabase.getInstance().getReference().child("TroubleCode"); // Get FireBase child ref to run through i.e "collection"
        System.out.print(dbRef);
    }
}
