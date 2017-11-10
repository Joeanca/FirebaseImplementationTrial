package com.example.jorge.firebaseimplementationtrial;

import android.provider.ContactsContract;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by joeanca on 2017-11-08.
 */

public class DatabaseFunctions {
    // ENTRY POINT FOR THE APP TO ACCESS THE DATABASE
    private FirebaseDatabase mFirebaseDatabase;

    // SPECIFIC PART REFERENCE TO THE DATABASE IT ONLY GOES TO THE USER
    private DatabaseReference mUserDatabaseReference;

    // A CHILD LISTENER FOR THE
    private ChildEventListener mChildEventListener;

    // LOCAL USER
    User currentUser;

    String uID;

    public void StartDB(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        // TODO get the user from firebase UI and insert it into the next line.


        // GET USER WITH uID = Firbase UI GUID
         uID = "ipsoLoremTotem";
        String email = "juan@taco.com";
        String name = "juan More Taco";
        mUserDatabaseReference = mFirebaseDatabase.getReference().child("users").child(uID);

        currentUser = retrieveUserFromDatabase();
        if (currentUser == null) {
            //INITIALIZE USER
            currentUser = new User(uID, name, email, null, null);
            mUserDatabaseReference.setValue(currentUser);
            //Log.d("currentUser", "StartDB: " + currentUser.toString());

        }
    }

    private User retrieveUserFromDatabase() {

        DatabaseReference mUserReference = FirebaseDatabase.getInstance().getReference()
                .child("users").child(uID);
        currentUser = mUserReference.getClass();
        Log.d("mUserReference", "retrieveUserFromDatabase: " +mUserReference);
        mUserReference.addChildEventListener(new ChildEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {

                    Log.d("currentUser", "StartDB: " + currentUser.toString());

                }
            }

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return currentUser;
    }

    private void StartZones(DatabaseReference userReference){
        List<Zone> zoneList;
        DatabaseReference mZonesDBReference = mUserDatabaseReference.child("zones");
        // TO ADD A USER. OR PUSH INFORMATION TO THE DATABASE SETTING UP LISTENERS
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // THIS IS WHEN SOMETHING IS INSERTED INTO THE CHILDREN OR AT START TO INSERT ALL THE ZONES/ SCHEDULES

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                // THIS GETS CALLED WHEN THE CONTENTS OF THE CHILD GETS CHANGED

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                // THIS GETS CALLED WHEN THE CHILD IS DELETED
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                // IF ONE OF THE MESSAGES CHANGES POSITION
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // SOME ERROR OCCURRED WHEN TRYING TO MAKE CHANGES
            }
        };

        mZonesDBReference.addChildEventListener(mChildEventListener);
    }

    private void StartSchedule(){
        DatabaseReference mScheduleDBReference = mUserDatabaseReference.child("zones");

        // TO ADD A USER. OR PUSH INFORMATION TO THE DATABASE SETTING UP LISTENERS
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // THIS IS WHEN SOMETHING IS INSERTED INTO THE CHILDREN OR AT START TO INSERT ALL THE ZONES/ SCHEDULES
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                // THIS GETS CALLED WHEN THE CONTENTS OF THE CHILD GETS CHANGED
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                // THIS GETS CALLED WHEN THE CHILD IS DELETED
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                // IF ONE OF THE MESSAGES CHANGES POSITION
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // SOME ERROR OCCURRED WHEN TRYING TO MAKE CHANGES
            }
        };

        mScheduleDBReference.addChildEventListener(mChildEventListener);
    }



}
