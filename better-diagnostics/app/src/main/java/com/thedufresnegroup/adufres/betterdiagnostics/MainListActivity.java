package com.thedufresnegroup.adufres.betterdiagnostics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/*
   Primary purpose of the main screen is to list all of the codes
   available to read and then click each code to view more detailed
   information about each code
*/
public class MainListActivity extends AppCompatActivity {
    private ListView mainListView;
    private DatabaseReference dbRef;
    private ArrayAdapter<String> listAdapter ;
    private ArrayList<String> codeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainListView = findViewById( R.id.mainListView ); // Find the ListView resource.
        listAdapter = new ArrayAdapter<>(this, R.layout.simplerow, codeList); // Create ArrayAdapter using the TroubleCode list.
        mainListView.setAdapter( listAdapter ); // Set the ArrayAdapter as the ListView's adapter.
        dbRef = FirebaseDatabase.getInstance().getReference().child("TroubleCode"); // Get FireBase child ref to run through i.e "collection"
        /*
            This event listener pulls in the data from Firebase and
            takes puts them through a forEach loop storing each child
            in a POJO and taking the information and displaying the code
            as a string to the user each code as its own list item in listView
        */
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    TroubleCode tc = postSnapshot.getValue(TroubleCode.class);
                    //Adding it to a string
                    String code = tc.getCode();
                    codeList.add(code);
                    // check for size change and adjust adapter and view
                    if(codeList.size() == 1) {
                        listAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,codeList);
                        mainListView.setAdapter(listAdapter);
                    } else if (codeList.size() > 1) {
                        listAdapter.notifyDataSetChanged();
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });
        /*
            I still need to add action for when you click on a listView
            item to take you to a detailed view of that trouble code and
            have it display all of the information
        */
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent details = new Intent(MainListActivity.this, DetailedCodeActivity.class);
                System.out.print(position);
                startActivity(details);
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}