package com.example.jorge.firebaseimplementationtrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    DatabaseFunctions dbFN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         dbFN = new DatabaseFunctions();
        User localUser = dbFN.StartDB();


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbFN.removeListener();
    }
}
