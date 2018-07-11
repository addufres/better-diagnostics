package com.thedufresnegroup.adufres.betterdiagnostics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Set;

public class DetailedCodeActivity extends AppCompatActivity {
    private TextView category;
    private TextView codeView;
    private TextView desc;
    private DatabaseReference dbRef;
    private Set<TroubleCode> tcSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_code);
        dbRef = FirebaseDatabase.getInstance().getReference().child("TroubleCode"); // Get FireBase child ref to run through i.e "collection"


        codeView = findViewById(R.id.code);
        codeView.setText("dbRef");
        System.out.print(dbRef);
    }

    public Set<TroubleCode> getTcSet() {
        return tcSet;
    }

    public void setTcSet(Set<TroubleCode> tcSet) {
        this.tcSet = tcSet;
    }

    public void addTcSet(TroubleCode tc) {
        this.tcSet.add(tc);
    }

    public void removeTcSet(TroubleCode tc) {
        this.tcSet.remove(tc);
    }
    public DetailedCodeActivity() {};
}
